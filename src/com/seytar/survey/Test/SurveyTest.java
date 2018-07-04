package com.seytar.survey;

import com.seytar.survey.Question.QuestionAbstract;
import com.seytar.survey.Question.QuestionMultipleChoice;

import static org.junit.jupiter.api.Assertions.*;

public class SurveyTest {
    private static final String SURVEY_IDENTITY_STRING = "survey-identity-string";
    private static final Integer SURVEY_IDENTITY_INTEGER = 1001;

    private static final String SURVEY_TITLE1 = "Survey Title 1";
    private static final String SURVEY_TITLE2 = "Survey Title 2";

    private Survey survey1;
    private Survey survey2;

    private void makeSurveys() {
        Identity surveyIdString = new Identity(SURVEY_IDENTITY_STRING);
        survey1 = new Survey(surveyIdString, SURVEY_TITLE1);

        Identity surveyIdInteger = new Identity(SURVEY_IDENTITY_INTEGER);
        survey2 = new Survey(surveyIdInteger, SURVEY_TITLE2);
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
    public void testingAddGetQuestion() {
        makeSurveys();

        Identity questionMultipleIdentity = new Identity("Some multiple question identity");
        QuestionAbstract questionMultiple = new QuestionMultipleChoice(questionMultipleIdentity, "What is your choice?");
        survey1.addQuestion(questionMultiple);
        QuestionAbstract q = (QuestionAbstract) survey1.getQuestions().get(0x0);
        assertEquals(questionMultiple, q);
    }
}