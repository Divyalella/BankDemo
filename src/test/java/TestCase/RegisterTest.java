package TestCase;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.AddWhishListPage;
import Resources.Base;

public class RegisterTest extends Base{
	public WebDriver driver;
	AccountRegistrationPage register;
	AddWhishListPage wishlist;

	@BeforeMethod
	public void launch() throws IOException {
		driver=launchBrowser();
		register=new AccountRegistrationPage(driver);
		wishlist=new AddWhishListPage(driver);
		register.myAccountLink();
		wishlist.email();
		wishlist.password();
		wishlist.loginBtn();
	}
	@Test(enabled=false)
	 public void register() throws IOException {
		
		
		 register.myAccountLink();
		 register.createAccounyLink();
		 register.firstName();
		 register.middleName();
		 register.lastName();
		 register.email();
		 register.password();
		 register.ConfirmPassword();
		 register.registerBtn();
		 Assert.assertEquals(register.checkStatus().getText(),"Thank you for registering with Main Website Store.");
	 }
	@Test
	public void addToWishList() throws IOException {
		wishlist.tVlink();
		wishlist.addWhishList();
		
	}
	@AfterMethod
	public void teraDown() {
		driver.quit();
	}

}
