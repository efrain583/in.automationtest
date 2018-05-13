package in.automationtest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jcabi.log.Logger;

import Util.UtilKit;
import in.automationtest.pages.AutomationTestingRegisterPage;

public class AutomationTestingRegister extends AutomationTestingBase {

	@Test(enabled=true, groups={"register"})
	public void phoneRequiredRegistration(){

		AutomationTestingRegisterPage ATRP = new AutomationTestingRegisterPage(driver);
		
		ATRP.firstNameTextbox().clear();
		ATRP.firstNameTextbox().sendKeys(UtilKit.dataFactory.getFirstName());
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys(UtilKit.dataFactory.getLastName());
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys(UtilKit.dataFactory.getAddress());
		ATRP.emailaddressInput().clear();
		ATRP.emailaddressInput().sendKeys(UtilKit.dataFactory.getEmailAddress());
		
		ATRP.submitButton().click();
		
		UtilKit.suspendAction(500);
		Assert.assertTrue(ATRP.checkActiveElement("Phone"),  "Required active element: Phone Was Not Veryfied");
		
		ATRP.refreshButton().click();
	}		

	@Test(enabled=true, groups={"register", "performance"}, dependsOnMethods={"refreshRegistration"},
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
		
		UtilKit.stopWatch.split();
		long splitStartTime = UtilKit.stopWatch.getSplitTime(); /* the time between the start and the split in milliseconds
		 														(the time split started) */
		UtilKit.logger.info("Submit Button Split Started at : " + (float)splitStartTime/1000);
		ATRP.submitButton().click();
		
		UtilKit.suspendAction(500);
		// The current time in the stop watch minus the start of the Split time gives the duration of the split
		long splitEndTime =UtilKit.stopWatch.getTime();
		UtilKit.logger.info("Submit Button Split Ended at : " + (float)splitEndTime/1000);
		UtilKit.logger.info("Submit Button Split Duration Time : " + (float)(splitEndTime - splitStartTime)/1000);
		UtilKit.stopWatch.unsplit();
		
	}	
		
	@Test(enabled=true, groups={"register", "performance"}, 
			/*
			dependsOnMethods ={"phoneRequiredRegistration","countryRequiredRegistration",
								"genderRequiredRegistration","emailRequiredRegistration"},
								*/
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
		ATRP.firstNameTextbox().sendKeys(UtilKit.dataFactory.getFirstName());
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys(UtilKit.dataFactory.getLastName());
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys(UtilKit.dataFactory.getAddress());
		ATRP.emailaddressInput().clear();
		ATRP.emailaddressInput().sendKeys(UtilKit.dataFactory.getEmailAddress());
		ATRP.phoneInput().clear();
		ATRP.phoneInput().sendKeys( UtilKit.dataFactory.getNumberText(10));

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
		ATRP.firstNameTextbox().sendKeys(UtilKit.dataFactory.getFirstName());
		ATRP.lastNameTextbox().clear();
		ATRP.lastNameTextbox().sendKeys(UtilKit.dataFactory.getLastName());
		ATRP.addressTestArea().clear();
		ATRP.addressTestArea().sendKeys(UtilKit.dataFactory.getAddress());
		ATRP.emailaddressInput().clear();
		ATRP.emailaddressInput().sendKeys(UtilKit.dataFactory.getEmailAddress());
		ATRP.phoneInput().clear();
		ATRP.phoneInput().sendKeys(UtilKit.dataFactory.getNumberText(10));
		
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
	
	@Test(enabled = true, groups = {"other"})
	public void testSelectParser(){
		String stmt1 = "select first, addres, phone , zip from employeeData e where name = 'Efrain'";
		String stmt2 = "select e.first, e.addres, e.phone , e.zip from employeeData e where name = 'Efrain'";
		String stmt3 = "select avg(e.salary) as AverageSalary, UCASE(e.first) as Name, UCASE(e.last) as LastName from employeeData as Ave"; 
		String stmt4 = "select Shippers.shipperName, count(orders.orderId) as NumberOfOrders from orders"
						+ "LEFT JOIN shippers on orders.shipperId = Shippers.shiperId Group By ShipperName, NumberOfOrders";
		UtilKit.parseColumnsNew(stmt1);
		UtilKit.parseColumnsNew(stmt2);
		UtilKit.parseColumnsNew(stmt3);
		UtilKit.parseColumnsNew(stmt4);
	}
	
	@DataProvider
	public Object[][] registrationDataProvider(){
		return UtilKit.getTestData(project, application, "registration");
	}
	
}
