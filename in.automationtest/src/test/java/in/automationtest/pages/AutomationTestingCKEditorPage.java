package in.automationtest.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Util.UtilKit;

public class AutomationTestingCKEditorPage {
	
	WebDriver driver = null;
	Actions myActions = null;
	
	public AutomationTestingCKEditorPage(WebDriver driver){
		this.driver = driver;
		myActions = new Actions(driver);
	}
	
	private By ckeditorLinkL = UtilKit.UIMap("CKEDITOR_LINK");
	private By wysiwygLinkL = UtilKit.UIMap("WYSIWYG_LINK");
	private By ckeditorFrameL = UtilKit.UIMap("CKEDITOR_FRAME");
	private By ckeditorBodyL = UtilKit.UIMap("CKEDITOR_BODY");
	private By sourceButtonL = UtilKit.UIMap("SOURCE_BUTTON");
	private By boldButtonL = UtilKit.UIMap("BOLD_BUTTON");
	private By strikeButtonL = UtilKit.UIMap("STRIKE_BUTTON");
	private By formattingStylesLinkL = UtilKit.UIMap("FORMATTINGSTYLES_LINK");
	private By specialContainerOptionL = UtilKit.UIMap("SPECIALCONTAINER_OPTION");
	private By specialContainerDivL = UtilKit.UIMap("SPECIALCONTAINER_DIV");
	private By ckePanelFrameL = UtilKit.UIMap("CKEPANEL_FRAME");
	
	public WebElement ckeditorLink(){
		return driver.findElement(ckeditorLinkL);
	}
	public WebElement wysiwygLink(){
		return driver.findElement(wysiwygLinkL);
	}
	public WebElement ckeditorFrame(){
		return driver.findElement(ckeditorFrameL);
	}
	
	public WebElement ckeditorBody(){
		return driver.findElement(ckeditorBodyL);
	}
	
	public void mouseClickOnWysiwygLink(){
		myActions.moveToElement(wysiwygLink()).click().build().perform();
	}
	
	public WebElement sourceButton(){
		return driver.findElement(sourceButtonL);
	}
	
	public WebElement boldButton(){
		return driver.findElement(boldButtonL);
	}
	
	public WebElement strikeButton(){
		return driver.findElement(strikeButtonL);
	}
	
	public WebElement formattingStylesLink(){
		return driver.findElement(formattingStylesLinkL);
	}
	 public WebElement ckePanelFrame(){
		 return driver.findElement(ckePanelFrameL);
	 }
	public WebElement specialContainerOption(){
		UtilKit.waitForElement(specialContainerOptionL, driver, "Displayed", 2);
		return driver.findElement(specialContainerOptionL);
	}
	public WebElement specialContainerDiv() {
		return driver.findElement(specialContainerDivL);
	}
	
	public void mouseClickOnCkeditorLink(){
		
		UtilKit.waitForElement(ckeditorLink(), "Displayed", 3);
		myActions.click(ckeditorLink()).perform();
		
	}
	
	public boolean verifyCkeditoURL(){
	
		UtilKit.logger.info("In" + UtilKit.currentMethod() + " URL :" + driver.getCurrentUrl());
		if(driver.getCurrentUrl().contains("CKEditor"))
			return true;
		return false;
	}
	
	public boolean verifyContent(String[] contentArray){
		List<WebElement> contentList = (ArrayList<WebElement>) ckeditorBody().findElements(By.tagName("p"));
		System.out.println("SiZES : " + contentList.size() + " : " + contentArray.length);
		for(int i = 0; i < contentArray.length; i++){
			String myStr = contentList.get(i).getText();
			System.out.println("Contents : " + myStr + " : " + contentArray[i]);
			if(!myStr.equals(contentArray[i]))
				return false;
		}
		return true;
	}
	
	public void highliteContentLineOriginal(String inLine){
		List<WebElement> contentLines = (ArrayList<WebElement>) this.ckeditorBody().findElements(By.tagName("p"));
		for(WebElement myElement : contentLines){
			if(myElement.getText().contains(inLine)){
				Point eLocation = myElement.getLocation();
				Rectangle eRect = myElement.getRect();
				System.out.println("Element to highlite found : " + myElement.getText() + " Loc :" + eLocation.toString() + 
						             " Rect : " + eRect.getX() + "," + eRect.getY() + "," + eRect.getWidth() + "," + eRect.getHeight());
				System.out.println(" Dimension : " + eRect.getDimension().toString());
				myActions.moveToElement(myElement).build().perform();
				UtilKit.suspendAction(5000);
				myActions.clickAndHold().moveByOffset(-548, 0).build().perform();
				myActions.release().build().perform();
				UtilKit.suspendAction(5000);
			}
		}
	}
	public void highliteContentLine(String inLine){
		List<WebElement> contentLines = (ArrayList<WebElement>) this.ckeditorBody().findElements(By.tagName("p"));
		for(WebElement myElement : contentLines){
			if(myElement.getText().contains(inLine)){
				UtilKit.highLiteElement(myElement, myActions);
			}
		}
	}

	public boolean verifyBold(String inLine){
		
		List<WebElement> contentLines = (ArrayList<WebElement>) this.ckeditorBody().findElements(By.tagName("strong"));
		for(WebElement myElement : contentLines){
			if(myElement.getText().contains(inLine)){
				System.out.println("IN :" + UtilKit.currentMethod() + " Mached :" + myElement.getText() + " With :" + inLine);
				return true;
			}
		}
		return false;
	}

	public boolean verifyStrike(String inLine){
		
		List<WebElement> contentLines = (ArrayList<WebElement>) this.ckeditorBody().findElements(By.tagName("s"));
		for(WebElement myElement : contentLines){
			if(myElement.getText().contains(inLine)){
				System.out.println("IN :" + UtilKit.currentMethod() + " Matched :" + myElement.getText() + " With :" + inLine);
				return true;
			}
		}
		return false;
	}
	
	public boolean verifySpecialContainer(String inLine) {
		List<WebElement> contentLines = (ArrayList<WebElement>) ckeditorBody().findElements(By.tagName("div"));
		for (WebElement myElement : contentLines) {
			System.out.println("Div Element : " + myElement.getAttribute("outerHTML") + " Text :" + myElement.getText()+ " inLine : " + inLine);
			if (myElement.getText().contains(inLine)) {
				System.out.println("Div Element Matched Text : " + myElement.getText());
				if (myElement.getAttribute("outerHTML").contains("border")) {
					System.out.println("Div Element Matched outerHTML: " + myElement.getAttribute("outerHTML"));
					return true;
				}
			}
		}
		return false;
	}

}
