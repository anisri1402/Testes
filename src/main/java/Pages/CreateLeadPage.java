package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import week3.dailychallenges.wdmethods.Annotations;

public class CreateLeadPage extends Annotations {
	
	public CreateLeadPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id='createLeadForm_companyName']")
	WebElement eleComName;
	
	@FindBy(xpath = "//*[@id='createLeadForm_firstName']")
	WebElement elefName;
	
	@FindBy(xpath = "//*[@id='createLeadForm_lastName']")
	WebElement elelName;
	
	@FindBy(xpath = "//*[@id='createLeadForm_primaryEmail']")
	WebElement eleEMail;
	
	@FindBy(xpath = "//*[@id='createLeadForm_primaryPhoneNumber']")
	WebElement elePhone;
	
	@FindBy(xpath = "//*[@class='smallSubmit']")
	WebElement eleSubmit;
	
	@FindBy(className= "errorList")
	WebElement eleErrMsg;
	
	public CreateLeadPage cName(String cName) {
		type(eleComName, cName);
		return this;
	}
	
	public CreateLeadPage fName(String fName) {
		type(elefName, fName);
		return this;
	}
	public CreateLeadPage lName(String lName) {
		type(elelName, lName);
		return this;
	}
	
	public CreateLeadPage eMail(String eMail) {
		type(eleEMail, eMail);
		return this;
	}
	
	public CreateLeadPage phone(String phone) {
		type(elePhone, phone);
		return this;
	}
	
	public ViewLeadPage submitLeads() {
		click(eleSubmit);
		return new ViewLeadPage();
	}
	
	public CreateLeadPage submitLeadsNeg() {
		click(eleSubmit);
		return this;
	}
	
	public CreateLeadPage errorMessage(String errMsg) {
		type(eleErrMsg, errMsg);
		return this;
	}
}
