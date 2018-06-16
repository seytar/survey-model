package com.seytar;

public class AnswerOpenEnded extends AnswerAbstract {
    public AnswerOpenEnded(Identity identity, String title, QuestionAbstract question) {
        super(identity, title, question);
    }

    public AnswerOpenEnded(Identity identity, String title, QuestionAbstract question, Double point) {
        super(identity, title, question, point);
    }

    @Override
    public String getKey() {
        return "open-ended";
    }
}
