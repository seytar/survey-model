package com.seytar.survey.Question;

import com.seytar.survey.Answer.AnswerAbstract;
import com.seytar.survey.Answer.AnswerOpenEnded;
import com.seytar.survey.Identity;

import java.util.ArrayList;

public class QuestionBlank<T extends AnswerAbstract> extends QuestionAbstract {

    public QuestionBlank() {
        super();
    }

    public QuestionBlank(Identity identity, String title) {
        super(identity, title);
    }

    public QuestionBlank(Identity identity, String title, ArrayList<T> answers) {
        super(identity, title, answers);
    }

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
