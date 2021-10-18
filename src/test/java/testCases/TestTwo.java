package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass;
@Test
public class TestTwo extends BaseClass {
	public WebDriver driver;
	public void Twotest() throws IOException, InterruptedException {
	driver=initializeDriver();
	driver.get("https://www.amazon.com/");
	System.out.println("Test Two");
	System.out.println("Someone made changes to code")
	Thread.sleep(2000);
	driver.close();
	
	
	}
}
