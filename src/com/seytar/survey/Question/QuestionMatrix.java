package com.seytar.survey.Question;

import com.seytar.survey.Answer.AnswerChoice;
import com.seytar.survey.Answer.AnswerChoiceReason;
import com.seytar.survey.Answer.AnswerOpenEnded;
import com.seytar.survey.Answer.AnswerReason;

import java.util.ArrayList;

public class QuestionMatrix extends QuestionAbstract {
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
        return ChoiceType.CHOICE_TYPE_MULTIPLE;
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
        availableSubQuestionTypes.add(QuestionBlank.class);
        availableSubQuestionTypes.add(QuestionYesNo.class);
        return availableSubQuestionTypes;
    }
}
