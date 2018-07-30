package in.automationtest.pages;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	By headerCellDivL = UtilKit.UIMap("HEADER_CELL_DIV");
	By tableRowDivL = UtilKit.UIMap("TABLE_ROW_DIV");
	By rowCellDivL =  UtilKit.UIMap("ROW_CELL_DIV");
	By gridNavigationDivL = UtilKit.UIMap("GRID_NAVIGATION_DIV");
	By itemsPerPageSelectL = UtilKit.UIMap("ITEMSPERPAGE_SELECT");
	
	Select itemsPerPageSelect = null;
	
	public WebElement webTableLink(){
		UtilKit.waitForElement(webTableLinkL, driver, "Displayed", 2);
		return driver.findElement(webTableLinkL);
	}
	public WebElement gridTableDiv(){
		return driver.findElement(gridTableDivL);
	}
	public WebElement gridHeaderDiv(){
		return gridTableDiv().findElement(gridHeaderDivL);
	}
	public WebElement gridNavigationDiv(){
		return driver.findElement(gridNavigationDivL);
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
		int rowCount = this.gridTableDiv().findElements(tableRowDivL).size();
		System.out.println("Items Per Page :" + ipp + " Row Count : " + rowCount);
		if(ipp == rowCount){
			return true;
		}
		return false;
	}
	
	public boolean verifyCellCount(){
		itemsPerPageSelect = new Select(gridNavigationDiv().findElement(itemsPerPageSelectL));
		int ipp = Integer.parseInt(itemsPerPageSelect.getFirstSelectedOption().getText());
		int rowCount = this.gridTableDiv().findElements(tableRowDivL).size();
		System.out.println("Items Per Page :" + ipp + " Row Count : " + rowCount);
		// Find out the columns count based on the header
		int colCount = this.gridHeaderDiv().findElements(headerCellDivL).size();
		int gridCellCount = this.gridTableDiv().findElements(rowCellDivL).size();
		if(gridCellCount == (rowCount * colCount)){
			return true;
		}
		return false;
		
	}
	
	public boolean verifyRecord(String email){
		
		List<WebElement> rowList = (ArrayList<WebElement>) gridTableDiv().findElements(tableRowDivL);
		for(int i = 0; i < rowList.size(); i++){
			List<WebElement> cellList = (ArrayList<WebElement>) rowList.get(i).findElements(rowCellDivL);
			for(int j = 0; j < cellList.size(); j++){
				if(j == 0){
					UtilKit.logger.info("current row :" + cellList.get(j).getText());
				}
				if(cellList.get(j).getText().equals(email)){
					UtilKit.logger.info("Grid Record Found in row :" + (i+1) + " Cell : " + (j+1) );
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
}
