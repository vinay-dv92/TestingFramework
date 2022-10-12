package testcase;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base.BaseTest;


public class Login extends BaseTest {

	@Test
	public static void addfarmertest() throws IOException, InterruptedException

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Farmer_Menu")))).click();
		Thread.sleep(2000);
		clickButton("Farmer_SubMenu");
		Thread.sleep(2000);
		clickButton("Add_Farmer");
		Thread.sleep(2000);
		clickButton("Dropdown");
		Thread.sleep(2000);
		driver.findElement(By.id("react-select-8-option-1")).click();
		sendKeyOnWebElement("textBox_FarmerFullName", "Raju");
		Thread.sleep(2000);

		


	}
}