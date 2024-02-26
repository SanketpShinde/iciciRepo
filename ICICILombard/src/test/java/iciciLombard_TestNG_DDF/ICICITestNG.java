package iciciLombard_TestNG_DDF;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICICITestNG {

	// declare Globally Variables and Objects

	WebDriver driver;
	ICICILoginPage logIn;
	ICICIMyProfilePage profile;
	Sheet mySheet;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(
				"D:\\Soft Test Tools\\Eclipse Workplace\\ICICILombard\\TestData\\ddf.XLSX");
		mySheet = WorkbookFactory.create(file).getSheet("ddf");

		System.setProperty("webdriver.chrome.driver",
				"D:\\Soft Test Tools\\Setups\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.icicilombard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Initalization

		logIn = new ICICILoginPage(driver);
		profile = new ICICIMyProfilePage(driver);
	}

	@AfterClass
	public void closeBrowser() {

		// driver.close();
	}

	@BeforeMethod
	public void logInOnApp() throws InterruptedException {

		Thread.sleep(2000);
		logIn.clickOnsignInbtn();
		Thread.sleep(2000);
		logIn.inpEnterEmail(mySheet.getRow(0).getCell(0).getStringCellValue());
		Thread.sleep(2000);
		logIn.inpPassword(mySheet.getRow(0).getCell(1).getStringCellValue());
		Thread.sleep(2000);
		logIn.clickLoginBtn();
	}

	@AfterMethod
	public void logOutFromApp() {

	}

	@Test
	public void VerifyProfileName() {

		String actName = profile.getMyProfileFullName();
		String expName = (mySheet.getRow(0).getCell(2).getStringCellValue());

		Assert.assertEquals(actName, expName, "Failed: Result is not matching");
	}

	public void ClickOnLogo() {
		profile.clickOnIciciLogo();
	}

}