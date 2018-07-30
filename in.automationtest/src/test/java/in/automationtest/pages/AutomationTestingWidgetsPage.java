package in.automationtest.pages;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import Util.UtilKit;

public class AutomationTestingWidgetsPage {

	WebDriver driver =  null;
	Actions widgetActions = null;

	public AutomationTestingWidgetsPage(WebDriver driver){
		this.driver = driver;
		widgetActions = new Actions(driver);
	}
	
	By widgetsLinkL = UtilKit.UIMap("WIDGETS_LINK");
	
	By accordionLinkL = UtilKit.UIMap("ACCORDION_LINK");
	By collapsableLinksL = UtilKit.UIMap("COLLAPSIBLE_LINKS");
	By panelbodyDivListL = UtilKit.UIMap("PANELBODY_DIV_LIST");
	By panelbodyParentListL = UtilKit.UIMap("PANELBODY_PARENT_LIST");
	
	By autocompleteLinkL = UtilKit.UIMap("AUTOCOMPLETE_LINK");
	By autocompleteSearchboxL = UtilKit.UIMap("AUTOCOMPLETE_SEARCHBOX");
	By autocompleteListL =   UtilKit.UIMap("AUTOCOMPLETE_LIST");
	By selectedListL = UtilKit.UIMap("SELECTED_LIST"); 
	
	By datepickerLinkL = UtilKit.UIMap("DATEPICKER_LINK");
	By datepickerInputL = UtilKit.UIMap("DATEPICKER_INPUT");
	By nextLinkL = UtilKit.UIMap("NEXT_LINK");
	By prevLinkL = UtilKit.UIMap("PREV_LINK"); 
	By datepickerMonthL = UtilKit.UIMap("DATEPICKER_MONTH");
	By datepickerYearL = UtilKit.UIMap("DATEPICKER_YEAR");
	By datepickerTbodyL = UtilKit.UIMap("DATEPICKER_TBODY");
	
	By sliderLinkL = UtilKit.UIMap("SLIDER_LINK");
	By sliderL = UtilKit.UIMap("SLIDER");
	By sliderHandleL = UtilKit.UIMap("SLIDER_HANDLE");
	
	public WebElement sliderLink(){
		return driver.findElement(sliderLinkL);
	}
	public WebElement slider(){
		
		return driver.findElement(sliderL);
	}
	public WebElement sliderHandle(){
		return driver.findElement(sliderHandleL);
	}
	
	public void moveHandle(double percent){
		
		Point sliderLocation = slider().getLocation();
		Point sliderHandleLocation = sliderHandle().getLocation();
		Dimension sliderDimension = slider().getSize();
		
		System.out.println("Slider Location: " +sliderLocation.getX() + "," + sliderLocation.getY());
		System.out.println("Slider Handle Location: " +sliderHandleLocation.getX() + "," + sliderHandleLocation.getY());
		System.out.println("Slider Dimensions: " + " Height: " + sliderDimension.getHeight() + " width: " + sliderDimension.getWidth());
		widgetActions.moveToElement(sliderHandle()).perform();;
		widgetActions.dragAndDropBy(sliderHandle(),(int) ((sliderDimension.getWidth()) * percent), 0).perform();;
		UtilKit.suspendAction(1000);
	}
	public boolean verifySliderHandleLocation(double percent){
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		Point sliderLocation = slider().getLocation();
		Point sliderHandleLocation = sliderHandle().getLocation();
		Dimension sliderDimension = slider().getSize();
		System.out.println("Slider Location: " +sliderLocation.getX() + "," + sliderLocation.getY());
		System.out.println("Slider Handle Location: " +sliderHandleLocation.getX() + "," + sliderHandleLocation.getY());
		System.out.println("Slider Dimensions: " + " Height: " + sliderDimension.getHeight() + " width: " + sliderDimension.getWidth());
		
		int sliderHandleOffset = sliderHandleLocation.getX() - sliderLocation.getX() +8;
		
		System.out.println("HO: " + sliderHandleOffset + " SP: " + df.format((1.00 * (double)sliderHandleOffset)/(1.00 * (double)sliderDimension.getWidth())));
		System.out.println("HO: " + sliderHandleOffset + " SP: " + (1.00 * (double)sliderHandleOffset)/(1.00 * (double)sliderDimension.getWidth()));
		
		String formattedDouble = df.format(((1.00 * (double)sliderHandleOffset)/(1.00 * (double)sliderDimension.getWidth())));
		
		if(percent == Double.parseDouble(formattedDouble)){
			return true;
		}
		return false;
	}
	
