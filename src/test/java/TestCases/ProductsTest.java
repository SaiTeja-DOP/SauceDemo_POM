package TestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseTest;
import PageObjects.HomePage;
import PageObjects.Products;
import Utilities.ExtentReportManager;

@Listeners(Utilities.ExtentListener.class)

public class ProductsTest extends BaseTest {

	Products p;
	HomePage hp;

    
    @BeforeMethod
    public void setUpPages() {
        hp = new HomePage(d);   
        p = new Products(d);// driver is now initialized u can't directly initialize iin class as bastest class driver is initialized in before method 
    }
	

	@Test
	public void Prodlist() {
		
		hp.clearText();
		hp.enterCreds("standard_user", "secret_sauce");
		
		hp.clickLogin();
		
		String head = hp.getProductsTitle();
		assertEquals(head, "Product");
		p.checkList();
		
	}
	
	@Test
	public void Verify_Add_to_Cart_button()
	{
		hp.clearText();
		hp.enterCreds("standard_user", "secret_sauce");
		hp.clickLogin();
		String head = hp.getProductsTitle();
		assertEquals(head, "Products");
		int cc = p.cartCount();
		assertEquals(cc, p.inventories.size());
		System.out.println("Total Add To Cart Buttons is :"+cc + "\nInventory List Count is:"+ p.inventories.size());
	}
	

	
}
