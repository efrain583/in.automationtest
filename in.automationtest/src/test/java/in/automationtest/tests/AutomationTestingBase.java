package in.automationtest.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.internal.TestResult;

import Util.UtilKit;
import in.automationtest.pages.AutomationTestingCKEditorPage;
import in.automationtest.pages.AutomationTestingVideoPage;

// Make the listener available to all test Classes
@Listeners(AutomationTestingListener.class)	

public class AutomationTestingBase {
	
	WebDriver driver = null;
	String project = "in.automationtest";
	String application = project;
	String browser = "firefox";
	String className = this.getClass().getName();
	
	
	@BeforeClass (groups = {"grid", "register", "performance","wysiwyg","video"})
	@Parameters ("browser")
	public void startClass(@Optional("firefox") String browser){
		
		driver = UtilKit.initTest(project, application, browser, className);
		By skipSigninButtonL = UtilKit.UIMap("SKIPSIGNIN_BUTTON");
		driver.findElement(skipSigninButtonL).click();
		UtilKit.waitForPageTitle(driver, 3, "Register");

	}
	

	@BeforeMethod(groups = { "grid", "register", "performance", "wysiwyg", "video" })
	public void startRegisterMethod(Method method) {
		if (UtilKit.methodInGroup(method, "register")) {
			driver.findElement(By.xpath(".//a[text()='Register']")).click();
			UtilKit.waitForPageTitle(driver, 3, "Register");

		}
		if(UtilKit.methodInGroup(method, "wysiwyg")){
			AutomationTestingCKEditorPage ATCP = new AutomationTestingCKEditorPage(driver);
			ATCP.mouseClickOnWysiwygLink();
			ATCP.mouseClickOnCkeditorLink();
			UtilKit.suspendAction(1000);
			UtilKit.waitForPageToLoad(driver, 3);
			Assert.assertTrue(ATCP.verifyCkeditoURL(), "CKEditor URL was Not Verified");

		}
		if(UtilKit.methodInGroup(method, "video")){
			AutomationTestingVideoPage ATVP = new AutomationTestingVideoPage(driver);
			ATVP.mouseClickOnVideoLink();
			UtilKit.suspendAction(1000);
			ATVP.mouseClickOnYoutubeLink();
			UtilKit.suspendAction(1000);
			UtilKit.waitForPageToLoad(driver, 10);
			Assert.assertTrue(ATVP.verifyYoutubeURL(), "Video URL was Not Verified");

		}
		UtilKit.initMethod(method);

	}
	
	@AfterMethod(groups = {"grid","register", "performance"})
		public void stopMetod(ITestResult result){
		
			UtilKit.terminateMethod(driver, result);
	}
	
	@AfterClass (groups = {"grid", "register","performace"})
	public void stopClass(){
		UtilKit.terminateTest(driver);
	}
}
