package com.seytar.survey.Question;

import com.seytar.survey.Answer.AnswerChoice;
import com.seytar.survey.Answer.AnswerOpenEnded;

import java.util.ArrayList;

public class QuestionCore extends QuestionAbstract {
    @Override
    public String getKey() {
        return "core";
    }

    @Override
    public ArrayList<Class> getAvailableAnswerTypes() {
        ArrayList<Class> availableAnswerTypes = new ArrayList<Class>();
        availableAnswerTypes.add(AnswerChoice.class);
        availableAnswerTypes.add(AnswerOpenEnded.class);
        return availableAnswerTypes;
    }

    @Override
    public String getChoiceType() {
        return ChoiceType.CHOICE_TYPE_MULTIPLE;
    }
}