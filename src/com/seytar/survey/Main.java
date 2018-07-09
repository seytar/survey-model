package com.seytar.survey;

import com.seytar.survey.Answer.AnswerAbstract;
import com.seytar.survey.Question.QuestionAbstract;
import com.seytar.survey.Question.QuestionMultipleChoice;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Identity surveyId = new Identity("survey-identity");
        Survey survey = new Survey(surveyId, "Survey Title");
        System.out.println(survey.getIdentity().getKey());

        Identity survey2Id = new Identity(1001);
        Survey survey2 = new Survey(survey2Id, "Survey2 Title");
        System.out.println(survey2.getIdentity().getKey());

        Identity questionMultipleIdentity = new Identity("Some multiple question identity");
        QuestionMultipleChoice qm = new QuestionMultipleChoice(questionMultipleIdentity, "Abece");
        Class c = (Class) qm.getAvailableAnswerTypes().get(0);
        AnswerAbstract ac = (AnswerAbstract) c.getDeclaredConstructor().newInstance();
        Identity questionMultipleAnswerIdentity = new Identity("Some multiple question answer identity");
        ac.setIdentity(questionMultipleAnswerIdentity);
        System.out.println(ac.getIdentity().getKey());

        survey2.addQuestion(qm);

        for (QuestionAbstract question: (ArrayList<QuestionAbstract>) survey2.getQuestions()) {
            System.out.println(question.getTitle());
        }
    }
}
