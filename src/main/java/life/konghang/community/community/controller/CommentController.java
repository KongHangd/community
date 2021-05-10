package life.konghang.community.community.controller;

import life.konghang.community.community.dto.CommentCreateDTO;
import life.konghang.community.community.dto.CommentDTO;
import life.konghang.community.community.dto.LikeCountDTO;
import life.konghang.community.community.dto.ResultDTO;
import life.konghang.community.community.enums.CommentTypeEnum;
import life.konghang.community.community.exception.CustomizeErrorCode;
import life.konghang.community.community.model.Comment;
import life.konghang.community.community.model.User;
import life.konghang.community.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;


    @ResponseBody
    @RequestMapping(value="/comment",method= RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request
                       ){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if(commentCreateDTO==null|| StringUtils.isBlank(commentCreateDTO.getContent())){
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment,user);
        return ResultDTO.okOf();
    }
    @ResponseBody
    @RequestMapping(value="/comment/like",method= RequestMethod.POST)
    public Object postlike(@RequestBody LikeCountDTO likeCountDTO,
                       HttpServletRequest request
    ){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setId(likeCountDTO.getId());
        comment.setLikeCount(1L);
        commentService.insertLikeCount(comment,user);
        return ResultDTO.okOf();
    }
    @ResponseBody
    @RequestMapping(value="/comment/{id}",method= RequestMethod.GET)
    public ResultDTO<List> comments(@PathVariable(name="id")Long id){
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}
