package week5.day1.cw;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import week3.dailychallenges.wdmethods.*;

public class MergeLead extends Annotations{
	//@Test(enabled=false)
		@Test(groups= {"regression"})
	public void MLead() throws InterruptedException {
		
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "crmsfa");
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement CrmLink = locateElement("linktext","CRM/SFA");
		click(CrmLink);
		
		WebElement CreateLead = locateElement("linktext","Create Lead");
		click(CreateLead);
		
		//Click to access the Merge Lead
		 WebElement mergeLead=locateElement("linktext","Merge Leads");
		 click(mergeLead);
		

		 //From Lead Selection 
		
		 WebElement fromLeadIcon=locateElement("xpath", "(//*[@alt='Lookup'])[1]");
		 click(fromLeadIcon);
		 switchToWindow(1);	 
	     WebElement findFromLeadName = locateElement("name", "firstName");
	     type(findFromLeadName, "Navaneethan");
		 //Find Lead Button
	     WebElement findFromLead = locateElement("class", "x-btn-text");
	     click(findFromLead);
	     Thread.sleep(1000);    
	     
	     WebElement fromLeadSelect = locateElement("xpath", "(//a[text()='Navaneethan'])[1]");
	     //clickWithOutSnap(fromLeadSelect);
	     Thread.sleep(1000);
	     switchToWindow(0);
	     
	     //To Lead Selection
	     
	     WebElement icon2=locateElement("xpath", "(//*[@alt='Lookup'])[2]");
		// clickWithOutSnap(icon2);
		 switchToWindow(1);
	     
	     WebElement findToLeadName1 = locateElement("xpath", "//input[@name='firstName']");
	     type(findToLeadName1, "Gopinath");
		
	     WebElement findToLead = locateElement("xpath", "//button[text()='Find Leads']");
	     click(findToLead);
	     Thread.sleep(1000);   
	     //switchToWindow(0);
	     
	     WebElement toLeadSelect = locateElement("xpath", " (//a[text()='Gopinath'])[1]");
	  //   clickWithOutSnap(toLeadSelect);
	     Thread.sleep(1000);
	     switchToWindow(0);
	     
	    //Perform Merger for both From Lead and To Lead
	     
	     WebElement Merge = locateElement("class", "buttonDangerous");
	     System.out.println(Merge);
	     //clickWithOutSnap(Merge);
	     acceptAlert();
	     
	     //Edit the Merge Leads     
	     WebElement editMergeLeads=locateElement("xpath","//a[@class='subMenuButton'][3]");
	     Thread.sleep(1000);
		 click(editMergeLeads);
		 
		 //Update the EditLeads	 
		 WebElement updateLeads=locateElement("xpath","(//input[@class='smallSubmit'])[1]");
	     click(updateLeads);
	     
	     //Duplicate Lead
	    WebElement duplicateLead=locateElement("xpath","//a[text()='Duplicate Lead']");
	    click(duplicateLead);
	    
	    WebElement firstName = locateElement("id", "createLeadForm_firstName");
		type(firstName, "Nesakkannan");
		
		//Edit Submit for Create Lead
		WebElement createLeadSubmit = locateElement("class","smallSubmit");
		click(createLeadSubmit);

	      
	      //Delete  Lead
	     WebElement deleteLeads=locateElement("xpath","//a[@class='subMenuButtonDangerous']");
	     click(deleteLeads);
	      
	      
	     
//	     WebElement eFindLeads=locateElement("linktext","Find Leads");
//		 click(eFindLeads);
//		 
//		 WebElement fLeadId1= locateElement("xpath", "//*[@name='id']");
//		 System.out.println(fLeadId1);
//	     type(fLeadId1, "11752");
//	     
//	     
//	     WebElement btnFindLead=locateElement("xpath","//button[text()='Find Leads']");
//		 click(btnFindLead);
		 
		
	}
}
