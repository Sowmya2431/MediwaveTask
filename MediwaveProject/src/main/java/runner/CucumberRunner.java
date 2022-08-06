package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefinitionFile.BaseClass;

@CucumberOptions(features = "src/main/java/features",glue = "stepDefinitionFile",monochrome = true,publish = true)

public class CucumberRunner extends BaseClass{

}
