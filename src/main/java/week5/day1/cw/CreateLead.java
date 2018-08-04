package week5.day1.cw;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week3.dailychallenges.wdmethods.*;

public class CreateLead extends  Annotations {
	@Test(dataProvider="fetchData", groups= {"smoke"})
	public void createLead(String org, String fName, String lName, String eMail, int pho) {
		WebElement contactLink = locateElement("linktext", "Leads");
		click(contactLink);
		WebElement createCntLink = locateElement("linktext", "Create Lead");
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
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		Object[][] data= new Object[2][5];
		data[0][0]= "Testleaf";
		data[0][1]="Anirudh";
		data[0][2]="S";
		data[0][3]="ani@mailinator.com";
		data[0][4]=5296358;
		
		data[1][0]= "Testleaf";
		data[1][1]="Arivu";
		data[1][2]="S";
		data[1][3]="arvu@mailinator.com";
		data[1][4]=52948517;
		return data;
	}
}
