package base;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadXLSdata;

@SuppressWarnings("unused")
public class BaseTest {

	public static WebDriver driver = null;
	public static Properties prop = new Properties();
	public static Properties Loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	FileInputStream fis;
	public static org.slf4j.Logger Logger = LoggerFactory.getLogger(BaseTest.class);

	@BeforeTest
	public void setUp() throws IOException, InterruptedException {

		if (driver == null) {
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fr1 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locator.properties");
			prop.load(fr);
			prop.load(fr1);
		}

		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium - Java\\chromedriver.exe"); //base
		    driver = new ChromeDriver(); //base
			driver.get(prop.getProperty("testurl")); //properties
		}
			else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl")); // properties
		}

	}

	@Test(dataProviderClass = ReadXLSdata.class, dataProvider = "test")
//	@Test(dataProvider="testdata")
	public void clogin(String Phonenumber) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("button_SignInWithPhone"))).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath(prop.getProperty("textBox_LoginPhNumber"))).sendKeys(Phonenumber);

		Thread.sleep(6000);
		driver.findElement(By.xpath(prop.getProperty("Validate")));
		Thread.sleep(6000);
		WebElement verifybutton = driver.findElement(By.xpath(prop.getProperty("verifybutton")));
		verifybutton.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("textBox_DigitCode"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("textBox_DigitCode"))).sendKeys("123456");
//    Assert.assertTrue(false);

		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("button_Continue"))).click();
		Thread.sleep(3000);
		driver.get("http://awsdev11.samaaru.com:3001/");
		Thread.sleep(3000);
	}
//this is for click Action

	public void clickingOnWebElement(WebElement element, long waitTimeInSecond) {
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSecond));
		WebElement elements = null;
		elements = webWait.until(ExpectedConditions.elementToBeClickable(element));
		elements.click();

	}

	public static void clickButton(String element) {
//		driver.findElement(By.xpath(xpath)).click();
		driver.findElement(By.xpath(prop.getProperty(element))).click();
	}

	// This is for sendkeys action : : on TextField

	public void senKeysOnWebElement(WebElement element, String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	public static void sendKeyOnWebElement(String element, String text) {
		driver.findElement(By.xpath(prop.getProperty(element))).sendKeys(text);
	}

	// This is for slecting dropdownlist
	public void selectByVisibleText(WebElement element, String text) {

		Select select = new Select(element);

		select.selectByVisibleText(text);
	}

	// accepting alert from UI

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	// MouseHovering from one element to other element

	public void mouseHoverAndClickOnElement(WebElement elemnt) {
		Actions action = new Actions(driver);
		action.moveToElement(elemnt).click().build().perform();
	}

	// getWindowHandle method

	public String getCurrentWindowID() {
		return driver.getWindowHandle();
	}

//	@DataProvider(name = "testdata")
//	public Object[][] tData()
// 	{
//	return new Object[][] {
//		{"1234510003"}
//	
//	};
//			
//	}
// 	@AfterTest
//	public void tearDown() {
//		driver.close();
//		System.out.println("teardown successful");
//    
//	}
	/*
	 * Screenshot screenshot=new
	 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(10000)).
	 * takeScreenshot(driver); try { ImageIO.write(screenshot.getImage(),"PNG",new
	 * File("screenshot//screenshot1.png")); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } Screenshot = new
	 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
	 * takeScreenshot(driver); ImageIO.write(Screenshot.getImage(), "jpg", new
	 * File("D:\\ElementScreenshot.jpg"));
	 */
}
