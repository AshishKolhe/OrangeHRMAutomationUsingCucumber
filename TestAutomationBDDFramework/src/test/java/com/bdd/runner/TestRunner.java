package com.bdd.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;


@CucumberOptions(features="src/main/resources/features", glue="com.bdd.steps", tags="@LoginFunc", 
plugin= {"pretty","html:target/cucumber-reports.html", "json:target/cucumber.json"}, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	TestNGCucumberRunner testngcucumber = new  TestNGCucumberRunner(this.getClass());

}
