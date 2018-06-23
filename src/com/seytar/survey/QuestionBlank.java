package com.seytar.survey;

import java.util.ArrayList;

public class QuestionBlank extends QuestionAbstract {
    @Override
    public String getKey() {
        return "blank";
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
