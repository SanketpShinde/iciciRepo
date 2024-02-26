package ss;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.utility.RandomString;

public class ScreenShotWithRandomString {

	static WebDriver driver;
	public static void screenShot() throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
		String RS = RandomString.make(2);
		
		File des = new File("C:\\Users\\SANKET\\Desktop\\SS\\abc"+RS+".jpg");
		
		org.openqa.selenium.io.FileHandler.copy(src, des);

	}
}
