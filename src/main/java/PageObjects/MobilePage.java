package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.Base;

public class MobilePage extends Base {
	
	public WebDriver driver;
	public MobilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Mobile']")
	private WebElement MobileLink;
	@FindBy(xpath="//div[@class='sort-by']/select")
	private WebElement SortByDropDown;
	@FindBy(xpath="//h2[@class='product-name']/a")
	private List<WebElement> Products;
	@FindBy(xpath="//div[@class='price-box']/span[1]/span[text()='$100.00']")
	private WebElement SonyExperiaPrice;
	@FindBy(xpath="//a[text()='Sony Xperia']")
	private WebElement SonyexperiaLink;
	@FindBy(xpath="//span[@class='price']")
	private WebElement ExperiaPrice;
	@FindBy(xpath="//li[@class='item last']/a[@title='Xperia']/following::*/div[3]/button[@class='button btn-cart']/span[1]/span[1]")
	private WebElement AddtoCartBtn;
	@FindBy(xpath="//input[@class='input-text qty']")
	private WebElement Quantity;
	@FindBy(xpath="//button[@class='button btn-update']/span/span")
	private WebElement UpadateQuantityBtn;
	@FindBy(xpath="//button[@class='button2 btn-empty']/span/span")
	private WebElement EmptyCart;
	@FindBy(xpath="//p[contains(@class,'item-msg error')]")
	private WebElement Errormessage;
	@FindBy(xpath="//a[contains(@class,'skip-cart')]/span[@class='count']")
	private WebElement CartCount;
	
	public WebElement mobileLink() {
		return MobileLink;
	}
	public WebElement sortBYDropdown() {
		return SortByDropDown;
	}
	public List<WebElement> Products(){
		return Products;
	}
	public WebElement sonyExperiaPrice() {
		return SonyExperiaPrice;
	}
	public WebElement sonyexperiaLink() {
		return SonyexperiaLink;
	}
	public WebElement experiaPrice() {
		return ExperiaPrice;
	}
	public WebElement addToCartBtn() {
		return AddtoCartBtn;
	}
	public WebElement quantity() {
		return Quantity;
	}
	public WebElement updateQuantityBtn() {
		return UpadateQuantityBtn;
	}
	public WebElement emptyCart() {
		return EmptyCart;
	}
	public WebElement errormessage() {
		return Errormessage;
	}
	public WebElement cartCount() {
		return CartCount;
	}

}
