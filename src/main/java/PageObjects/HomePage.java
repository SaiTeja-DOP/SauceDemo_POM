package PageObjects;

import Base.Base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base {
	
	
	@FindBy(name = "user-name") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(name = "login-button") WebElement login;
	@FindBy(css = ".error-message-container.error") WebElement error;
	@FindBy(xpath = "//span[contains(@class,'title')]")  WebElement productsTitle;
	
	
	public HomePage(WebDriver d) {
		super(d);// TODO Auto-generated constructor stub
	}

	public void clearText() {
		username.clear();
		Actions act = new Actions(d);
		act.click(password)
		   .keyDown(Keys.CONTROL)
		   .sendKeys("a")
		   .keyUp(Keys.CONTROL)
		   .sendKeys(Keys.BACK_SPACE)
		   .build()
		   .perform();
	}
	
	public void enterCreds(String usr, String pwd) {
		username.sendKeys(usr);
		password.sendKeys(pwd);
	}
	
	public void  clickLogin() {
		
		login.click();
		
	}
	
	 public String getProductsTitle() {
	        return productsTitle.getText();
	    }
	
	public String getError() {
		
		return error.getText();
	}
}
