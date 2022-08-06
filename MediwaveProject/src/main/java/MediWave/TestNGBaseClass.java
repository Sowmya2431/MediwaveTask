package MediWave;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGBaseClass {
	public RemoteWebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testType,testAuthor;
	
	
	@BeforeSuite
	public void startReport() {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	@BeforeClass
	public void testcaseDetails() {
		
		ExtentTest test=extent.createTest(testName, testDescription);
		test.assignCategory("testType");
		test.assignAuthor("testAuthor");
		}
public int takeSnap() throws IOException {
	int ranNum = (int) (Math.random()*9999999+10000000);
	
	File source = driver.getScreenshotAs(OutputType.FILE);
	File target = new File("./snaps/img"+ranNum+".png"); //img11400268.png
	FileUtils.copyFile(source, target);
	return ranNum;
	}

	
	public void reportStep(String stepDesc, String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			int ranNum = takeSnap();
			test.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+ranNum+".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			int ranNum = takeSnap();
			test.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+ranNum+".png").build());
			throw new RuntimeException("Please check the report for more details");
		}
	}
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	
	
	@Parameters({"browser" , "url"})
	@BeforeMethod
	public void preConditions(String browser,String url) {
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();  
		driver=new ChromeDriver();
	}else if (browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();  
		driver=new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	}
	
	@AfterMethod
	public void postConditions() {
		driver.close();
	}
	

}
