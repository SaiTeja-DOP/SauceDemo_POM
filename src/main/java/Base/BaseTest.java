package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest {

	
	protected WebDriver d;
	
	@BeforeMethod
	public void setUp(){
		
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		d.get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		d.close();
	}
	
}