	enum month { January,February,March,April,May,June,July, August,September,Octuber,November,December }
	
	public WebElement datepickerInput(){
		UtilKit.waitForElement(datepickerInputL, driver, "Displayed", 3);
		return driver.findElement(datepickerInputL);
	}
	
	public WebElement nextLink(){
		return driver.findElement(nextLinkL);
	}
	public WebElement prevLink(){
		return driver.findElement(prevLinkL);
	}
	public WebElement datepickerMonth(){
		return driver.findElement(datepickerMonthL);
	}
	public WebElement datepickerYear(){
		return driver.findElement(datepickerYearL);
	}
	public WebElement datepickerTbody(){
		return driver.findElement(datepickerTbodyL);
	}
	
	public void pickDate(String year, String month, String day) {

		/*
		 * Pick the year first
		 */
		while (year.compareTo(datepickerYear().getText()) != 0) {

			if (year.compareTo(datepickerYear().getText()) < 0) {
				nextLink().click();
			} else if (year.compareTo(datepickerYear().getText()) > 0) {
				prevLink().click();
			}
			UtilKit.suspendAction(250);
		}
		/*
		 * pick the Month next
		 */
		while (monthCompare(month, datepickerMonth().getText()) != 0) {
			if(monthCompare(month, datepickerMonth().getText()) < 0){
				nextLink().click();
			}else if(monthCompare(month, datepickerMonth().getText()) > 0){
				prevLink().click();
			}
			UtilKit.suspendAction(250);
		}
		/*
		 * pick the day 
		 */
		ArrayList<WebElement> trList = (ArrayList<WebElement>) driver.findElements(By.tagName("tr"));
		
		for(WebElement trEle : trList){
			ArrayList<WebElement> tdList = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
			for(WebElement tdEle : tdList){
				if(day.compareTo(tdEle.getText()) ==0){
					tdEle.click();
					UtilKit.suspendAction(250);
					return;
				}
			}
		}
	}

	public int monthCompare(String month1, String month2) {

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int returnCode;
		int month1Position = 0;
		int month2Position = 0;

		for (int i = 0; i < months.length; i++) {
			if (month1.compareTo(months[i]) == 0) {
				month1Position = i + 1;
			}
		}
		for (int i = 0; i < months.length; i++) {
			if (month2.compareTo(months[i]) == 0) {
				month2Position = i + 1;
			}
		}

		return (month1Position - month2Position);
	}

	public WebElement autocompleteSearchbox(){

		return driver.findElement(autocompleteSearchboxL);
	}

	public void selectAutocompleteItem(String selection){
		UtilKit.waitForElement(autocompleteListL, driver, "Displayed", 3);
		WebElement autoCompleteListEle = driver.findElement(autocompleteListL);
		ArrayList<WebElement> autocompleteList = (ArrayList<WebElement>) autoCompleteListEle.findElements(By.tagName("a"));
		for(WebElement listEle : autocompleteList){
			if(listEle.getText().equals(selection)){
				listEle.click();
				return;
			}
		}
		UtilKit.logger.warn("No Matchinkg selection found in autoSelect list...");
	}
	
	public boolean verifyAutocompleteSelected(String selection){
		
		WebElement selectedGroup = driver.findElement(selectedListL);
		ArrayList<WebElement> selectedList = (ArrayList<WebElement>) selectedGroup.findElements(By.tagName("div"));
		for (WebElement selectedElement : selectedList){
			if(selectedElement.getText().equals(selection)){
				return true;
			}
		}
		return false;
	}

	public WebElement widgetsLink(){
		return driver.findElement(widgetsLinkL);
	}
	
	public WebElement datepickerLink(){

		return driver.findElement(datepickerLinkL);
	}
	
	public WebElement autocompleteLink(){
		return driver.findElement(autocompleteLinkL);
	}
	private ArrayList<WebElement> panelbodyParentsList(){
		
		return (ArrayList<WebElement>) driver.findElements(panelbodyParentListL);
	}
	
