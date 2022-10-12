package common;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.testUtils;

public class Listeners extends testUtils implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Start");

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestResult result) {

	}

	public void onFinish(ITestResult result) {

	}
}
