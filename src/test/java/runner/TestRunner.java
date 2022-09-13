package runner;

import org.junit.AfterClass;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReportingConfig;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = ".\\src\\test\\resources\\Features", // classpath:Features
		glue = "stepDef", // here we provide path to step Def classes
		dryRun = false, // this set to False and it checks if any step in feature has step def 
		tags ="@outline", // we will run our scenarios using tags on top of each scenario
		monochrome = true, // this set to true so console output is readable
		strict = true, // this set to true so it will make the scenario failed if any steps failed
		plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"},
		publish = true // this set to true so we can have an execution report

)

public class TestRunner {
	@AfterClass
	public static void generateReport() {
		CucumberReportingConfig.reportConfig();
	}
	

}
