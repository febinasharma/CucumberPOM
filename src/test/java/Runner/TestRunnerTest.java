package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:/Users/febin/eclipse-workspace/CucumberPOM/src/test/resource/com/qa/features/homePage.feature",
		glue= {"com.qa.stepDefinitions"},
		dryRun=false,
		monochrome = true,
		plugin={"pretty","html:target/HtmlReports","json:target/JSONReports/report.json","junit:target/JUnitReports/report.xml"}
		
		)
public class TestRunnerTest {

}
