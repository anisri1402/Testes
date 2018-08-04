package week2hw;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Priya");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		driver.findElementByXPath("//a[text()='10152']").click();
		assertTrue(driver.getTitle().contains("View Lead"));
		driver.findElementByXPath("//a[text()='Edit']").click();
		driver.findElementByName("companyName").clear();
		driver.findElementByName("companyName").sendKeys("Accenture");
		driver.findElementByXPath("//input[@name='submitButton']").click();
		String compName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		System.out.println("The updated company name is: "+compName);
		Thread.sleep(3000);
		driver.close();
	}

}
