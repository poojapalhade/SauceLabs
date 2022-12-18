package SauceLabs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.DataProviderForAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvierDemo
{
	public static WebDriver driver;
	WebElement e;
	@Test(dataProvider="logindata",dataProviderClass=DataProviderForAll.class)
	public void checkLogin(String username,String password)
	{
		//System.out.println(username+"    "+password);
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		sendText("ID", "user-name", username);
		sendText("ID", "password", password);
		click("ID", "login-button");
		
		String s=getTest("XPATH", "//span[text()='Products']");
		Assert.assertEquals(s, "PRODUCTS");
		driver.close();
	}
	
	
	public static WebElement findElement(String LocType, String value)
	{
		WebElement e=null; 
		switch (LocType) {
		case "XPATH":e=driver.findElement(By.xpath(value));
					break;
		case "CNAME":e=driver.findElement(By.className(value));
					break;
		case "ID":e=driver.findElement(By.id(value));
					break;
		case "NAME":e=driver.findElement(By.name(value));
					break;
		case "PARTIALLINKEDTEXT": e=driver.findElement(By.partialLinkText(value));
					break;
		case "CSSSELECTOR":e=driver.findElement(By.cssSelector(value));
					break;

		default:System.out.println("Invalid selector");
			break;
		}
		return e;
	}
	
	public void sendText(String LocType,String value,String text) {
		e=findElement(LocType, value);
		e.sendKeys(text);
	}
	public void click(String LocType,String value)
	{
		 e=findElement(LocType, value);
		 e.click();
	}
	public String getTest(String LocType,String value)
	{
		e=findElement(LocType, value);
		return e.getText();
	}
}
