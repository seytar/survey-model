package com.seytar;

abstract public class AnswerAbstract<T extends QuestionAbstract> implements IdentitableInterface {
    private Identity identity;
    private String title;
    private T question;
    private Double point;

    public AnswerAbstract(Identity identity, String title, T question) {
        this.setIdentity(identity);
        this.setTitle(title);
        this.setQuestion(question);
    }

    public AnswerAbstract(Identity identity, String title, T question, Double point) {
        this(identity, title, question);
        this.setPoint(point);
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

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public T getQuestion() {
        return question;
    }

    public void setQuestion(T question) {
        this.question = question;
    }
}
