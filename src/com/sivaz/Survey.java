package com.sivaz;

import java.util.ArrayList;

public class Survey implements IdentitableInterface {
    private Identity identity;
    private String title;
    private ArrayList<QuestionAbstract> questions = new ArrayList();

    public Survey(Identity identity, String title) {
        setIdentity(identity);
        setTitle(title);
    }

    public Survey(Identity identity, String title, ArrayList<QuestionAbstract> questions) {
        this(identity, title);
        for (QuestionAbstract question: questions) {
            addQuestion(question);
        }
    }

    @Override
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    @Override
    public Identity getIdentity() {
        return identity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(QuestionAbstract question) {
        questions.add(question);
    }

    public ArrayList<QuestionAbstract> getQuestions() {
        return questions;
    }
}
