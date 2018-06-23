package com.seytar.survey;

import java.util.ArrayList;

public class QuestionOpenEnded extends QuestionAbstract {
    @Override
    public String getKey() {
        return "open-ended";
    }

    @Override
    public ArrayList<Class> getAvailableAnswerTypes() {
        ArrayList<Class> availableAnswerTypes = new ArrayList<Class>();
        availableAnswerTypes.add(AnswerOpenEnded.class);
        return availableAnswerTypes;
    }

    @Override
    public String getChoiceType() {
        return ChoiceType.CHOICE_TYPE_NONE;
    }
}
