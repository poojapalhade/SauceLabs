package Util;

import org.testng.annotations.DataProvider;

public class DataProviderForAll 
{
	@DataProvider(name="logindata")
	public Object[][] loginData()
	{
		Object[][] loginData=new Object[3][2];
		loginData[0][0]="standard_user";
		loginData[0][1]="secret_sauce";
		loginData[1][0]="performance_glitch_user";
		loginData[1][1]="secret_sauce";
		loginData[2][0]="problem_user";
		loginData[2][1]="secret_sauce";
		return loginData;
	}
}
