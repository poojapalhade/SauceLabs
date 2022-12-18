package SauceLabs;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest 
{
	WebElement e;
	public static WebDriver driver;
	static Logger log=LogManager.getLogger(BaseTest.class.getName());
	@BeforeSuite
	public void setup()
	{
		log.info("Initilizing connection");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		log.debug("connection successful");
	}
	public static WebElement findElement(String LocType, String value)
	{
		log.info("Element finded");
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
