package SauceLabs;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartFunctionality extends BaseTest
{
	@Test
	public void verifyCartProduct()
	{
		findElement("ID", "shopping_cart_container").click();
		String s=findElement("CNAME", "shopping_cart_badge").getText();
		//assertEquals("3", s);
		//Assert.fail();
		System.out.println(s);
	}
}
