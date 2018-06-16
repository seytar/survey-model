package com.seytar;

import java.util.ArrayList;

public class Survey<T extends QuestionAbstract> implements IdentitableInterface {
    private Identity identity;
    private String title;
    private ArrayList<T> questions = new ArrayList();

    public Survey(Identity identity, String title) {
        setIdentity(identity);
        setTitle(title);
    }

    public Survey(Identity identity, String title, ArrayList<T> questions) {
        this(identity, title);
        for (T question: questions) {
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

    public void addQuestion(T question) {
        questions.add(question);
    }

    public ArrayList<T> getQuestions() {
        return questions;
    }
}
