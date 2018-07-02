package com.seytar.survey.Answer;

import com.seytar.survey.IdentitableInterface;
import com.seytar.survey.Identity;
import com.seytar.survey.Question.QuestionAbstract;

abstract public class AnswerAbstract<T extends QuestionAbstract> implements IdentitableInterface, Cloneable {
    private Identity identity;
    private String title;
    private T question;
    private Double point;

    public AnswerAbstract() {}

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

    abstract public String getKey();

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

    public AnswerAbstract clone() throws CloneNotSupportedException {
        return (AnswerAbstract) super.clone();
    }
}
