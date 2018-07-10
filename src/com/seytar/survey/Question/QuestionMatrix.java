package com.seytar.survey.Question;

import com.seytar.survey.Answer.*;
import com.seytar.survey.Identity;

import java.util.ArrayList;

public class QuestionMatrix<T extends AnswerAbstract> extends QuestionAbstract {

    public QuestionMatrix() {
        super();
    }

    public QuestionMatrix(Identity identity, String title) {
        super(identity, title);
    }

    public QuestionMatrix(Identity identity, String title, ArrayList<T> answers) {
        super(identity, title, answers);
    }

    @Override
    public String getKey() {
        return "matrix";
    }

    @Override
    public ArrayList<Class> getAvailableAnswerTypes() {
        ArrayList<Class> availableAnswerTypes = new ArrayList<Class>();
        availableAnswerTypes.add(AnswerChoice.class);
        availableAnswerTypes.add(AnswerChoiceReason.class);
        availableAnswerTypes.add(AnswerOpenEnded.class);
        availableAnswerTypes.add(AnswerReason.class);
        return availableAnswerTypes;
    }

    @Override
    public String getChoiceType() {
        return ChoiceType.CHOICE_TYPE_UNDEFINED;
    }

    @Override
    public Boolean isParentable() {
        return true;
    }

    @Override
    public ArrayList<Class> getAvailableSubQuestionTypes() {
        ArrayList<Class> availableSubQuestionTypes = new ArrayList<Class>();
        availableSubQuestionTypes.add(QuestionMultipleChoice.class);
        availableSubQuestionTypes.add(QuestionBlank.class);
        availableSubQuestionTypes.add(QuestionCore.class);
        availableSubQuestionTypes.add(QuestionOpenEnded.class);
        availableSubQuestionTypes.add(QuestionYesNo.class);
        return availableSubQuestionTypes;
    }
}
