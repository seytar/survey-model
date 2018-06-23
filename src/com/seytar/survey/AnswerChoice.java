package com.seytar.survey;

public class AnswerChoice extends AnswerAbstract {
    public AnswerChoice(Identity identity, String title, QuestionAbstract question) {
        super(identity, title, question);
    }

    public AnswerChoice(Identity identity, String title, QuestionAbstract question, Double point) {
        super(identity, title, question, point);
    }

    @Override
    public String getKey() { return "choice"; }
}
