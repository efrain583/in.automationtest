package in.automationtest.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import in.automationtest.pages.AutomationTestingGridPage;

public class AutomationTestingGrid extends AutomationTestingBase {
	

		@Test(enabled = true)
		public void AccessGrid(){

			AutomationTestingGridPage ATGP = new AutomationTestingGridPage(driver);
			SoftAssert mySoftAssert  = new SoftAssert();
			
			ATGP.webTableLink().click();
			mySoftAssert.assertTrue(ATGP.verifyHeader(), "Unable to Verify  Header");
			
			mySoftAssert.assertTrue(ATGP.verifyNavegation(), "Unable to verify Navegation");
			
			Assert.assertTrue(ATGP.verifyRowCount(), "Unable to verify Row Count");

		}

}
