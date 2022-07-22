package TestCase;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.CompareMobilesPage;
import Resources.Base;

public class CompareMobileTest extends Base{
public WebDriver driver;
	
	Logger log=LogManager.getLogger(CompareMobileTest.class.getName());
	@BeforeMethod
	public void openPage() throws IOException {
		driver=launchBrowser();
		
	}
	@Test
	public void compare() throws IOException {
		CompareMobilesPage comparemobile=new CompareMobilesPage(driver);
		comparemobile.mobileLink();
		comparemobile.iphoneCompareLink();
		comparemobile.xperiacompareLink();
		log.debug("Iphone and Sony Xperia added to compare");
		comparemobile.compareBtn();
		log.debug("compare button clicked");
		Set<String> winID = driver.getWindowHandles();
		Iterator<String> window=winID.iterator();
		while(window.hasNext()) {
			String win = window.next();
			driver.switchTo().window(win);
			log.debug("switched to compare page");
			System.out.println(driver.getTitle());
			if(!driver.getTitle().equals("Mobile")) {
				log.info("compare page opened");
				//getScreenshot("compare",driver);
				List<WebElement> products = comparemobile.selectedProduts();
				for(int i=0;i<products.size();i++) {
					System.out.println(products.get(i).getText());
				}
				comparemobile.closeCompareWindowBtn().click();
				log.debug("closed the compare page");
			}

		}
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
