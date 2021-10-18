package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;



public class LoginTest extends BaseClass{
	public static Logger log;
	public WebDriver driver;
	
	@BeforeMethod
	public void openApplication() throws IOException {
		System.setProperty("log4j.configurationFile", "./resources/log4j2.xml");
	log=LogManager.getLogger(LoginTest.class.getName());
	//log = LogManager.getLogger(LoginTest.class);
	
	driver = initializeDriver();
	log.debug("Browser got launched");
	driver.get(prop.getProperty("url"));
	log.debug("Navigated to application URL");
	}
	
	
	@Test(dataProvider="getloginData")
	public void login(String email,String password,String expectedResult) throws IOException {
		
	LandingPage landingPage=new LandingPage(driver);
	landingPage.myAccountDropdown().click();
	log.debug("Clicked on My Account dropdown");
	landingPage.loginOption().click();
	log.debug("Clicked on login option");
	
	LoginPage loginPage=new LoginPage(driver);
	loginPage.emailAddressField().sendKeys(email);
	log.debug("Email address is entered");
	loginPage.passwordField().sendKeys(password);
	log.debug("Password is entered");
	loginPage.loginButton().click();
	log.debug("Clicked on login button");
	AccountPage accountPage=new AccountPage(driver);
	
	String actualResult=null;
	try
	{
		if(
		accountPage.editAccountInformationOption().isDisplayed()){
			log.debug("User is logged in!!!");
		actualResult="Successful";}
		
	}catch(Exception e)
	{
		log.error("User is unable to log in!!!");
		actualResult="failure";
		
	}
	
	if(actualResult.equals(expectedResult))
	{
	log.info("login test got passed");}
	else {
		log.error("login test is failed");
	}
	}
	@AfterMethod
	
	public void closure() {
		driver.close();
		log.debug("Browser is closed");
	}
	
	@DataProvider
	public Object[][] getloginData() {
		Object[][] data= {{"arun.selenium@gmail.com","Second@123","Successful"},{"dummy@test.com","dummy","failure"}};
		return data;
	}
	}


