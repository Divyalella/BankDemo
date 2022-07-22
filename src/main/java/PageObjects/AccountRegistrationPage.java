package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.Base;
import Resources.DataSheet;

public class AccountRegistrationPage extends Base {
	public WebDriver driver;
	String sheetName="AccountDetails";
	int rowNum=2;
	String path=System.getProperty("user.dir")+"\\src\\main\\java\\Utilities\\MobileProject.xlsx";
	DataSheet sheet;
	public AccountRegistrationPage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		sheet=new DataSheet(path);
	}
	@FindBy(xpath="//body/div[1]/div[1]/div[3]/div[1]/div[4]/ul[1]/li[1]/a[1]")
	private WebElement MyAccountLink;
	@FindBy(xpath="//a[@title='Create an Account']")
	private WebElement CreateAccounyLink;
	@FindBy(id="firstname")
	private WebElement FirstName;
	@FindBy(id="middlename")
	private WebElement MiddleName;
	@FindBy(id="lastname")
	private WebElement LastName;
	@FindBy(id="email_address")
	private WebElement Email;
	@FindBy(id="password")
	private WebElement Password;
	@FindBy(id="confirmation")
	private WebElement ConfirmPassword;
	@FindBy(xpath="//button[@title='Register']")
	private WebElement RegisterBtn;
	@FindBy(xpath="//li[@class='success-msg']//li/span")
	private WebElement checkStaus;
	
	public void registerBtn() {
		RegisterBtn.click();
	}
	public void myAccountLink() {
		MyAccountLink.click();
	}
	public void createAccounyLink() {
		CreateAccounyLink.click();
	}
	public void firstName() {
		FirstName.sendKeys(sheet.getCellData(sheetName, "FirstName", rowNum));
	}
	public void middleName() {
		MiddleName.sendKeys(sheet.getCellData(sheetName, "MiddleName", rowNum));
	}
	public void lastName() {
		LastName.sendKeys(sheet.getCellData(sheetName, "LastName", rowNum));
	}
	public void email() {
		Email.sendKeys(sheet.getCellData(sheetName, "EmailID", rowNum));
	}
	public void password() {
		Password.sendKeys(sheet.getCellData(sheetName, "Password", rowNum));
	}
	public void ConfirmPassword() {
		ConfirmPassword.sendKeys(sheet.getCellData(sheetName, "Password", rowNum));
	}
	public WebElement checkStatus() {
		return checkStaus;
	}

}
