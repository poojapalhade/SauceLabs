package ListenerDemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class B 
{

	@SuppressWarnings("deprecation")
	@Test
	public void test1()
	{
		System.out.println("test1 Test in class B");
		Assert.assertEquals(true, false);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void test2()
	{
		Assert.assertTrue(true);
		System.out.println("tests Test in class B");
	}
	
}
