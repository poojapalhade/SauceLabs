package Util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter=0;
	int limit=3;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<limit)
		{
			System.out.println("Retrying-------------------------");
			counter++;
			return true;
		}
		return false;
	}

}
