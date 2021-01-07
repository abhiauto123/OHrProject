package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/appFeatures"},
	       glue = {"com.stepDefinition","AppHooks"},
	       plugin= {"pretty",
	    		     "json:target/MyReports/report.json",
	    		     "junit:target/MyReports/report.xml"}
		         )

public class TestRunner {

}
