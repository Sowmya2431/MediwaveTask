package MediWave;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonMobiles extends TestNGBaseClass {
	
	@BeforeTest
	public void setData() {
		testName ="Amazon Mobiles";
		testDescription ="List Mobiles greather than 20000rs";
		testAuthor="Sowmya";
		testType="Functional";
	}
	
	@Test
	public void runAmazonMobiles() throws IOException {
		
		try {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("OnePlus");
			reportStep("OnePlus is successfully entered", "pass");
		} catch (Exception e) {
			reportStep("OnePlus is not successfully entered", "fail"  + e);
		}
		
		
		try {
			driver.findElement(By.id("nav-search-submit-button")).click();
			reportStep("Search is clicked", "pass");
		} catch (Exception e) {
			reportStep("Search is not clicked", "fail" +e);
		}
		try {
			List<WebElement> mobileLst = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span"));
			List<WebElement> priceLst = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			for(int i = 0; i < mobileLst.size(); i++ )	{
				for (int j = 0; j<priceLst.size(); j++) {
					String text = priceLst.get(j).getText();
					String replaceAll = text.replaceAll(",", "");
					int parseInt = Integer.parseInt(replaceAll);
					//Integer valueOf = Integer.valueOf(replaceAll);
					//Long valueOf = Long.valueOf(replaceAll);
					if (parseInt>= 20000) {
						System.out.println(mobileLst.get(i).getText());
						System.out.println(priceLst.get(j).getText());
					}
}

}
			reportStep("Mobiles greather than 20000rs are listed", "pass");
		} catch (NumberFormatException e) {
			reportStep("Mobiles greather than 20000rs are not listed", "fail"  +e);
		}
//	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//    FileUtils.copyFile(screenshotFile , new File("snapshots/screenshot.png"));
	}

	
}
