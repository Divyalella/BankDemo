package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareMobilesPage {
	public WebDriver driver;
	public CompareMobilesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Mobile']")
	private WebElement MobileLink;
	@FindBy(xpath="//a[@title='Xperia']/following-sibling::*/div[3]/ul/li[2]/a")
	private WebElement XperiaCompareLink;
	@FindBy(xpath="//a[@title='IPhone']/following-sibling::*/div[3]/ul/li[2]/a")
	private WebElement IphoneCompareLink;
	@FindBy(xpath="//button[@title='Compare']//span/span")
	private WebElement CompareBtn;
	@FindBy(xpath="//button[@title='Close Window']/span/span")
	private WebElement CloseCompareWindowBtn;
	@FindBy(xpath="//h2[@class='product-name']")
	private List<WebElement> selectedProduts;

	public void mobileLink() {
		MobileLink.click();	}
	public void xperiacompareLink() {
		XperiaCompareLink.click();;
	}
	public void compareBtn() {
		CompareBtn.click();;
	}
	public void iphoneCompareLink() {
		IphoneCompareLink.click();;
	}
	public WebElement closeCompareWindowBtn() {
		return CloseCompareWindowBtn;
	}
	public List<WebElement> selectedProduts() {
		return selectedProduts;
	}

}
