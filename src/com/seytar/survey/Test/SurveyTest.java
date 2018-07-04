package com.seytar.survey.Test;

import com.seytar.survey.Answer.AnswerAbstract;
import com.seytar.survey.Identity;
import com.seytar.survey.Question.*;
import com.seytar.survey.Survey;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class SurveyTest {
    private static final String SURVEY_IDENTITY_STRING = "survey-identity-string";
    private static final Integer SURVEY_IDENTITY_INTEGER = 1001;

    private static final String SURVEY_TITLE1 = "Survey Title 1";
    private static final String SURVEY_TITLE2 = "Survey Title 2";

    private Survey survey1;
    private Survey survey2;

    private static final String TITLE_QMC = "What is your choice?";
    private static final String TITLE_QYN = "Yes or No?";
    private static final String TITLE_QB = "My name is {?}. I'am from {?}. Please fill your answers.";
    private static final String TITLE_QC = "Feel free for choice any answer(s).";
    private static final String TITLE_QM = "You can fill/choice every columns for each rows.";
    private static final String TITLE_QOE = "Please explain your choices.";

    private static final Class CLASS_QMC = QuestionMultipleChoice.class;
    private static final Class CLASS_QYN = QuestionYesNo.class;
    private static final Class CLASS_QB = QuestionBlank.class;
    private static final Class CLASS_QC = QuestionCore.class;
    private static final Class CLASS_QM = QuestionMatrix.class;
    private static final Class CLASS_QOE = QuestionOpenEnded.class;

    private QuestionMultipleChoice QUESTION_QMC;
    private QuestionYesNo QUESTION_QYN;
    private QuestionBlank QUESTION_QB;
    private QuestionCore QUESTION_QC;
    private QuestionMatrix QUESTION_QM;
    private QuestionOpenEnded QUESTION_QOE;

    private static final String[] questionKeys = {"QMC", "QYN", "QB", "QC", "QM", "QOE"};

    private void makeSurveys() {
        Identity surveyIdString = new Identity(SURVEY_IDENTITY_STRING);
        survey1 = new Survey(surveyIdString, SURVEY_TITLE1);

        Identity surveyIdInteger = new Identity(SURVEY_IDENTITY_INTEGER);
        survey2 = new Survey(surveyIdInteger, SURVEY_TITLE2);
    }

    private void makeQuestions() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        for (String qKey: questionKeys) {
            Class qClass = (Class) getClass().getDeclaredField("CLASS_" + qKey).get(this);
            String qTitle = (String) getClass().getDeclaredField("TITLE_" + qKey).get(this);

            QuestionAbstract question = (QuestionAbstract) qClass.getDeclaredConstructor().newInstance();
            question.setIdentity(new Identity("ID-" + qKey));
            question.setTitle(qTitle);

            getClass().getDeclaredField("QUESTION_" + qKey).set(this, question);
        }
    }

    @org.junit.jupiter.api.Test
    public void testingIdentityKeyStringAndInteger() {
        makeSurveys();

        assertEquals(survey1.getIdentity().getKey(), SURVEY_IDENTITY_STRING);
        assertEquals(survey2.getIdentity().getKey(), SURVEY_IDENTITY_INTEGER);
    }

    @org.junit.jupiter.api.Test
    public void testingSetGetIdentity() {
        makeSurveys();

        Identity newSurveyId = new Identity(SURVEY_IDENTITY_INTEGER);
        survey1.setIdentity(newSurveyId);
        assertEquals(survey1.getIdentity().getKey(), SURVEY_IDENTITY_INTEGER);
    }

    @org.junit.jupiter.api.Test
    public void testingSetGetTitle() {
        makeSurveys();

        String newTitleString = "New Survey Title";
        survey1.setTitle(newTitleString);
        assertEquals(survey1.getTitle(), newTitleString);
    }

    @org.junit.jupiter.api.Test
    public void testingAddGetQuestion() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        makeSurveys();
        makeQuestions();

        for (String qKey: questionKeys) {
            QuestionAbstract question = (QuestionAbstract) getClass().getDeclaredField("QUESTION_" + qKey).get(this);
            survey1.addQuestion(question);
            Integer questionIndex = survey1.getQuestions().indexOf(question);
            QuestionAbstract q = (QuestionAbstract) survey1.getQuestions().get(questionIndex);
            assertEquals(question, q);
        }
    }
}