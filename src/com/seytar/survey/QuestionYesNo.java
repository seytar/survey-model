package com.seytar.survey;

import java.util.ArrayList;

public class QuestionYesNo extends QuestionAbstract {
    @Override
    public String getKey() {
        return "yes-no";
    }

    @Override
    public ArrayList<Class> getAvailableAnswerTypes() {
        ArrayList<Class> availableAnswerTypes = new ArrayList<Class>();
        availableAnswerTypes.add(AnswerChoice.class);
        availableAnswerTypes.add(AnswerReason.class);
        return availableAnswerTypes;
    }

    @Override
    public String getChoiceType() {
        return ChoiceType.CHOICE_TYPE_SINGLE;
    }
}
