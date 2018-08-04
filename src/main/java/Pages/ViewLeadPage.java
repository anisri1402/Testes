package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import week3.dailychallenges.wdmethods.Annotations;

public class ViewLeadPage extends Annotations {
	
	public ViewLeadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='viewLead_firstName_sp']")
	WebElement eleViewElement;
	
	
	
	public ViewLeadPage verifyName(String fName) {
		verifyExactText(eleViewElement, fName);
		return this;
	}
}
