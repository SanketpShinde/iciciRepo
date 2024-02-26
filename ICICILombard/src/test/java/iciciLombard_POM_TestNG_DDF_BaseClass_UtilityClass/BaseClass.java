package iciciLombard_POM_TestNG_DDF_BaseClass_UtilityClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	WebDriver driver;

	public void initalizeBrowser() throws IOException {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notification");
		
		
		driver = new ChromeDriver(ops);
		driver.get(UtilityClass.getPropertyFileData("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
