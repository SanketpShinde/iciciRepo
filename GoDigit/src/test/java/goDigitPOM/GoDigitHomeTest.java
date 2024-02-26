package goDigitPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoDigitHomeTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		FileInputStream excleFile = new FileInputStream("D:\\Soft Test Tools\\Eclipse Workplace\\GoDigit\\TestData\\ddf.XLSX");
		Sheet sheet = WorkbookFactory.create(excleFile).getSheet("DDF");

		System.setProperty("webdriver.chrome.driver",
				"D:\\Soft Test Tools\\Setups\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godigit.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		GoDigitHomePage home = new GoDigitHomePage(driver);
		home.ClickonGoDigitHomePagecarInsurance();
		Thread.sleep(2000);

		String vehicleNum = sheet.getRow(0).getCell(0).getStringCellValue();
		home.inpGoDigitHomePageCarRegisterNum(vehicleNum);
		Thread.sleep(2000);
		String mobNum = sheet.getRow(0).getCell(1).getStringCellValue();
		home.inpGoDigitHomePageMobNum(mobNum);
		Thread.sleep(2000);
		home.clickOnGoDigitHomePagesubmitButton();
	}

}