	public void printPanelBodyParents(){
		ArrayList<WebElement> panelBodyParentsList = (ArrayList<WebElement>) driver.findElements(panelbodyParentListL);
		for(int i=0;i< panelBodyParentsList.size(); i++){
			System.out.println("Parent Expaded Flag :" + panelBodyParentsList.get(i).getAttribute("aria-expanded"));
		}
	}
	public WebElement accordionLink(){
		return driver.findElement(accordionLinkL);
	}
	
	public void clickOnCollapsableLinks(){
		
		List<WebElement> collapsableList = (ArrayList<WebElement>) collapsableLinks(); 
		int i = 0;
		for(WebElement collEle : collapsableList){
			collEle.click();
			UtilKit.suspendAction(500);
		}
	}
	
	public ArrayList<WebElement> panelbodyDivList(){
		
		return (ArrayList<WebElement>) driver.findElements(panelbodyDivListL); 
		
	}
	
	public boolean verifybodyDivs(){
		
		List<WebElement> pannelList = (ArrayList<WebElement>) panelbodyDivList(); 
		List<WebElement> pannelParentsList = (ArrayList<WebElement>) panelbodyParentsList(); 
		for(int i = 0; i < pannelList.size(); i++){
			/*
			 * If aria-expanded is true, then the panel detail should be displayed
			 * If aria-expanded is false, then the panel detail should Not be displayed
			 * Otherwise there is a mismatch and the verification should fail (return false)
			 */
			if((pannelParentsList.get(i).getAttribute("aria-expanded").equals("true") && (pannelList.get(i).isDisplayed())) ||
					(pannelParentsList.get(i).getAttribute("aria-expanded").equals("false") && (!pannelList.get(i).isDisplayed()))){
				UtilKit.suspendAction(500);
			}
			else{
				UtilKit.logger.error("Collapsable Element : " + i + " aria-expanded Atrribute does not match the Display Status ... ");
		return false;
			}
		}
		return true;
	}

	public void mouseMoveToWidgetsLink(){
		widgetActions.moveToElement(widgetsLink()).perform();
		UtilKit.suspendAction(1500);
//		widgetActions.click(widgetsLink()).perform();;
	}
	public void mouseClickOnAccordionLink(){
		
		UtilKit.waitForElement(accordionLink(), "Displayed", 3);
		widgetActions.moveToElement(accordionLink()).perform();
		UtilKit.suspendAction(1500);
		widgetActions.click(accordionLink()).perform();
		UtilKit.suspendAction(1500);
	}
	public void mouseClickOnAutocompleteLink(){
		
		UtilKit.waitForElement(autocompleteLink(), "Displayed", 3);
		widgetActions.moveToElement(autocompleteLink()).perform();
		UtilKit.suspendAction(1500);
		widgetActions.click(autocompleteLink()).perform();
		UtilKit.suspendAction(1500);
	}
	
	public void mouseClickOnDatepickerLink(){
		
		UtilKit.waitForElement(datepickerLink(), "Displayed", 3);
		widgetActions.moveToElement(datepickerLink()).perform();
		UtilKit.suspendAction(1500);
		widgetActions.click(datepickerLink()).perform();
		UtilKit.suspendAction(1500);
	}
	public void mouseClickOnSliderLink(){
		
		UtilKit.waitForElement(sliderLink(), "Displayed", 3);
		widgetActions.moveToElement(sliderLink()).perform();
		UtilKit.suspendAction(1500);
		widgetActions.click(sliderLink()).perform();
		UtilKit.suspendAction(1500);
	}
	private ArrayList<WebElement> collapsableLinks(){
		return (ArrayList<WebElement>) driver.findElements(collapsableLinksL);
	}
	
	public boolean verifyAccordionPage(){
		return UtilKit.waitForPageTitle(driver, 10, "Accordion");
	}
	
	public boolean verifyAutocompletePage(){
		return UtilKit.waitForPageTitle(driver, 10, "Autocomplete");
	}
	public boolean verifyDatepickerPage(){
		return UtilKit.waitForPageTitle(driver, 10, "Datepicker");
	}
	public boolean verifySliderPage(){
		return UtilKit.waitForPageTitle(driver, 10, "Slider");
	}
	public boolean verifyCollapsableLinks(){
		if (collapsableLinks().size() != 4)
			return false;
		return true;
		
	}
}
