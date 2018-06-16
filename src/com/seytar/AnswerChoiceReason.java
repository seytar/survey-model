package com.seytar;

public class AnswerChoiceReason extends AnswerAbstract {
    public AnswerChoiceReason(Identity identity, String title, QuestionAbstract question) {
        super(identity, title, question);
    }

    public AnswerChoiceReason(Identity identity, String title, QuestionAbstract question, Double point) {
        super(identity, title, question, point);
    }

    @Override
    public String getKey() {
        return "choice-reason";
    }
}
