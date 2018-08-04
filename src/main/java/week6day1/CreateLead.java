package week6day1;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week3.dailychallenges.wdmethods.*;

public class CreateLead extends  Annotations {
	@Test(dataProvider="fetchData", groups= {"smoke"})
	public void createLead(String org, String fName, String lName, String eMail, String pho) {
		WebElement contactLink = locateElement("linktext", "Leads");
		click(contactLink);//edited by arivu
	//	WebElement createCntLink = locateElement("linktext", "Create Lead");
		click(createCntLink);
		WebElement eleUserName = locateElement("id", "createLeadForm_companyName");
		type(eleUserName, org);
		WebElement eleFName = locateElement("id", "createLeadForm_firstName");
		type(eleFName, fName);
		WebElement eleLName = locateElement("id", "createLeadForm_lastName");
		type(eleLName, lName);
		WebElement eleEmail = locateElement("id", "createLeadForm_primaryEmail");
		type(eleEmail, eMail);
		WebElement elePhone = locateElement("id", "createLeadForm_primaryPhoneNumber");
		type(elePhone, ""+pho);
		WebElement createLeadBtn = locateElement("class", "smallSubmit");
		click(createLeadBtn);
		
	}
	
}

