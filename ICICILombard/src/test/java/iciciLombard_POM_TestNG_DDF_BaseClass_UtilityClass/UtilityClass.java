package iciciLombard_POM_TestNG_DDF_BaseClass_UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class UtilityClass {

	static WebDriver driver;

	public static String testData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//TestData//ddf.XLSX");
		Sheet mySheet = WorkbookFactory.create(file).getSheet("ddf");
		String value = mySheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	//ScreenShot Method with TCID For failed test Cases
	public static void captureScreenShotOfFailedTC(WebDriver driver, int TCID) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//FailedTC ScreenShots"+TCID+".png");
		FileHandler.copy(src, dest);

	}
	public static String getPropertyFileData(String key) throws IOException   {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//PropertFileInputs.properties"); //for project file path 
		Properties p = new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		return value;
		
	
	
			
	}
	
	
	
}
