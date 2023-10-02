package ru.netology.pageobject;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty","summary"},
            features = {"src/test/resources/features"},
            glue = {"ru.netology.pageobject.steps"})

    public class RunCucumberTest {

    }
