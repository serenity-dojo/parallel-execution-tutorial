package com.serenitydojo.tutorials.ecommerce.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Arrays;
import java.util.List;

public class ParameterDefinitions {
//
//    @ParameterType(".*")
//    public Actor actor(String actorName) {
//        return OnStage.theActorCalled(actorName);
//    }
//
//    @Before
//    public void setTheStage() {
//        OnStage.setTheStage(new OnlineCast());
//    }

    @ParameterType(".*")
    public List<String> commaSeparatedList(String parameter) {
    return Arrays.stream(parameter.split(",")).map(String::trim).toList();
    }

}
