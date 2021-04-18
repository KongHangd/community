package life.konghang.community.community.mapper;

import life.konghang.community.community.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}