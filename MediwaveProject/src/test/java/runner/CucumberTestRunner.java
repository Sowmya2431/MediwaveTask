package runner;

import SeleniumEasyStepdefinition.SeleniumEasyBC;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/seleniumeasyfeatures", glue = "SeleniumEasyStepdefinition",monochrome = true,publish=true)

public class CucumberTestRunner  extends SeleniumEasyBC{
	
	

}
