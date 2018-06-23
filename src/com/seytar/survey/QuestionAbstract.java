package com.seytar.survey;

import java.util.ArrayList;

abstract public class QuestionAbstract<T extends AnswerAbstract> implements IdentitableInterface {
    private Identity identity;
    private String title;
    private ArrayList<T> answers = new ArrayList();

    public QuestionAbstract() {}

    public QuestionAbstract(Identity identity, String title) {
        this.setIdentity(identity);
        this.setTitle(title);
    }

    public QuestionAbstract(Identity identity, String title, ArrayList<T> answers) {
        this(identity, title);
        for (T answer: answers) {
            addAnswer(answer);
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

    abstract public String getKey();
    abstract public ArrayList<String> getAvailableAnswerTypes();
    abstract public String getChoiceType();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addAnswer(T answer) {
        answer.setQuestion(this);
        answers.add(answer);
    }

    public ArrayList<T> getAnswers() {
        return answers;
    }

    public final class ChoiceType {
        public static final String CHOICE_TYPE_SINGLE = "single";
        public static final String CHOICE_TYPE_MULTIPLE = "multiple";
        public static final String CHOICE_TYPE_NONE = "none";
        public static final String CHOICE_TYPE_UNDEFINED = "undefined";
    }
}
