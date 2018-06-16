package com.sivaz;

public class Main {

    public static void main(String[] args) {
	    Identity surveyId = new Identity("survey-identity");
        Survey survey = new Survey(surveyId, "Survey Title");

        System.out.println(survey.getIdentity().getKey());
    }
}
