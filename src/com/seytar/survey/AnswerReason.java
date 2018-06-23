package com.seytar.survey;

public class AnswerReason extends AnswerAbstract {
    public AnswerReason(Identity identity, String title, QuestionAbstract question) {
        super(identity, title, question);
    }

    public AnswerReason(Identity identity, String title, QuestionAbstract question, Double point) {
        super(identity, title, question, point);
    }

    @Override
    public String getKey() {
        return "reason";
    }
}
