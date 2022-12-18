package Util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import SauceLabs.BaseTest;


public class Listener implements ITestListener 
{
	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("inside onTestStart "+result.getTestName()+result);
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("Execution status --"+result.getStatus());
		
	}
	@Override
	public void onTestFailure(ITestResult result){
	   Reporter.log("Test Fails");
	   ScreenCapture o=new ScreenCapture();
	   try {
		o.capturScreen(result);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	  }
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	} 
	
}
