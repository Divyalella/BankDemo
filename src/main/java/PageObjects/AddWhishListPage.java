package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.Base;
import Resources.DataSheet;

public class AddWhishListPage extends Base{
	public WebDriver driver;
	String sheetName="AccountDetails";
	int rowNum=2;
	String path=System.getProperty("user.dir")+"\\src\\main\\java\\Utilities\\MobileProject.xlsx";
	DataSheet sheet;
	public AddWhishListPage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		sheet=new DataSheet(path);
	}
	
	@FindBy(xpath="//a[text()='TV']")
	private WebElement TVlink;
	@FindBy(xpath="//a[text()='LG LCD']/following::*/div[3]/ul/li/a[text()='Add to Wishlist']")
	private WebElement AddWhishList;
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	@FindBy(xpath="//input[@id='pass']")
	private WebElement Password;
	@FindBy(xpath="//button[@title='Login']")
	private WebElement LoginBtn;
	
	public void tVlink() {
		TVlink.click();
	}
	public void addWhishList() {
		AddWhishList.click();
	}
	public void email() {
		email.sendKeys(sheet.getCellData(sheetName, "EmailID", rowNum));
	}
	public void password() {
		Password.sendKeys(sheet.getCellData(sheetName, "Password", rowNum));
	}
	public void loginBtn() {
		LoginBtn.click();
	}

}
