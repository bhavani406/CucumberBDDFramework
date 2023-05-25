package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = ".//Features/Customers.feature",
		//{".//Features/LoginFeature.feature",".//Features/Customers.feature"}
		glue="StepDefinition",
		//{".//StepDefinition/StepDef",".//StepDefinition/StepDef1"}
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:Reports/Report_newCustomer.html"},
		tags="@regression1"
		)
//"json:Reports/cucumberReport_json.json","junit:Reports/cucumberReport_xml.xml
public class Runner{

}