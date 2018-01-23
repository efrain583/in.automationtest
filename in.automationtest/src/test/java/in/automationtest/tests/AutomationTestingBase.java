package in.automationtest.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.internal.TestResult;

import Util.UtilKit;

public class AutomationTestingBase {
	
	WebDriver driver = null;
	String project = "in.automationtest";
	String application = project;
	String browser = "firefox";
	String className = this.getClass().getName();
	
	@BeforeClass (groups = {"grid"})
	@Parameters ("browser")
	public void startClass(@Optional("firefox") String browser){
		
		driver = UtilKit.initTest(project, application, browser, className);
		By skipSigninButtonL = UtilKit.UIMap("SKIPSIGNIN_BUTTON");
		driver.findElement(skipSigninButtonL).click();
		UtilKit.waitForPageTitle(driver, 3, "Register");

	}
	
	@BeforeMethod(groups = {"grid"})
		public void startMethod(Method method){
			UtilKit.initMethod(method);

	}
	
	@AfterMethod(groups = {"grid"})
		public void stopMetod(ITestResult result){
		
			UtilKit.terminateMethod(driver, result);
	}
	
	@AfterClass (groups = "grid")
	public void stopClass(){
		UtilKit.terminateTest(driver);
	}
}
