package stepDefinitionFile;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatepickerStepDefinitionFile extends BaseClass {
	
	
	@Given("Open the chrome browser")
	public void openBrowser() {
		// Open Chrome browser
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@And("Load the url")
	public void loadUrl() {
		
		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
	}
	@When ("Click on the Datepicker textbox field")
	public void clickDatepicker() {
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	}
	
	@When("Click on next button")
	public void clickNext() {
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
	}
	
	@Then("Print the dates of September month")
	public void printSepDates() {
		List<WebElement> sep = driver.findElements(By.xpath("//td[@data-month='8']//a"));
		
		for (int i = 0; i < sep.size(); i++) {
			
			System.out.println("Dates of September:" + sep.get(i).getText());
			}
		System.out.println("***************************************************");
	}

	
	@Then("Print the dates of Summer")
	public void printSummer() {
		List<WebElement> sep = driver.findElements(By.xpath("//td[@data-month='8']//a"));
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Dates of September:" + sep.get(i).getText());
			System.out.println("Summer");
			}
		System.out.println("***************************************************");
	}
	
	@Then("Print the dates of Winter")
	public void printWinter() {
		List<WebElement> sep = driver.findElements(By.xpath("//td[@data-month='8']//a"));
		
		for (int i = 10; i <20; i++) {
			System.out.println("Dates of September:" + sep.get(i).getText());
			System.out.println("Winter");
			}
		System.out.println("***************************************************");
		
	}
	
	@Then("Print the dates of Spring")
	public void printSpring() {
		List<WebElement> sep = driver.findElements(By.xpath("//td[@data-month='8']//a"));
		
		for (int i = 20; i <30; i++) {
			System.out.println("Dates of September:" + sep.get(i).getText());
			System.out.println("Spring");
			}
		System.out.println("***************************************************");
	}
}
