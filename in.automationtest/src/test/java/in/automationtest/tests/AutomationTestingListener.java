package in.automationtest.tests;

import java.util.Set;

import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Util.UtilKit;

public class AutomationTestingListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		Throwable throwable = new Throwable("Failure Detected", new Throwable(" And that's all I know ..."));
		
		Set<String> resultAttributes = result.getAttributeNames();
		if (resultAttributes.size() > 0){
		for(String myAttrib : resultAttributes){
			System.out.println(result.getMethod() + " Attribute : " + myAttrib);
		}
		}
		else{
			UtilKit.logger.warn("Nor Result Attributes for : " + result.getMethod(), throwable);
		}
		//UtilKit.logger.fatal(result.getMethod() + " " + result.getParameters().toString() + " FAILED  ",throwable);
		// Failed miserably
		UtilKit.logger.fatal(result.getMethod() + " " + result.getParameters().toString() + " FAILED MISERABLY " + " Status : " + result.getStatus(),result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		IResultMap resultMap  = context.getFailedTests();

		Set<ITestResult> testResultSet = resultMap.getAllResults();
		System.out.println(UtilKit.currentMethod() + " Here are the Falied Test Cases : \n");
		for(ITestResult currResult : testResultSet){
			
			System.out.println(currResult.getName() + " : " + currResult.getMethod().getMethodName() + " : " + currResult.getStatus());
			
		}
		
	}

}
