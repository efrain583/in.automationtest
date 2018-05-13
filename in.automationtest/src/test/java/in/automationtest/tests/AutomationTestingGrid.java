package in.automationtest.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Util.UtilKit;
import in.automationtest.pages.AutomationTestingGridPage;

public class AutomationTestingGrid extends AutomationTestingBase {
	

		@Test(enabled = true, groups = {"grid", "performance"})
		public void accessGrid(){

			AutomationTestingGridPage ATGP = new AutomationTestingGridPage(driver);
			SoftAssert mySoftAssert  = new SoftAssert();
			
			ATGP.webTableLink().click();

			mySoftAssert.assertTrue(ATGP.verifyHeader(), "Unable to Verify  Header");
			
			mySoftAssert.assertTrue(ATGP.verifyNavegation(), "Unable to verify Navegation");
			
			Assert.assertTrue(ATGP.verifyRowCount(), "Unable to verify Row Count");

			Assert.assertTrue(ATGP.verifyCellCount(), "Unable to verify Cell Count");

		}
		
		@Test(enabled = true, groups = {"grid"}, dataProvider = "recordVerificationDataProvider", dependsOnMethods = {"accessGrid"})
		public void recordVerification(String email){
			
			AutomationTestingGridPage ATGP = new AutomationTestingGridPage(driver);
			
			Assert.assertTrue(ATGP.verifyRecord(email), " Unabled to verify :" + email); 
			
		}

		@DataProvider
		public Object[][] recordVerificationDataProvider(){
			
			return UtilKit.getTestData(project, application, "recordVerification");
		}
		
}
