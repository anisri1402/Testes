package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import week3.dailychallenges.wdmethods.Annotations;

public class MyHomePage extends Annotations {
	
	public MyHomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Leads']")
	WebElement eleLeads;
	
	public MyLeadsPage clickLeads() {
		click(eleLeads);
		return new MyLeadsPage();
	}
}
