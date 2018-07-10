package com.seytar.survey.Question;

import com.seytar.survey.Answer.AnswerAbstract;
import com.seytar.survey.IdentitableInterface;
import com.seytar.survey.Identity;

import java.security.InvalidParameterException;
import java.util.ArrayList;

abstract public class QuestionAbstract<T extends AnswerAbstract, TQ extends QuestionAbstract> implements IdentitableInterface, Cloneable {
    private Identity identity;
    private String title;
    private ArrayList<T> answers = new ArrayList<T>();
    private ArrayList<TQ> subQuestions = new ArrayList<TQ>();
    private TQ parentQuestion;
    private Class subQuestionType;

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
    abstract public ArrayList<Class> getAvailableAnswerTypes();
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

    public TQ getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(TQ parentQuestion) {
        this.parentQuestion = parentQuestion;
    }

    public Boolean isParentable() {
        return false;
    }

    public void setSubQuestionType(Class subQuestionClass) {
        this.subQuestionType = subQuestionClass;
    }

    public Class getSubQuestionType() {
        return subQuestionType;
    }

    public void addSubQuestion(TQ question) throws CloneNotSupportedException, InvalidParameterException {
        if(getSubQuestionType() == null) throw new InvalidParameterException("Parentable question must have sub question type. Use setSubQuestionType(Class subQuestionClass) method.");
        if(question.getClass() != getSubQuestionType()) throw new InvalidParameterException("The sub question must be " + getSubQuestionType() + " class.");

        question.setParentQuestion(this);
        for (T answer: getAnswers()) {
            question.addAnswer((T) answer.clone());
        }
        subQuestions.add(question);
    }

    public void setSubQuestions(ArrayList<TQ> subQuestions) {
        this.subQuestions = subQuestions;
    }

    public ArrayList<TQ> getSubQuestions() {
        return subQuestions;
    }

    public ArrayList<Class> getAvailableSubQuestionTypes() {
        ArrayList<Class> availableSubQuestionTypes = new ArrayList<Class>();
        return availableSubQuestionTypes;
    }

    public boolean subQuestionIsLegal(TQ question) {
        return getAvailableSubQuestionTypes().contains(question.getClass()) && question.getClass() == getSubQuestionType();
    }

    public QuestionAbstract clone() throws CloneNotSupportedException {
        return (QuestionAbstract) super.clone();
    }
}
