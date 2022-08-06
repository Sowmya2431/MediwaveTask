package MediWave;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.seleniumeasy.com/");
		
		//Select Selenium from Homepage
		driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]")).click();

		//Open Selenium with Java in new window
		WebElement link = driver.findElement(By.linkText("Selenium with Java"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(6000);
		
		//Handle the window
		Set<String> handles = driver.getWindowHandles();
		List<String> list=new ArrayList<>(handles);
		driver.switchTo().window(list.get(1));
		System.out.println("The current Title: "+ driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(list.get(0));
		System.out.println("The current Title: "+ driver.getTitle());
		
		
	}

}
