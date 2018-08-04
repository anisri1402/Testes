package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import week3.dailychallenges.wdmethods.Annotations;

public class MyLeadsPage extends Annotations {
	
	public MyLeadsPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Create Lead']")
	WebElement eleCreateLead;
	
	public CreateLeadPage clickCreateLead() {
		click(eleCreateLead);
		return new CreateLeadPage();
	}
}
