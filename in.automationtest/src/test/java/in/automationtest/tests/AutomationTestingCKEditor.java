package in.automationtest.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Util.UtilKit;
import in.automationtest.pages.AutomationTestingCKEditorPage;

public class AutomationTestingCKEditor extends AutomationTestingBase{
	
	@Test(enabled = true, groups = {"wyswyg", "performance"})
	public void createDocument(){
		
		AutomationTestingCKEditorPage ATCP = new AutomationTestingCKEditorPage(driver);
		String[] contentArray = {"Test1 Test2","test3","test4"}; 
		
		UtilKit.printCurrentPageHTML(driver);

		driver.switchTo().frame(ATCP.ckeditorFrame());
		ATCP.ckeditorBody().clear();
		
		for(String contentStr : contentArray){
			ATCP.ckeditorBody().sendKeys(contentStr + "\n");
		}
		
		driver.switchTo().defaultContent();
		
		ATCP.sourceButton().click();
		UtilKit.suspendAction(500);
		ATCP.sourceButton().click();
		UtilKit.suspendAction(500);

		driver.switchTo().frame(ATCP.ckeditorFrame());
		
		Assert.assertTrue(ATCP.verifyContent(contentArray), "Content Not Verified");
		
		driver.switchTo().defaultContent(); // always switch to default content when done with each test case
	}

	@Test (enabled = true, groups = {"wysiwyg"})
	public void boldAndStrikeLine() {

		AutomationTestingCKEditorPage ATCP = new AutomationTestingCKEditorPage(driver);

		driver.switchTo().frame(ATCP.ckeditorFrame());
		ATCP.ckeditorBody().clear();

		ATCP.ckeditorBody().sendKeys("LINE1\n");
		ATCP.ckeditorBody().sendKeys("astaakakajssjkLINE2 astueeieel\n");
		ATCP.ckeditorBody().sendKeys("LINE3\n");
	
		ATCP.highliteContentLine("LINE2");

		driver.switchTo().defaultContent();
		ATCP.boldButton().click();

		driver.switchTo().frame(ATCP.ckeditorFrame());
		Assert.assertTrue(ATCP.verifyBold("LINE2"), "Bold was not verified");

		driver.switchTo().defaultContent();
		ATCP.strikeButton().click();

		driver.switchTo().frame(ATCP.ckeditorFrame());
		Assert.assertTrue(ATCP.verifyStrike("LINE2"), "Strike was not verified");
		
		driver.switchTo().defaultContent(); // One last time for the next test case to work

	}
	
	@Test (enabled = true, groups = {"wysiwyg"})
	public void specialContainerStyle(){
		AutomationTestingCKEditorPage ATCP = new AutomationTestingCKEditorPage(driver);
		
		driver.switchTo().frame(ATCP.ckeditorFrame());
		ATCP.ckeditorBody().sendKeys("Line1 \n");
		ATCP.ckeditorBody().sendKeys("Line2 Line2.1\n");
		ATCP.ckeditorBody().sendKeys("Line3 \n");

		ATCP.highliteContentLine("Line2");
		
		driver.switchTo().defaultContent();
		ATCP.formattingStylesLink().click();
		driver.switchTo().frame(ATCP.ckePanelFrame()); // The special container option is located inside a frame
		ATCP.specialContainerOption().click();
		
		driver.switchTo().defaultContent(); // Switch to default content when done before switching to the ckEditor frame 
		driver.switchTo().frame(ATCP.ckeditorFrame());
		
		Assert.assertTrue(ATCP.verifySpecialContainer("Line2") , "Faled to verify Special Container");
		
		driver.switchTo().defaultContent(); 
	}

}
