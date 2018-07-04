package com.seytar.survey.Question;

import com.seytar.survey.Answer.AnswerAbstract;
import com.seytar.survey.Answer.AnswerChoice;
import com.seytar.survey.Answer.AnswerReason;
import com.seytar.survey.Identity;

import java.util.ArrayList;

public class QuestionYesNo<T extends AnswerAbstract> extends QuestionAbstract {

    public QuestionYesNo() {
        super();
    }

    public QuestionYesNo(Identity identity, String title) {
        super(identity, title);
    }

    public QuestionYesNo(Identity identity, String title, ArrayList<T> answers) {
        super(identity, title, answers);
    }

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
