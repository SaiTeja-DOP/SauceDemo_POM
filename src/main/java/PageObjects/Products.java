package PageObjects;

import java.util.List;

import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.Base;


public class Products extends Base{
	String Sa;
	int count=0;
	public Products(WebDriver d) {
		// TODO Auto-generated constructor stub
		super(d);
	}
  
	@FindBy(className = "inventory_item_name")  public List<WebElement> inventories;
	@FindBy(className = "inventory_item_price") List<WebElement> prices;
	@FindBy(xpath = "//button[text()='Add to cart']") List<WebElement> addToCart;
	
	
	public void checkList() {

	    for (int i = 0; i < inventories.size(); i++) {
	        String itemName = inventories.get(i).getText();
	        String itemPrice = prices.get(i).getText();

	        System.out.println(itemName + " - " + itemPrice);
	    }
	}

			public int cartCount() {
				
				for (int i =0; i< addToCart.size();i++) {
					
					count++;
				}
				return count;
			}
	}
	
	

