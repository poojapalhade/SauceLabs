package ListenerDemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


@SuppressWarnings("deprecation")
public class A 
{
	@BeforeSuite
	public void run()
	{
		System.out.println("Beforesuit run class A");
	}

	@AfterSuite
	public void fun()
	{
		System.out.println("@AfterSuite fun class A");
	}

	@BeforeClass
	public void bun()
	{
		System.out.println("@BeforeClass  bun class A");
	}

	@AfterClass
	public void doAfterClass()
	{
		System.out.println("@AfterClass doAfterClass class A");
	}
	@BeforeMethod
	public void sun()
	{
		System.out.println("@@BeforeMethod  sun class A");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("@@afterMethod  afterMethod class A");
	}
	@Test
	public void test1()
	{
		Assert.assertEquals(true, false);
	}
	@Test
	public void test2()
	{
		Assert.assertEquals(true, true);
	}
	
	
	
}
