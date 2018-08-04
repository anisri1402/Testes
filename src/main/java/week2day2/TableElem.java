package week2day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class TableElem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		int size = driver.findElementsByXPath("//div[@id='contentblock']/section/div/table//tr[2]/td").size();
		System.out.println("The no of columns: " +size);
		int sizeRow = driver.findElementsByXPath("//div[@id='contentblock']/section/div/table//tr").size();
		System.out.println("The no of rows: " +sizeRow);
		String learn = driver.findElementByXPath("//div[@id='contentblock']/section/div/table//tr[3]/td[2]/font").getText();
		System.out.println("The value is: " +learn);
		driver.findElementByXPath("//div[@id='contentblock']/section/div/table//tr[4]/td[3]/input").click();
	}

}
