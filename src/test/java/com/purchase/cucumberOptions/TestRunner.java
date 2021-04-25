package com.purchase.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/purchase/features/OnlinePurchase.feature", plugin = "json:target/jsonReports/cucumber-report.json", dryRun = false,
tags = {"@Dresspurchase" }, glue = { "com.purchase.stepdefinitions" }, monochrome = true)


public class TestRunner {

}