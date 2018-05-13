package in.automationtest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.automationtest.pages.AutomationTestingVideoPage;

public class AutomationTestingVideo extends AutomationTestingBase {
	
	@Test(enabled = true, groups = {"video"})
	public void playTest(){

		AutomationTestingVideoPage ATVP = new AutomationTestingVideoPage(driver);
		
		ATVP.pressPlayOnYoutube();
		
		Assert.assertTrue(ATVP.verifyVideoIsPlaying(), "Could Not verify is video is playing");

	}
	
	@Test(enabled = true, groups ={"video"}, dependsOnMethods ={"playTest"})
	public void pauseTest(){

		AutomationTestingVideoPage ATVP = new AutomationTestingVideoPage(driver);
		
		ATVP.pressPauseOnYoutube();
		
		Assert.assertTrue(ATVP.verifyVideoIsPaused(), "Could Not verify the video is on Pause");
		
	}
	
	

}
