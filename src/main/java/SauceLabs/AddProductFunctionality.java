package SauceLabs;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Util.ScreenCapture;

public class AddProductFunctionality extends BaseTest 
{
	
	public void verifyProduct(String Product)
	{
		driver.findElement(By.xpath("//div[text()='"+Product+"']//parent::a//parent::div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']//child::button")).click();
	}
	
	@Test
	public void addProduct()
	{
		verifyProduct("Sauce Labs Backpack");
		Reporter.log("Product added to card successfukky");
		verifyProduct("Test.allTheThings() T-Shirt (Red)");
		verifyProduct("Sauce Labs Onesie");
		Reporter.getCurrentTestResult();
	}
}
