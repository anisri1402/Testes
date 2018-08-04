package week5.day2.cw;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {

	public static void main(String[] args) {
		ExtentHtmlReporter html=new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		String testcasename= "TC001";
		String testcasedesc = "Create a new lead";
		ExtentTest suiteTest= extent.createTest(testcasename, testcasedesc);
		ExtentTest test= suiteTest.createNode("Leads");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByClassName("inputBox").sendKeys("Tata");
		driver.findElementById("createLeadForm_firstName").sendKeys("vario");
		driver.findElementById("createLeadForm_lastName").sendKeys("rest");
		WebElement source = driver.findElementById("createLeadForm_industryEnumId");
		Select drop= new Select(source);
		drop.selectByVisibleText("Insurance");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("ani@mailinator.com");
		driver.findElementByName("submitButton").click();
	}

}
