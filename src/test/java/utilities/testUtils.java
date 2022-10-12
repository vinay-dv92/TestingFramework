package utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import base.BaseTest;

public class testUtils extends BaseTest{

	public void getScreenshot() throws IOException  {
		// TODO Auto-generated method stub
Date currentdate = new Date(0);

String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":","-");
File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + ".png"));
Reporter.log("<a target= \"_blank\" href=.//screenshot//\" + screenshotfilename + \".png</a>");
	}
	
}
