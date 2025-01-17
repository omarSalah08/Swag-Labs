package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Feature",
        glue = "StepDef",
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml","rerun:target/rerun.txt"},
        tags = "@test"
)

public class TestRunners extends AbstractTestNGCucumberTests {

}
