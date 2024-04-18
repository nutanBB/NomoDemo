package com.qa.interview.stepDefinitions;

import io.cucumber.java.en.Given;

public class StepDefinition {

    @Given("^User is launches the app$")
    public void launchApp(){
        System.out.println("App launched");
    }
}
