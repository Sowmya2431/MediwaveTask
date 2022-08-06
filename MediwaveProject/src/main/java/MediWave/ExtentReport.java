package MediWave;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public static void main(String[] args) throws IOException {
		// Common for all the test cases
		// Step1: Set up physical report path
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		
		// to keep the report history
		reporter.setAppendExisting(true);

		// Step2: Create object for ExtentReports
		ExtentReports extent = new ExtentReports();

		// Step3: attach the data with physical file
		extent.attachReporter(reporter);
		

		// Step4: Create a test cases and assign test details
											// testName 	//testDescription
		ExtentTest test = extent.createTest("Datepicker", "Print the dates of September month");
		test.assignCategory("Functional");
		test.assignAuthor("Sowmya");
				
		// Step5: Step level status
		test.pass("Open the chrome browser"); // if i use pass(), then test will be treated as passed
		test.pass("Load the url"); // if i use fail(), then test will be treated as failed
		test.pass("Click on the Datepicker textbox field");
		test.pass("Click on next button");
		test.pass("Print the dates of September month");
		test.pass("Print the dates of Summer");
		test.pass("Print the dates of Winter");
		test.pass("Print the dates of Spring");
		
		 //control still stays under reports folder; ../ to come out of the reports folder
		test.pass("Click Login button",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/desktop.png").build());
		
		
		// step6: Mandatory step
		extent.flush();
	}


}
