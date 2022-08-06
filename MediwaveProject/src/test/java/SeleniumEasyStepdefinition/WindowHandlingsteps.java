package SeleniumEasyStepdefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WindowHandlingsteps extends SeleniumEasyBC {
	
	@Given("Open the chrome browser")
	public void open_the_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	}
	@Given("Load the url")
	public void load_the_url() {
		driver.get("https://www.seleniumeasy.com/");
	}
	@When("Click on Selenium")
	public void click_on_selenium() {
		driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]")).click();
	}
	@Then("Open Selenium with Java in new window")
	public void open_selenium_with_java_in_new_window() {
		WebElement link = driver.findElement(By.linkText("Selenium with Java"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
	}
	@Then("Handle the new window")
	public void handle_the_new_window() {
		Set<String> handles = driver.getWindowHandles();
		List<String> list=new ArrayList<>(handles);
		driver.switchTo().window(list.get(1));
		System.out.println("The current Title: "+ driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(0));
		System.out.println("The current Title: "+ driver.getTitle());
	}


}
