import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Flipkart {

	
	RemoteWebDriver driver;
	@Test
    public void login() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.flipkart.com/");
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElementByLinkText("Login & Signup");
    	driver.findElementByClassName("_2zrpKA ").sendKeys("8760629122");
    	driver.findElementByXPath("//input[@type='password']").sendKeys("sekarbanu");
    	driver.findElementByXPath("(//button[@type='submit'])[2]").click();
    	Actions perform = new Actions(driver);
    	WebElement TVsandAppliancesButton= driver.findElementByXPath("//span[Text()='TVs & Appliances");
    	WebElement samsungButton= driver.findElementByXPath("//span[Text()='Samsung']");
    	perform.moveToElement(TVsandAppliancesButton);
    	Thread.sleep(20000);
    	
    	
    	
    	
    			
    	
    	
    }
		

}
