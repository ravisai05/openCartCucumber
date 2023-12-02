package testrunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {".//Features//LoginFeatureUsingExcel.feature"},
    glue = "stepDefinition",
    plugin= {"pretty","html:reports/myreport.html","json:reports/myreport.json"},
    dryRun = false,
    monochrome = true,
    tags="@sanity"
)
public class TestRunner {
    // Your JUnit runner class
}
