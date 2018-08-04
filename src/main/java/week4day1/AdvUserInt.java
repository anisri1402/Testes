package week4day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvUserInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.findElementByXPath("//a[text()='Droppable']").click();
		driver.switchTo().frame(0);
		WebElement eleAccept = driver.findElementByXPath("//p[text()='Drag me to my target']");
		WebElement fraDrp = driver.findElementByXPath("//div[@id='droppable']");
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(eleAccept, fraDrp.getLocation().getX(), fraDrp.getLocation().getY()).perform();
	}

}
