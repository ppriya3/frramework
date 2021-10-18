package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.EditPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;



public class EditInfo extends BaseClass{
	WebDriver driver;
	
	
	@Test
	public void editInfo() throws InterruptedException {
	LandingPage landingPage=new LandingPage(driver);
	landingPage.myAccountDropdown().click();
	landingPage.loginOption().click();
	
	LoginPage loginPage=new LoginPage(driver);
	
	loginPage.emailAddressField().sendKeys(prop.getProperty("email"));
	loginPage.passwordField().sendKeys(prop.getProperty("password"));
	loginPage.loginButton().click();

	AccountPage accountPage=new AccountPage(driver);
	accountPage.editAccountInformationOption().click();
	
	EditPage editPage=new EditPage(driver);
	editPage.firstName().clear();
	editPage.firstName().sendKeys("Priya");
	Thread.sleep(2000);
	editPage.lastName().clear();
	editPage.lastName().sendKeys("Prasanna");
	Thread.sleep(2000);
	editPage.emailadd().clear();
	editPage.emailadd().sendKeys("priaprp@gmail.com");
	Thread.sleep(2000);
	editPage.telePhone().clear();
	editPage.telePhone().sendKeys("9098769087");
	Thread.sleep(2000);
	editPage.submit().click();
	boolean res=driver.getPageSource().contains("Your account has been successfully updated");
	Thread.sleep(2000);
	if(res==true)
	{
		Assert.assertTrue(true);
		System.out.println("Test case is passed");
		editPage.logOut().click();
	}
	else
	{
		System.out.println("Test case has failed");
	}
}
@BeforeMethod
public void openApplication() throws IOException {
driver = initializeDriver();
driver.get(prop.getProperty("url"));

}
@AfterMethod

public void closure() {
	driver.close();
}
}


