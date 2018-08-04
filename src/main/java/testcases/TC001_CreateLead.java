package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MyHomePage;
import week3.dailychallenges.wdmethods.Annotations;

public class TC001_CreateLead extends Annotations {
	@BeforeTest
	public void setValues() {
		excelFileName="createlead";
		testName= "Create Lead";
		testDesc="Create a new Lead";
		category="smoke";
		author="Anirudh";
		moduleName="Leads";		
	}
	@Test(dataProvider="fetchData")
	public void createLead(String cName, String fName, String lName, String eMail, String phone) {
		new MyHomePage()
		.clickLeads()
		.clickCreateLead()
		.cName(cName)
		.fName(fName)
		.lName(lName)
		.eMail(eMail)
		.phone(phone)
		.submitLeads()
		.verifyName(fName);
	}
}
