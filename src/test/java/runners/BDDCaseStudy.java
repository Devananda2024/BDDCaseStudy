package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "src/test/resources/features/",
			glue = {"StepDefs"},
			monochrome = true,
			plugin = {"pretty",
			"html:target/reports/HTMLReport.html",
			"usage:target/reports/UsageReport",
			"json: target/reports/JsonReport.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			}
//			dryRun = false

			)
	
	public class BDDCaseStudy extends AbstractTestNGCucumberTests {
		
		

}
