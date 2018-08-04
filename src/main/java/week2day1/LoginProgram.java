package week2day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LoginProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		List<WebElement> allOptions = drop.getOptions();
		int size =allOptions.size();
		for (WebElement src : allOptions) {
			System.out.println(src.getText());
		}
		//driver.findElementByName("submitButton").click();
	}

}
