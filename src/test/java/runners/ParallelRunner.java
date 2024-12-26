package runners;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {"StepDefs"},
		monochrome = true,
		plugin = {"pretty",
				"html:target/reports/HTMLReport.html"
		}
				
		)


public class ParallelRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = true)
	public Object[] [] scenarios ()
	{ return super.scenarios();
		
		
	}

}
