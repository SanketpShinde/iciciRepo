package iciciLombard_POM_TestNG_DDF_BaseClass_UtilityClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICICITestNG extends BaseClass {

	// declare Globally Variables and Objects

	ICICILoginPage logIn;
	ICICIMyProfilePage profile;
	int TCID;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Soft Test Tools\\Setups\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Initalization
		initalizeBrowser(); // Base Class Method

		// object creation for calling other class methods
		logIn = new ICICILoginPage(driver);
		profile = new ICICIMyProfilePage(driver);
	}

	@AfterClass
	public void closeBrowser() {

		// driver.close();
	}

	@BeforeMethod
	public void logInOnApp() throws InterruptedException, EncryptedDocumentException, IOException {

		Thread.sleep(2000);
		logIn.clickOnsignInbtn();
		Thread.sleep(2000);
		logIn.inpEnterEmail(UtilityClass.getPropertyFileData("UN"));
		Thread.sleep(2000);
		logIn.inpPassword(UtilityClass.getPropertyFileData("PWD"));
		Thread.sleep(2000);
		logIn.clickLoginBtn();
	}

	@AfterMethod
	public void logOutFromApp() {

	}

	public void failedTestCasesScreenshot(ITestResult s1) throws IOException {
		if (s1.getStatus() == ITestResult.FAILURE) { // Comparing status of test cases with itestFailure if fail it will
														// go inside

			UtilityClass.captureScreenShotOfFailedTC(driver, TCID);

		}

	}

	@Test
	public void VerifyProfileName() throws EncryptedDocumentException, IOException {
		TCID = 102;
		String actName = profile.getMyProfileFullName();
		String expName = (UtilityClass.testData(0, 2));

		Assert.assertEquals(actName, expName, "Failed: Result is not matching");

		// Assert.fail();
	}

	public void ClickOnLogo() {
		profile.clickOnIciciLogo();
	}

}