package in.automationtest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.UtilKit;
import in.automationtest.pages.AutomationTestingRegisterPage;

public class AutomationTestingRegister extends AutomationTestingBase {

	@Test(enabled=true, groups={"register"})
	public void phoneRequiredRegistration(){

		AutomationTestingRegisterPage ATRP = new AutomationTestingRegisterPage(driver);
		
		ATRP.firstNameTextbox().clear();
		ATRP.firstNameTextbox().sendKeys("Efrain");
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys("Sanchez");
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys("44 Brandywine Circle");
		ATRP.emailaddressInput().clear();
		ATRP.emailaddressInput().sendKeys("efrain583@yahoo.com");
		
		ATRP.submitButton().click();
		
		UtilKit.suspendAction(500);
		Assert.assertTrue(ATRP.checkActiveElement("Phone"),  "Required active element: Phone Was Not Veryfied");
		
		ATRP.refreshButton().click();
	}		

	@Test(enabled=true, groups={"register"}, dependsOnMethods={"refreshRegistration"}, 
					dataProvider = "registrationDataProvider")
	public void submitRegistration(
									String fName,String lName, String address, String email, String phone, String sLanguage,
									String skill, String country, String country2, String bYear, String bMonth, String bDay,
									String pass){

		AutomationTestingRegisterPage ATRP = new AutomationTestingRegisterPage(driver);

		ATRP.refreshButton().click();
		
		ATRP.firstNameTextbox().clear();
		ATRP.firstNameTextbox().sendKeys(fName);
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys(lName);
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys(address);
		ATRP.emailaddressInput().clear();
		ATRP.emailaddressInput().sendKeys(email);
		ATRP.phoneInput().clear();
		ATRP.phoneInput().sendKeys(phone);
		ATRP.malegenderInput().click();
		ATRP.crickethobbieInput().click();
		ATRP.movieshobbieInput().click();
		ATRP.hockeyhobbieInput().click();
		
		ATRP.languageSelect(sLanguage);
		
		ATRP.skillsSelect(skill);
		ATRP.countrySelect(country);
		ATRP.country2Select(country2);
		ATRP.yearSelect(bYear);
		ATRP.monthSelect(bMonth);
		ATRP.daySelect(bDay);
		
		ATRP.passwordInput().sendKeys(pass);
		ATRP.confirmpassInput().sendKeys(pass);
		
		ATRP.submitButton().click();
		
		UtilKit.suspendAction(500);
		
	}	
		
	@Test(enabled=true, groups={"register"}, 
			dependsOnMethods ={"phoneRequiredRegistration","countryRequiredRegistration",
								"genderRequiredRegistration","emailRequiredRegistration"},
			dataProvider = "registrationDataProvider")
	public void refreshRegistration(
									String fName,String lName, String address, String email, String phone, String sLanguage,
									String skill, String country, String country2, String bYear, String bMonth, String bDay,
									String pass){

		AutomationTestingRegisterPage ATRP = new AutomationTestingRegisterPage(driver);
		
		ATRP.refreshButton().click();
		
		ATRP.firstNameTextbox().clear();
		ATRP.firstNameTextbox().sendKeys(fName);
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys(lName);
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys(address);
		ATRP.emailaddressInput().clear();
		ATRP.emailaddressInput().sendKeys(email);
		ATRP.phoneInput().clear();
		ATRP.phoneInput().sendKeys(phone);
		ATRP.malegenderInput().click();
		ATRP.crickethobbieInput().click();
		ATRP.movieshobbieInput().click();
		ATRP.hockeyhobbieInput().click();
		
		ATRP.languageSelect(sLanguage);
		ATRP.languageSelect("Filipino");
		ATRP.languageSelect("Catalan");
		
		ATRP.skillsSelect(skill);
		ATRP.countrySelect(country);
		ATRP.country2Select(country2);
		ATRP.yearSelect(bYear);
		ATRP.monthSelect(bMonth);
		ATRP.daySelect(bDay);
		
		ATRP.passwordInput().sendKeys(pass);
		ATRP.confirmpassInput().sendKeys(pass);
		
		//ATRP.submitButton().click();
		ATRP.refreshButton().click();
		
		UtilKit.suspendAction(500);
	}
		
	@Test(enabled=true, groups={"register"})
	public void countryRequiredRegistration(){

		AutomationTestingRegisterPage ATRP = new AutomationTestingRegisterPage(driver);
		
		ATRP.firstNameTextbox().clear();
		ATRP.firstNameTextbox().sendKeys("Efrain");
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys("Sanchez");
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys("44 Brandywine Circle");
		ATRP.emailaddressInput().clear();
		ATRP.emailaddressInput().sendKeys("efrain583@yahoo.com");
		ATRP.phoneInput().clear();
		ATRP.phoneInput().sendKeys("7324242995");
		ATRP.malegenderInput().click();
		ATRP.crickethobbieInput().click();
		ATRP.movieshobbieInput().click();
		ATRP.hockeyhobbieInput().click();
		
		ATRP.languageSelect("Spanish");
		ATRP.languageSelect("Filipino");
		ATRP.languageSelect("Catalan");
		
		ATRP.submitButton().click();
		
		UtilKit.suspendAction(1500);
		Assert.assertTrue(ATRP.checkActiveElement("country"),  "Required active element: Country Was Not Veryfied");
		
		
		ATRP.refreshButton().click();
	}
		
	@Test(enabled=true, groups={"register"})
	public void genderRequiredRegistration(){

		AutomationTestingRegisterPage ATRP = new AutomationTestingRegisterPage(driver);
		
		ATRP.firstNameTextbox().clear();
		ATRP.firstNameTextbox().sendKeys("Efrain");
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys("Sanchez");
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys("44 Brandywine Circle");
		ATRP.emailaddressInput().clear();
		ATRP.emailaddressInput().sendKeys("efrain583@yahoo.com");
		ATRP.phoneInput().clear();
		ATRP.phoneInput().sendKeys("7324242995");
		
		ATRP.submitButton().click();
		
		UtilKit.suspendAction(500);
		Assert.assertTrue(ATRP.checkActiveElement("radiovalue"),  "Required active element: Gender Was Not Veryfied");
		
		ATRP.refreshButton().click();
		
	}
	@Test(enabled=true, groups={"register"})
	public void emailRequiredRegistration(){

		AutomationTestingRegisterPage ATRP = new AutomationTestingRegisterPage(driver);
		
		ATRP.firstNameTextbox().clear();
		ATRP.firstNameTextbox().sendKeys("Efrain");
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys("Sanchez");
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys("44 Brandywine Circle");
		
		
		ATRP.submitButton().click();
		
		UtilKit.suspendAction(500);
		//ATRP.printPageHTML();
		//Assert.assertTrue(ATRP.checkErrorElement("Please"), "Active Element Not Veryfied");
		Assert.assertTrue(ATRP.checkActiveElement("EmailAdress"),  "Required active element: email Was Not Veryfied");
		
		ATRP.refreshButton().click();
		
	}
	
	@DataProvider
	public Object[][] registrationDataProvider(){
		return UtilKit.getTestData(project, application, "registration");
	}
	
}
