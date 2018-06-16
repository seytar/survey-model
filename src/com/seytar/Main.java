package com.seytar;

public class Main {

    public static void main(String[] args) {
        Identity surveyId = new Identity("survey-identity");
        Survey survey = new Survey(surveyId, "Survey Title");

        System.out.println(survey.getIdentity().getKey());

        Identity survey2Id = new Identity(1001);
        Survey survey2 = new Survey(survey2Id, "Survey2 Title");

        System.out.println(survey2.getIdentity().getKey());
    }
}
