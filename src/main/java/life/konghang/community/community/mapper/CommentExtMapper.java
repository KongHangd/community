package life.konghang.community.community.mapper;

import life.konghang.community.community.model.Comment;
import life.konghang.community.community.model.CommentExample;
import life.konghang.community.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment record);
}