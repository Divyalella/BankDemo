package TestCase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import PageObjects.MobilePage;
import Resources.Base;

public class TCMobileTest extends Base {
	public WebDriver driver;
	MobilePage MobileData;
	List<WebElement> products;
	Logger log=LogManager.getLogger(TCMobileTest.class.getName());
	Select SortBy;
 
	@BeforeMethod
  public void MobileData() throws IOException {
		driver=launchBrowser();
	MobileData=new MobilePage(driver);
		if(driver.getTitle().equals("Home page")) {
			
			log.info("Homepage opened");
			MobileData.mobileLink().click();
			if(driver.getTitle().equals("Mobile")) {
				log.info("Mobile page opened");
				SortBy=new Select(MobileData.sortBYDropdown());
				SortBy.selectByVisibleText("Name");
				products = MobileData.Products();
			}
		}
		else {
			Assert.assertTrue(false);}
		
  }
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
 
  public void checksortedproducts(List<WebElement> products) {
	  ArrayList<String> product=new ArrayList<String>();
		 product.add(products.get(0).getText());
		 product.add(products.get(1).getText());
		 product.add(products.get(2).getText());
		 List<String> pro=new ArrayList<String>(product);
		 Collections.sort(pro);
		 if(pro.equals(products)) {
			 log.info("products are sorted By Name");
		 }else { log.error("products are not sorted as per name");}
  }
 
  public void checkPrice(List<WebElement> products) throws IOException {
	  for(int i=0;i<products.size();i++) {
			 String mobile=products.get(i).getText();
			 if(mobile.equals("SONY XPERIA")) {
				 log.debug("product matches with sonyExperia");
				 String price=MobileData.sonyExperiaPrice().getText();
					prop.setProperty("Price",price);
					FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
					prop.store(fos, price);
					log.debug("price entered in data file");
					MobileData.sonyexperiaLink().click();
					log.debug("sonyexperia link clicked");
					if(prop.getProperty("Price").equals(MobileData.experiaPrice().getText())) {
						System.out.println(prop.getProperty("Price"));
						log.info("both prices are equal");
					}
					else {
						log.error("prices not equal");
					}
			 }
			 else {
				log.error("product not matched"); 
			 }
		 }
	    }
 @Test(enabled=false)
  public void quantity(List<WebElement> products) {
	  MobileData.addToCartBtn().click();
	  MobileData.quantity().click();
	  MobileData.quantity().sendKeys("1000");
	  MobileData.updateQuantityBtn().click();
	  if(MobileData.errormessage().getText().equals("* The maximum quantity allowed for purchase is 500.")) {
	  MobileData.emptyCart().click();
	  if(MobileData.cartCount().getText().equals("")) {
		  log.info("Cart is empty");
		  System.out.println("cart is empty");
	  }
	  else {
		  log.error("cart is not empty");
	  System.out.println("cart has no items");
	  }
	  }
	  else 
		  System.out.println(MobileData.errormessage().getText());
  }

}
