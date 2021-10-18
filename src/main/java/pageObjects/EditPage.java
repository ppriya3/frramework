package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
	WebDriver driver;
	
	public EditPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
@FindBy(name="firstname")
WebElement firstName;

@FindBy (name="lastname")
WebElement lastName;

@FindBy (name="email")
WebElement emailadd;

@FindBy (name="telephone")
WebElement telePhone;

@FindBy (xpath="//input[@value='Continue']")
WebElement submit;
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement logOut;

public WebElement firstName()
{
	return firstName;
	}
public WebElement lastName()
{
	return lastName;}

public WebElement emailadd()
{
	return emailadd;}
public WebElement telePhone()
{
	return telePhone;}
public WebElement submit()
{
	return submit;}
public WebElement logOut()
{
	return logOut;}

}
