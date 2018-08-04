package week3.dailychallenges.wdmethods;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week6day1.ExcelData;
import week6day1.ReadExcel;

public class Annotations extends SeMethods{
	public String excelFileName,testName,testDesc,category,author,moduleName;
	
	@BeforeSuite
	public void startSuite() {
		beginResult();
	}
	
	@BeforeClass
	public void startTestRe() {
		startTest(testName, testDesc);
	}

	//@Parameters({"url","pwd","uName"})
	@BeforeMethod(groups= {"smoke","sanity"})
	public void login() {
		startTestIteration(moduleName,author,category);
		startApp("chrome", "http://leaftaps.com/opentaps");
		type(locateElement("id", "username"), "DemoSalesManager");
		type(locateElement("id", "password"), "crmsfa");
		click(locateElement("className", "decorativeSubmit"));
		click(locateElement("linkText", "CRM/SFA"));
	}
	
	@AfterMethod(groups= {"smoke","sanity"})
	public void closeApp() {
		closeBrowser();
	}
	
	@AfterSuite
	public void stopSuite() {
		endResult();
	}
	
	@DataProvider(name = "fetchData"/*, indices = {1}*/)
	public Object[][] getData() throws IOException {		
		ReadExcel excel = new ReadExcel();
		return excel.readExcel(excelFileName);		
	}
	
	
	
}