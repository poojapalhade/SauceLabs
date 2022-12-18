package SauceLabs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckLogin extends BaseTest
{
	@Test
	public void login()
	{
		sendText("ID", "user-name", "standard_user");
		sendText("ID", "password", "secret_sauce");
		click("ID", "login-button");
		
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//driver.findElement(By.id("login-button")).click();
		//WebElement e=driver.findElement(By.xpath("//span[text()='Products']"));
		String s=getTest("XPATH", "//span[text()='Products']");
		Assert.assertEquals(s, "PRODUCTS");
	}
}
