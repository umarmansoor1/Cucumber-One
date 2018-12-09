package com.syntax.cucumberproject.test.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(features="C:\\Users\\Owner\\eclipse-workspace\\CumberProject\\src\\test\\resources\\features\\Login.feature"
	, glue="C:\\Users\\Owner\\eclipse-workspace\\CumberProject\\src\\test\\java\\com\\syntax\\cucumberproject\\test\\stepDefinitions\\LoginSteps.java")
	public class LoginRunner {

		
		
}
