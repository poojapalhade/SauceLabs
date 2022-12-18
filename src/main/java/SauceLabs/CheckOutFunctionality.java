package SauceLabs;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutFunctionality extends BaseTest{
	@Test
	public void checkout() throws IOException
	{
		findElement("ID", "checkout").click();
		String s=findElement("XPATH", "//span[text()='Checkout: Your Information']").getText();
		assertEquals(s, "CHECKOUT: YOUR INFORMATION");
		sendText("ID", "first-name","Pooja");
		sendText("ID","last-name","P");
		sendText("ID", "postal-code", "123");
		click("ID", "continue");
		Assert.assertEquals("CHECKOUT: OVERVIEW","CHECKOUT: OVERVIEW");
		click("ID", "finish");
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/screen.png"));
		
		
		Assert.assertEquals("CHECKOUT: COMPLETE!\r\n"
				+ "", "CHECKOUT: COMPLETE!\r\n"
						+ "");
		
	}

}
