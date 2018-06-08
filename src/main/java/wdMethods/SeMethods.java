package wdMethods;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.NoSuchAttributeException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import wdMethods.WdMethods;

public class SeMethods implements WdMethods{

	int i = 1;
	RemoteWebDriver driver ;
	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver = new ChromeDriver();			
			} else {
				System.setProperty("webdriver.gecko.driver", "./drivers/chromedriver.exe");
			driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser is Launched");
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("Browser is not launched ");
			//throw new RuntimeException();
		}
			
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id":
				return	driver.findElementById(locValue);		
			case "name":
				return	driver.findElementByName(locValue);			
			case "class":
				return	driver.findElementByClassName(locValue);			
			case "link":
				return	driver.findElementByLinkText(locValue);			
			case "tag":
				return	driver.findElementByTagName(locValue);			
			case "xpath":
				return	driver.findElementByXPath(locValue);
			default:
				break;
			}
			return null;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("WebElement Not Available");
			throw new RuntimeException();
		}
		finally {
			takeSnap();
		}
	}

	public WebElement locateElement(String locValue) {
		try {
			return locateElement("id", locValue);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("The locator used ,doesn't have a proper locator value"+locValue);
		}finally {
			takeSnap();
		}
		return null;
		}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The Value is Entered");
			takeSnap();
		} catch (InvalidSelectorException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("the element i not intractable");
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("the element i not intractable");
		}finally {
			takeSnap();
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The Element Is Clicked");
			takeSnap();
		} catch (InvalidSelectorException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("the element is not clicked");
		}finally {
			takeSnap();
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		try {
			ele.click();
			System.out.println("The Element Is Clicked");
		} catch (InvalidSelectorException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("the element is not clicked with snap");
		}
		
	}

	public String getText(WebElement ele) {
		String text = null ;
		try {
			 ele.getText();
			System.out.println("The text of the"+ele+"is"+text);
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("selected text is unable to retrive");
			
		}finally {
			takeSnap();
		}
		return text;
	}
	public void selectDropDownUsingText(WebElement ele, String value) {
		
		try {
			Select option =new Select(ele);
			
			option.selectByVisibleText(value);
			System.out.println("The "+ele+"dropdown is selected with the value"+value);
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("The element is not found in the dropbox");
		}finally {
			takeSnap();
		}
		}
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		try {
			Select dd=new Select(ele);
			dd.selectByIndex(index);
			System.out.println("The" + ele + " Dropdown is selected with value " + index);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element is not found in the dropbox");
		}
		finally {
			takeSnap();
		}
	}

	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
			try {
				String title = driver.getTitle();
				if(title.equalsIgnoreCase(expectedTitle)) {
					System.out.println("The title Matched");
				}else {
					System.out.println("The title is not Matched");
				}
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.err.println("The element is not found in the dropbox");
	}
	finally {
		takeSnap();
	}		
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			String text = ele.getText();
			if(expectedText.equalsIgnoreCase(text))
			{
				System.out.println("The given Exact text is matched");
			}else
			{
				System.out.println("The given Exact text is not matched ");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element is not found ");
		}
		finally {
			takeSnap();
		}		

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

		try {
			String text = ele.getText();
			if(expectedText.equalsIgnoreCase(text))
			{
				System.out.println("The given Exact text is matched");
			}else
			{
				System.out.println("The given Exact text is not matched ");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element is not found ");
		}
		finally {
			takeSnap();
		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			String attri = ele.getAttribute(attribute);
			if(attri.equals(value))
			{
				System.out.println("The attribute is matched");
			}else
			{
				System.out.println("The attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element is not found ");
		}
		finally {
			takeSnap();
		}
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			String partialAttri = ele.getAttribute(attribute);
			if(partialAttri.contains(value))
			{
				System.out.println("The partial attribute is matched");
			}else
			{
				System.out.println("The partial attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element is not found ");
		}
		finally {
			takeSnap();
		}
	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			if(ele.isSelected())
			{
				System.out.println("The element"+ ele + "is selected");
			}else
			{
				System.out.println("The element"+ ele + "is not selected" );
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("No Such Element Present");
			throw new RuntimeException();
		}
		finally {
			takeSnap();
		}
	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			if(ele.isDisplayed())
			{
				System.out.println("The element" + ele + "is displayed");
			}else
			{
				System.out.println("The element" + ele + "is not displayed");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("No Such Element Present");
			throw new RuntimeException();
		}
		finally {
			takeSnap();
		}

	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		try {
			Set<String> allWindow = driver.getWindowHandles();
			List<String> listOfWindow = new ArrayList<String>();
			listOfWindow.addAll(allWindow);
			String window = listOfWindow.get(index);
			driver.switchTo().window(window);
			System.out.println(driver.getCurrentUrl());
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("No Window Present");
			throw new RuntimeException();
		}

	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().frame(ele);
			System.out.println("Switched to Frame"+ ele);
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			System.err.println("No Frame Present");
			throw new RuntimeException();
		}

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert accept");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("No Alert Present");
			throw new RuntimeException();
		}

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert Dismiss");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("No Alert Present");
			throw new RuntimeException();
		}

	}

	public String getAlertText() {
		String text=null;
		// TODO Auto-generated method stub
		try {
			text = driver.switchTo().alert().getText();
			
			System.out.println("Alert Text");
			
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			text="No Alert present";
			System.err.println(text);
			throw new RuntimeException();
				
		}
		return text;
		
}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("The browser is closed");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Browsers did not close");
			
		}
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			System.out.println("All browsers is closed");
		} catch (NullPointerException e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("All Browsers did not close");
			
		}
		
		}
	public void countRowsAndColumn(WebElement ele,int rowvalue, int colunmvalue) {
		List <WebElement> allrows =ele.findElements(By.tagName("tr"));
		int rowcount =allrows.size();
		System.out.println("The size of the total rows in "+ele+"are" +rowcount);
		WebElement selectTheRow = allrows.get(rowvalue);
		List<WebElement> allcolumns = selectTheRow.findElements(By.tagName("td"));
		WebElement SelectTheColumn = allcolumns.get(colunmvalue);
		click(SelectTheColumn);
	}
}