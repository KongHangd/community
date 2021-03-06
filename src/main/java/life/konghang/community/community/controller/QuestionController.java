package life.konghang.community.community.controller;

import life.konghang.community.community.dto.CommentDTO;
import life.konghang.community.community.dto.QuestionDTO;
import life.konghang.community.community.enums.CommentTypeEnum;
import life.konghang.community.community.service.CommentService;
import life.konghang.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id") Long id,Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        List<QuestionDTO> relatedQuestions=questionService.selectRelated(questionDTO);
        List<CommentDTO> comments=commentService.listByTargetId(id, CommentTypeEnum.QUESTION);

        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
