package week5.day1.cw;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import week3.dailychallenges.wdmethods.*;

public class EditLead extends Annotations {
	// @Test(dependsOnMethods= {"week5.day1.cw.CreateLead.createLead"})
		@Test(groups= {"sanity"})
	 public void editLead() {
			WebElement contactLink = locateElement("linktext", "Leads");
			click(contactLink);
			WebElement createCntLink = locateElement("linktext", "Find Leads");
			click(createCntLink);
			WebElement locateElement = locateElement("xpath", "//label[text()='Lead ID:']/following::input[2]");
			type(locateElement, "First Name");
			WebElement findBtn = locateElement("xpath", "//button[text()='Find Leads']");
			click(findBtn);
		}
}
		
