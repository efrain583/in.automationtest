package in.automationtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Util.UtilKit;

public class AutomationTestingVideoPage {
	
	WebDriver driver = null;
	Actions ATVA = null;

	public AutomationTestingVideoPage(WebDriver driver) {
		this.driver = driver;
		this.ATVA =new Actions(driver);

	}
	
	By videoLinkL = UtilKit.UIMap("VIDEO_LINK");
	By youtubeLinkL = UtilKit.UIMap("YOUTUBE_LINK");
	
	//Sikuli Elements
	Screen	youtubeScreen = new Screen();
	String projectFolder = System.getenv("GIT_LOCAL_REPOSITORY");
	Pattern youtubePlayImage = new Pattern(projectFolder + "/in.automationtest/in.automationtest/src/test/resources/playImage.png"); 
	Pattern youtubePlayImage2 = new Pattern(projectFolder + "/in.automationtest/in.automationtest/src/test/resources/playImage2.png"); 
	Pattern youtubePauseImage = new Pattern(projectFolder + "/in.automationtest/in.automationtest/src/test/resources/pauseImage.png"); 
	
	public WebElement videoLink(){
		return driver.findElement(videoLinkL);
	}	
	
	public WebElement youtubeLink(){
		return driver.findElement(youtubeLinkL);
	}
	
	public void mouseClickOnVideoLink(){
		
		ATVA.moveToElement(videoLink()).perform();
//		ATVA.pause(3000).perform(); <== This is sometime generating exception : ailed to decode response from marionette
		UtilKit.suspendAction(1000);
		ATVA.click(videoLink()).perform();
		UtilKit.suspendAction(1000);
	}
	public void mouseClickOnYoutubeLink(){
		
		UtilKit.waitForElement(youtubeLink(), "Displayed", 3);
		ATVA.moveToElement(youtubeLink()).perform();
//		ATVA.pause(300).perform(); <== This is sometime generating exception : Failed to decode response from marionette
		UtilKit.suspendAction(1000);
		ATVA.click(youtubeLink()).perform();
	}
	
	public boolean verifyYoutubeURL(){
		
		if(driver.getCurrentUrl().contains("Youtube")){
			return true;
		}
		return false;
	}
	
	public void pressPlayOnYoutube(){
		try {
			youtubeScreen.click(youtubePlayImage);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void pressPauseOnYoutube(){
		
		youtubeScreen.hover(); // See if this helps make the pause image visible.
		youtubeScreen.click();
		UtilKit.suspendAction(100);
		try {
			youtubeScreen.click(youtubePauseImage);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean verifyVideoIsPlaying(){
		UtilKit.suspendAction(1500);	//There is a sikuli wait() call but it is generating : java.lang.IllegalMonitorStateException

			if(youtubeScreen.exists(youtubePlayImage) == null)
				return true; // while the Video is playing the playing Image is not available. Thats how you can tell if the video is playing or not
			else
				return false;
	}
	public boolean verifyVideoIsPaused(){
		UtilKit.suspendAction(1500);	//There is a sikuli wait() call but it is generating : java.lang.IllegalMonitorStateException

			if(youtubeScreen.exists(youtubePlayImage2) != null)
				return true; // while the Video is pause the playing Image is available. Thats how you can tell if the video is on pause or not
			else
				return false;
	}

}
