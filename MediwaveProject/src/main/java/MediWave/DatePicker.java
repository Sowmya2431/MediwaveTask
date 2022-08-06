package MediWave;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		
		//Click on the datepicker
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		List<WebElement> sep = driver.findElements(By.xpath("//td[@data-month='8']//a"));
		
		for (int i = 0; i < sep.size(); i++) {
			
			System.out.println("Dates of September:" + sep.get(i).getText());
			}
		System.out.println("***************************************************");
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Dates of September:" + sep.get(i).getText());
			System.out.println("Summer");
			}
		System.out.println("***************************************************");
		
		for (int i = 10; i <20; i++) {
			System.out.println("Dates of September:" + sep.get(i).getText());
			System.out.println("Winter");
			}
		System.out.println("***************************************************");
		
		for (int i = 20; i <30; i++) {
			System.out.println("Dates of September:" + sep.get(i).getText());
			System.out.println("Spring");
			}
		System.out.println("***************************************************");
		
	}

}
