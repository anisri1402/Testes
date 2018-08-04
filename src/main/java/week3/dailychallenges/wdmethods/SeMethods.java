package week3.dailychallenges.wdmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import week6day1.Reporter;

public class SeMethods extends Reporter implements WdMethods{

	public static RemoteWebDriver driver;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
	int i =1;

		
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				//sSystem.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//System.out.println("The browser:" + browser + " launched successfully");
			reportStep("The browser:" + browser + " launched successfully", "pass");
		} catch (WebDriverException e){			
			//System.out.println("The browser:" + browser + " could not be launched");
			reportStep("The browser:" + browser + " could not be launched","fail");
		}
		
	}


	public void startApp(String browser) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/internetexplorerserver.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(sUrl);
			driver.manage().window().maximize();	
		
			reportStep("The browser:" + browser + " launched successfully", "pass");
			
		} catch (WebDriverException e) {			
			reportStep("The browser:" + browser + " could not be launched", "fail");
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			
			case("id"): return driver.findElementById(locValue);
			case("linkText"): return driver.findElementByLinkText(locValue);
			case("xpath"):return driver.findElementByXPath(locValue);
			case("name"): return driver.findElementByName(locValue);
			case("className"): return driver.findElementByClassName(locValue);
			case("tag"):return driver.findElementByTagName(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" and with value "+locValue+" not found.", "fail");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			reportStep("WebDriverException", "fail");
		}
		return null;
	}
	
	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}


	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			//System.out.println("The data: "+data+" entered successfully");
			reportStep("The data: "+data+" entered successfully", "pass");
		} catch (InvalidElementStateException e) {
			//System.out.println("The data: "+data+" could not entered");
			reportStep("The data: "+data+" could not entered", "fail");
		} catch (WebDriverException e) {
			//System.out.println("WebDriverException"+e.getMessage());
			reportStep("The data: "+data+" could not entered", "fail");
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();			
			reportStep("The element : "+text+" is clicked successfully", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not clicked", "fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(),"fail");
		} 

	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();
			reportStep("The element : "+text+" is clicked successfully","pass");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not clicked","fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(),"fail");
		} 
	}

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(),"fail");
		}
		return bReturn;
	}

	public String getTitle() {		
		String title = "";
		try {
			title =  driver.getTitle();
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(),"fail");
		} 
		return title;
	}

	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "fail");
		} 
		return bReturn;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			reportStep("The dropdown is selected with text "+value, "pass");
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(), "fail");
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index, "pass");
		} catch (WebDriverException e) {
			reportStep("WebDriverException"+e.getMessage(),"fail");
		} 

	}

	public boolean verifyTitle(String expectedTitle) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(expectedTitle)) {
				reportStep("The expected title "+expectedTitle+" matches the actual "+getTitle(),"pass");
				bReturn= true;
			}else {
				reportStep(getTitle()+" The expected title "+expectedTitle+" doesn't matches the actual "+getTitle(),"fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} 
		return bReturn;

	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				reportStep("The expected text matches the actual "+expectedText, "pass");
			}else {
				reportStep("The expected text doesn't matches the actual "+expectedText,"fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} 

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText, "pass");
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText, "fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} 
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value, "pass");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value, "fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} 

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"pass" );
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value, "fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected", "pass");
			} else {
				reportStep("The element "+ele+" is not selected", "fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","pass");
			} else {
				reportStep("The element "+ele+" is not visible","fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} 
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index, "fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("switch In to the Frame "+ele,"pass");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} 
	}

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.","pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		}  
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.","pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.", "fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} 

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(),"fail");
		} 
		return text;
	}

	public void takeSnap(){
		 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./snaps/snap"+i+".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.","pass");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken","fail");
		}
		
	}

	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","pass");
		} catch (Exception e) {
			reportStep("The browser could not be closed","fail");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","pass");
		} catch (Exception e) {
			reportStep("The browsers could not be closed","fail");
		}
	}


	@Override
	public void switchToWindow(String title) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void closeCurrentWindow(String parentTitle) {
		// TODO Auto-generated method stub
		
	}



	


	

}