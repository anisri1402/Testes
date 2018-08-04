package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MyHomePage;
import week3.dailychallenges.wdmethods.Annotations;

public class TC002_CreateLeadNeg extends Annotations {
	@BeforeTest
	public void setValues() {
		excelFileName="createleadNeg";
		testName= "Create Lead";
		testDesc="Create a new Lead";
		category="smoke";
		author="Anirudh";
		moduleName="Leads";		
	}
	@Test(dataProvider="fetchData")
	public void createLead(String cName, String fName, String lName, String eMail, String phone, String errMsg) {
		new MyHomePage()
		.clickLeads()
		.clickCreateLead()
		.cName(cName)
		.fName(fName)
		.lName(lName)
		.eMail(eMail)
		.phone(phone)
		.submitLeadsNeg()
		.errorMessage(errMsg);
	}
}
