package Util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;

import SauceLabs.BaseTest;

public class ScreenCapture 
{
	public void capturScreen(ITestResult result) throws IOException
	{
		/*
		 * Date currentDate=new Date(); System.out.println("CurrentDate="+currentDate);
		 * String screenshotname=currentDate.toString().replace(" " , "-").replace(":",
		 * "-"); System.out.println(screenshotname); File screenshotFile =
		 * ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(screenshotFile, new
		 * File(".//screenshot/"+screenshotname+".png")); return screenshotFile+".png";
		 */
		
		Calendar calendar = Calendar.getInstance();
	    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	    String methodName = result.getName();
	    if(!result.isSuccess()){
	        File scrFile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
	        try {
	            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/screnshots/failure ";
	            File destFile = new File((String) reportDirectory+methodName+"_"+formater.format(calendar.getTime())+".png");
	            FileUtils.copyFile(scrFile, destFile);
	            System.out.println("Failuere report path"+destFile.toString());
	            Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	}
}
