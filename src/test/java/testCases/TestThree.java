package testCases;
	import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
	import org.testng.annotations.Test;

	import resources.BaseClass;
	@Test
	
	public class TestThree extends BaseClass {
		 public WebDriver driver;
		public void Threetest() throws IOException, InterruptedException {
		driver=initializeDriver();
		driver.get("https://www.gmail.com/");
		System.out.println("Test three");
		System.out.println("This new change has been done ny Priya");
		
		Assert.assertTrue(false);
		driver.close();

}
}