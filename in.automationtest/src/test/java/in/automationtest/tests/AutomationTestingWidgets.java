package in.automationtest.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Util.UtilKit;
import in.automationtest.pages.AutomationTestingWidgetsPage;

public class AutomationTestingWidgets extends AutomationTestingBase {

	@Test(enabled = true, groups="widget")
	public void accessCollapsableLinks(){
		
		AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
		
		ATWP.mouseMoveToWidgetsLink();
		System.out.println("After mouseMove to Widgets link");
		ATWP.mouseClickOnAccordionLink();
		Assert.assertTrue(ATWP.verifyAccordionPage(), "Accordion Page Title could Not be Verified ..." );
		
	}
	
	@Test(enabled = true, groups="widget", dependsOnMethods = {"accessCollapsableLinks"})
	public void verifyCollapsables(){

		AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);

		Assert.assertTrue(ATWP.verifyCollapsableLinks(), "Unable to verify Collapsables");
	}
	
	@Test(enabled= true, groups="widget", dependsOnMethods = {"verifyCollapsables"})
	public void verifyAccordionBody(){
		
		AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
		
		ATWP.clickOnCollapsableLinks();
		ATWP.printPanelBodyParents();
		Assert.assertTrue(ATWP.verifybodyDivs(), "Unable to verify Accordion Body Divs");
	}
	
	@Test(enabled=true, groups="widget", dependsOnMethods = {"verifyAccordionBody"})
	public void accessAutocomplete(){
		
		AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
		
		ATWP.mouseMoveToWidgetsLink();
		ATWP.mouseClickOnAutocompleteLink();
		Assert.assertTrue(ATWP.verifyAutocompletePage(), "Autocomplete Page title was not verified...");
	}
	
	@Test(enabled=true, groups = {"widget"}, dependsOnMethods = {"accessAutocomplete"}, dataProvider = "countriesDataProvider" )
	public void selectCountriesFromAutoSelect(String countryNames){ //Comma separated list of countries
		
		AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
		
		String[] countryArray = countryNames.split(",");
		for (int i = 0; i < countryArray.length; i++) {

			ATWP.autocompleteSearchbox().click();
			ATWP.autocompleteSearchbox().sendKeys(countryArray[i].substring(0, 2));
			ATWP.selectAutocompleteItem(countryArray[i]);
			Assert.assertTrue(ATWP.verifyAutocompleteSelected(countryArray[i]),
					"Unable to Verify AutoSelected :" + countryArray[i]);
		}
			driver.navigate().refresh();
	}
	
	@Test(enabled=true, groups = {"widget"}, dependsOnMethods ={"selectCountriesFromAutoSelect"})
		public void accessDatepicker(){
			
			AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
			ATWP.mouseMoveToWidgetsLink();
			ATWP.mouseClickOnDatepickerLink();
			Assert.assertTrue(ATWP.verifyDatepickerPage(), "Unable to verify Datepicker page ..");
		}

	@Test(enabled=true,groups={"widget"}, dependsOnMethods = {"accessDatepicker"})
	public void testDatePicker(){

		AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
		
//		ATWP.datepickerInput().clear();
		ATWP.datepickerInput().click();
		ATWP.pickDate("2019", "September", "18");
		UtilKit.suspendAction(10000);
		System.out.println("Date Picked class: " + UtilKit.javaScriptGetClass(driver, ATWP.datepickerInput()));
		System.out.println("Date Picked Value: " + UtilKit.javaScriptGetValue(driver, ATWP.datepickerInput()));
		System.out.println("Date Picked HTML: " + UtilKit.javaScriptGetHTML(driver, ATWP.datepickerInput()));
	}
	@Test(enabled=true,groups={"widget"}, dependsOnMethods = {"testDatePicker"})
	public void testDatePickerInput(){

		AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
		
//		ATWP.datepickerInput().clear();
		//ATWP.datepickerInput().sendKeys("09/12/2017"); /* This is now Working... Using JavaScript below to set value
		UtilKit.javaScriptSendKeys(driver, ATWP.datepickerInput(), "09/12/2017");
		UtilKit.suspendAction(1000);
		System.out.println("Date Picked class: " + UtilKit.javaScriptGetClass(driver, ATWP.datepickerInput()));
		System.out.println("Date Picked Value: "   + UtilKit.javaScriptGetValue(driver, ATWP.datepickerInput()));
		System.out.println("Date Picked HTML: " + UtilKit.javaScriptGetHTML(driver, ATWP.datepickerInput()));
	}
	@Test(enabled=true, groups = {"widget"}, dependsOnMethods ={"testDatePickerInput"})
		public void accessSlider(){
			
			AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
			ATWP.mouseMoveToWidgetsLink();
			ATWP.mouseClickOnSliderLink();
			Assert.assertTrue(ATWP.verifySliderPage(), "Unable to verify Slider page ..");
		}
	@Test(enabled=true, groups = {"widgets"}, dependsOnMethods = {"accessSlider"})
		public void testSlider1(){

			AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
			ATWP.moveHandle(.25);
			ATWP.moveHandle(.25);
			ATWP.moveHandle(.25);
			ATWP.moveHandle(.25);
			ATWP.moveHandle(-.25);
			
			// At this point it should be at 75%, Let verify it
			Assert.assertTrue(ATWP.verifySliderHandleLocation(.75), " Unable to verify Slider Handle Location.");
			
		}
	@Test(enabled=true, groups = {"widgets"}, dependsOnMethods = {"testSlider1"})
		public void testSlider2(){

			AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
			
			driver.navigate().refresh();
			UtilKit.suspendAction(10000);

			ATWP.moveHandle(.25);
			ATWP.moveHandle(.25);
			ATWP.moveHandle(.25);
			ATWP.moveHandle(.25);
			
			// At this point it should be at 100%, Let verify it
			Assert.assertTrue(ATWP.verifySliderHandleLocation(1), " Unable to verify Slider Handle Location.");
	}
	@Test(enabled=true, groups = {"widgets"}, dependsOnMethods = {"testSlider2"})
		public void testSlider3(){

			AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
			
			driver.navigate().refresh();
			UtilKit.suspendAction(10000);
			
			// At this point it should be at 0%, Let verify it
			Assert.assertTrue(ATWP.verifySliderHandleLocation(0), " Unable to verify Slider Handle Location.");
	}
	@Test(enabled=true, groups = {"widgets"}, dependsOnMethods = {"testSlider3"})
		public void testSlider4(){

			AutomationTestingWidgetsPage ATWP = new AutomationTestingWidgetsPage(driver);
			
			driver.navigate().refresh();
			UtilKit.suspendAction(10000);

			ATWP.moveHandle(.25);
			ATWP.moveHandle(.10);
			
			// At this point it should be at 35%, Let verify it
			Assert.assertTrue(ATWP.verifySliderHandleLocation(.35), " Unable to verify Slider Handle Location.");
	}
			
}
