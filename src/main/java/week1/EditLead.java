package week1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;



public class EditLead extends ProjectMethods{
	@Test
	public void run2() {
		
		WebElement leads = locateElement("link", "Leads");
		click(leads);
		WebElement findLead = locateElement("xpath", "//a[text()='Find Leads']");
		click(findLead);
		WebElement findFirstName = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(findFirstName, "Hariprasath");
		WebElement findLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(findLeadsButton);
		WebElement clickFirstResult = locateElement("xpath", "(//*[text()='Hariprasath'])[1]");
		click(clickFirstResult);
		verifyTitle("View Lead | opentaps CRM");
		WebElement clickEdit = locateElement("xpath", "(//a[@class='subMenuButton'])[3]");
		click(clickEdit);
		WebElement companyNameChange = locateElement("updateLeadForm_companyName");
		type(companyNameChange, "ZOHO");
		WebElement update = locateElement("xpath", "//input[@name='submitButton']");
		click(update);
		WebElement newCompanyName = locateElement("viewLead_companyName_sp");
		//verifyPartialText(newCompanyName, "ZOHO");
		WebElement findLeadButton2 = locateElement("xpath", "//a[text()='Find Leads']");
		click(findLeadButton2);
		WebElement clickPhoneNumber = locateElement("xpath", "(//span[@class='x-tab-strip-text '])[2]");
		click(clickPhoneNumber);
		WebElement phoneNumberEntry = locateElement("xpath", "//input[@name='phoneCountryCode']");
		type(phoneNumberEntry, "+91");
		WebElement phoneAreaCode2 = locateElement("xpath", "//input[@name='phoneAreaCode']");
		type(phoneAreaCode2, "068");
		WebElement phonenumber2 = locateElement("xpath", "//input[@name='phoneNumber']");
		type(phonenumber2, "7528373762");
		WebElement clickFindLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(clickFindLead);
		
	}

}
