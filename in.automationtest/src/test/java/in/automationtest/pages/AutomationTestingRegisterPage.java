package in.automationtest.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Util.UtilKit;

public class AutomationTestingRegisterPage {
	
	WebDriver driver = null;
	
	public AutomationTestingRegisterPage (WebDriver driver){
		this.driver = driver;
	}
	
	By firstNameTextboxL = UtilKit.UIMap("FIRSTNAME_TEXTBOX");
	By lastNameTextboxL = UtilKit.UIMap("LASTNAME_TEXTBOX");
	By submitButtonL = UtilKit.UIMap("SUBMIT_BUTTON");
	By refreshButtonL = UtilKit.UIMap("REFRESH_BUTTON");
	By addressTextareaL = UtilKit.UIMap("ADDRESS_TEXTAREA"); 
	By emailaddressInputL = UtilKit.UIMap("EMAILADDRESS_INPUT");
	By phoneInputL = UtilKit.UIMap("PHONE_INPUT");
	By malegenderInputL = UtilKit.UIMap("MALEGENDER_INPUT");
	By crickethobbieInputL = UtilKit.UIMap("CRICKETHOBBIE_INPUT");
	By movieshobbieInputL = UtilKit.UIMap("MOVIESHOBBIE_INPUT");
	By hockeyhobbieInputL = UtilKit.UIMap("HOCKEYHOBBIE_INPUT");
	By languageSelectL = UtilKit.UIMap("LANGUAGE_SELECT");
	By languageBlockL = UtilKit.UIMap("LANGUAGE_BLOCK");
	By languageMultiSelectL = UtilKit.UIMap("LANGUAGE_MULTISELECT");
	By skillsSelectL = UtilKit.UIMap("SKILLS_SELECT");
	By countrySelectL = UtilKit.UIMap("COUNTRY_SELECT");
	By country2SelectL = UtilKit.UIMap("COUNTRY2_SELECT");
	By yearSelectL	= UtilKit.UIMap("YEAR_SELECT");
	By monthSelectL = UtilKit.UIMap("MONTH_SELECT");
	By daySelectL = UtilKit.UIMap("DAY_SELECT");
	By passwordInputL = UtilKit.UIMap("PASSWORD_INPUT");
	By confirmpassInputL = UtilKit.UIMap("CONFIRMPASS_INPUT");
	
	public WebElement firstNameTextbox(){
		return driver.findElement(firstNameTextboxL);
	}
	public WebElement lastNameTextbox(){
		return driver.findElement(lastNameTextboxL);
	}
	
	public WebElement addressTestArea(){
		return driver.findElement(addressTextareaL);
	}
	
	public WebElement emailaddressInput(){
		return driver.findElement(emailaddressInputL);
		
	}
	
	public WebElement submitButton(){
		return driver.findElement(submitButtonL);
	}
	public WebElement refreshButton(){
		return driver.findElement(refreshButtonL);
	}

	public WebElement phoneInput(){
		return driver.findElement(phoneInputL);
	}
	
	public WebElement malegenderInput(){
		return driver.findElement(malegenderInputL);
	}
	
	public WebElement crickethobbieInput(){
		return driver.findElement(crickethobbieInputL);
	}
	public WebElement movieshobbieInput(){
		return driver.findElement(movieshobbieInputL);
	}
	public WebElement hockeyhobbieInput(){
		return driver.findElement(hockeyhobbieInputL);
	}	
	
	public WebElement languageBlock(){
		return driver.findElement(languageBlockL);
	}
	
	public WebElement passwordInput(){
	
		return driver.findElement(passwordInputL);
	}
	
	public WebElement confirmpassInput(){
		return driver.findElement(confirmpassInputL);
	}
	
	public WebElement languageMultiSelect(){
		UtilKit.waitForElement(languageMultiSelectL, driver, "Displayed", 9);
		return driver.findElement(languageMultiSelectL);
	}

	public void countrySelect(String inCountry){
		
		Select countrySelect = new Select(driver.findElement(countrySelectL));
		countrySelect.selectByVisibleText(inCountry);
		
	}
	public void country2Select(String in2Country){
		
		Select country2Select = new Select(driver.findElement(country2SelectL));
		country2Select.selectByVisibleText(in2Country);
		
	}

	public void skillsSelect(String inSkill){
		
		Select skillsSelect = new Select(driver.findElement(skillsSelectL));
		skillsSelect.selectByVisibleText(inSkill);
		
	}

	public void yearSelect(String inYear){
		
		Select yearSelect = new Select(driver.findElement(yearSelectL));
		yearSelect.selectByVisibleText(inYear);
		
	}
	public void monthSelect(String inMonth){
		
		Select monthSelect = new Select(driver.findElement(monthSelectL));
		monthSelect.selectByVisibleText(inMonth);
		
	}
	
	public void daySelect(String inDay){
		
		Select daySelect = new Select(driver.findElement(daySelectL));
		daySelect.selectByVisibleText(inDay);
		
	}
	
	
	public void languageSelect(String language){
		
		WebElement langSel = (driver.findElement(languageSelectL));
		
		Actions myActions = new Actions(driver);
		
		UtilKit.scrollDown(driver);

		// Make the multiple select Available by clicking on the language field
		if(!languageMultiSelect().isDisplayed())
			languageBlock().click();

		System.out.println("Language Block Location :" + languageMultiSelect().getLocation().toString());
		//myActions.moveToElement(languageMultiSelect(), 1, 12);
		UtilKit.suspendAction(250);

		ArrayList<WebElement> selList = (ArrayList<WebElement>) langSel.findElements(By.xpath(".//a[@class='ui-corner-all']"));
		for(WebElement myElement : selList){
			UtilKit.logger.info("Language Option : " +  myElement.getAttribute("text"));
			if(myElement.getAttribute("text").equalsIgnoreCase(language)){
				myElement.click();
				UtilKit.suspendAction(500);
				break;
			}
		}

	}

	public boolean checkActiveElement(String elementType) {

		int counter = 0;
		while (counter < 3) {
			try {
				WebElement myActiveEle = driver.switchTo().activeElement();
				UtilKit.logger.info("Active Element : " + myActiveEle.getAttribute("outerHTML"));
				UtilKit.logger.info("Active Element ng-model: " + myActiveEle.getAttribute("ng-model"));
				if((myActiveEle.getAttribute("ng-model").equalsIgnoreCase(elementType)) &&
				   (myActiveEle.getAttribute("outerHTML").contains("-required")))
						return true;
				counter++;
			} catch (Exception e) {
				UtilKit.suspendAction(1000);
				counter++;
				continue;
			}
		}
		return false;
	}
	public boolean checkErrorElement(String message) {

		boolean foundFlag = false;
		
		//ArrayList<WebElement> Elements = (ArrayList<WebElement>) driver.findElements(By.tagName("div"));
		ArrayList<WebElement> Elements = (ArrayList<WebElement>) driver.findElements(By.tagName("span"));
		for(int counter = 0; counter < Elements.size(); counter++){
		    System.out.println("span outerHTML : " + Elements.get(counter).getAttribute("outerHTML"));
		    if(Elements.get(counter).getText().contains(message)){
		    	System.out.println("span outerHTML : " + Elements.get(counter).getAttribute("outerHTML"));
		        foundFlag =  true;
		    }
		}
		return foundFlag;
	}	
	
}