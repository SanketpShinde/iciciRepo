package iciciLombardPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class ICICITest {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Soft Test Tools\\Setups\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icicilombard.com/");
		driver.manage().window().maximize();
		
		
		ICICILoginPage logIn = new ICICILoginPage(driver);
		logIn.clickOnsignInbtn();
		Thread.sleep(2000);
		logIn.inpEnterEmail();
		Thread.sleep(2000);
		logIn.inpPassword();
		logIn.clickLoginBtn();
		Thread.sleep(2000);
		
		
		
		ICICIMyProfilePage home = new ICICIMyProfilePage(driver);
		String actName=home.getMyProfileFullName();
		String expName = "Sanket p shinde";
		Thread.sleep(2000);
		
		if (actName.equals(expName)) {
			System.out.println( actName + "  Test case Passed");
		}
		else {
			System.out.println("Test case faild");
		}
		
	}
}
