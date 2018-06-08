package week1;


import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import wdMethods.SeMethods;

public class ProjectMethods extends SeMethods{

	// TODO Auto-generated method stub
	
	@BeforeMethod	
	public void login() {
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement userName = locateElement("id","username");
		type(userName, "DemoSalesManager");
		WebElement passWord = locateElement("id", "password");
		type(passWord, "crmsfa");
		WebElement login = locateElement("class", "decorativeSubmit");
		click(login);	
		WebElement crmsfaImage = locateElement("link", "CRM/SFA");
		click(crmsfaImage);
		

	}
	
	@AfterMethod
	public void close() {
		closeBrowser();
		

	}
}