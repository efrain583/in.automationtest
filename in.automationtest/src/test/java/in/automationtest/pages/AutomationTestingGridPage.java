package in.automationtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Util.UtilKit;

public class AutomationTestingGridPage {
	
	WebDriver  driver = null;
	
	public AutomationTestingGridPage(WebDriver driver){
		this.driver = driver;
	}
	
	By webTableLinkL = UtilKit.UIMap("WEBTABLE_LINK");
	By gridTableDivL = UtilKit.UIMap("GRID_TABLE_DIV");
	By gridHeaderDivL = UtilKit.UIMap("GRID_HEADER_DIV");
	By rowCellDivL =  UtilKit.UIMap("ROW_CELL_DIV");
	By gridNavigationDivL = UtilKit.UIMap("GRID_NAVIGATION_DIV");
	By itemsPerPageSelectL = UtilKit.UIMap("ITEMSPERPAGE_SELECT");
	
	Select itemsPerPageSelect = null;
	
	public WebElement webTableLink(){
		return driver.findElement(webTableLinkL);
	}
	public WebElement gridTableDiv(){
		return driver.findElement(gridTableDivL);
	}
	public WebElement gridHeaderDiv(){
		return gridTableDiv().findElement(gridHeaderDivL);
	}
	public WebElement rowCellDiv(){
		return gridTableDiv().findElement(rowCellDivL);
	}
	public WebElement gridNavigationDiv(){
		return gridTableDiv().findElement(gridNavigationDivL);
	}
	
	public boolean  verifyHeader(){
		if(this.gridTableDiv().findElements(gridHeaderDivL).size() ==1)
			return true;
		return false;
	}
	
	public boolean verifyNavegation(){
		if(this.gridTableDiv().findElements(gridNavigationDivL).size() ==1)
			return true;
		return false;
		
	}
	public boolean verifyRowCount(){
		itemsPerPageSelect = new Select(gridNavigationDiv().findElement(itemsPerPageSelectL));
		int ipp = Integer.parseInt(itemsPerPageSelect.getFirstSelectedOption().getText());
		int rowCount = this.gridTableDiv().findElements(rowCellDivL).size();
		System.out.println("Items Per Page :" + ipp + " Row Count : " + rowCount);
		if(ipp == rowCount){
			return true;
		}
		return false;
	}
	
	
	
	
}
