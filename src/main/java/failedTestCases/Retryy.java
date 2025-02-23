package failedTestCases;

import org.testng.IRetryAnalyzer;

import org.testng.ITestResult;

public class Retryy implements IRetryAnalyzer{
	int maxtry=1;
	int count=0;
	@Override
	public boolean retry(ITestResult iTestResult) {
		if(!iTestResult.isSuccess()) {
			if(count<maxtry) {
				count++;
				return true;
				 
			}
		}
		return false;
	}

}
