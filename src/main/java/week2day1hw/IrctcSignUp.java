package week2day1hw;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IrctcSignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("userRegistrationForm:userName").sendKeys("jumanj345");
		driver.findElementById("userRegistrationForm:password").sendKeys("Robert12");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("Robert12");
		WebElement source = driver.findElementById("userRegistrationForm:securityQ");
		Select dropSec = new Select(source);
		dropSec.selectByIndex(6);
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("India");
		driver.findElementById("userRegistrationForm:firstName").sendKeys("Anirudh");
		driver.findElementById("userRegistrationForm:gender:0").click();
		driver.findElementById("userRegistrationForm:maritalStatus:1").click();
		WebElement dob= driver.findElementById("userRegistrationForm:dobDay");
		Select dropDate = new Select(dob);
		dropDate.selectByIndex(13);
		WebElement mob= driver.findElementById("userRegistrationForm:dobMonth");
		Select dropMon = new Select(mob);
		dropMon.selectByIndex(1);
		WebElement doy = driver.findElementById("userRegistrationForm:dateOfBirth");
		Select dropYr= new Select(doy);
		dropYr.selectByVisibleText("1993");
		WebElement occ = driver.findElementById("userRegistrationForm:occupation");
		Select occup= new Select(occ);
		occup.selectByIndex(2);
		WebElement country = driver.findElementById("userRegistrationForm:countries");
		Select selCount = new Select(country);
		selCount.selectByVisibleText("India");
		driver.findElementById("userRegistrationForm:email").sendKeys("anirudh3245@gmail.com");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9789069360");
		WebElement nation = driver.findElementById("userRegistrationForm:nationalityId");
		Select selNat = new Select(nation);
		selNat.selectByVisibleText("India");
		driver.findElementById("userRegistrationForm:address").sendKeys("25 TVK st");
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600053", Keys.TAB);
		Thread.sleep(5000);
		WebElement city = driver.findElementById("userRegistrationForm:cityName");
		Select selCity = new Select(city);
		selCity.selectByVisibleText("Tiruvallur");
		driver.findElementById("userRegistrationForm:cityName").sendKeys(Keys.TAB);
		Thread.sleep(5000);
		WebElement postOffice= driver.findElementById("userRegistrationForm:postofficeName");
		Select selPost= new Select(postOffice);
		selPost.selectByIndex(1);
		driver.findElementById("userRegistrationForm:landline").sendKeys("04426580894");
	}

}
