package com.epam.lab.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/test/resources/gmail.feature", glue = {"com.epam.lab.bdd"}, format = {"pretty", "html:target/cucumber-html-report"})
    public class TestGmail {

    }
