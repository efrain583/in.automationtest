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
		
		// no need to throw an exception here ... At least for now
		//Throwable throwable = new Throwable("Failure Detected", new Throwable(" And that's all I know ..."));
		
		Set<String> resultAttributes = result.getAttributeNames();
		if (resultAttributes.size() > 0){
		for(String myAttrib : resultAttributes){
			System.out.println(result.getMethod() + " Attribute : " + myAttrib);
		}
		}
		else{
			UtilKit.logger.warn("Nor Result Attributes for : " + result.getMethod());
		}
		//UtilKit.logger.error(result.getMethod() + " " + result.getParameters().toString() + " FAILED  ",throwable);
		// Failed 
		UtilKit.logger.error(result.getMethod() + " " + result.getParameters().toString() + " FAILED " + " Status : " + result.getStatus(),result.getThrowable());
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

	@SuppressWarnings("null")
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		IResultMap resultMap  = context.getFailedTests();

		StringBuilder testResultsMessage = new StringBuilder();
		
		Set<ITestResult> testResultSet = resultMap.getAllResults();
		System.out.println(UtilKit.currentMethod() + " " + resultMap.size() + " Cases Failed. Here are the Falied Test Cases : \n");
		for(ITestResult currResult : testResultSet){
			
			System.out.println(" Test Case : " + currResult.getMethod().getMethodName() + " Status: " + currResult.getStatus());
			testResultsMessage.append(" Test Case : " + currResult.getMethod().getMethodName() + " Status: " + currResult.getStatus() + "\n");
			
			
		}
		System.out.println("\n");

		UtilKit.sendRestResultsEMail(testResultsMessage.toString());
	}

}
