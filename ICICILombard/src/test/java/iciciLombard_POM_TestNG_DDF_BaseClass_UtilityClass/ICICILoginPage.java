package iciciLombard_POM_TestNG_DDF_BaseClass_UtilityClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ICICILoginPage {

	@FindBy(xpath = "//a[@class='login-link']")private WebElement signInBtn;
	@FindBy(xpath = "//input[@id='TxtEmailAddreg_lp']") private WebElement email;
	@FindBy(xpath = "//input[@id='TxtPasswordreg_lp']") private WebElement password;
	@FindBy(xpath = "//a[@id='btnloginform_lp']") private WebElement LogInBtn;
	
	public ICICILoginPage(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	
	}
	
	public void clickOnsignInbtn() {
		signInBtn.click();
	}
	public void inpEnterEmail(String emailID) {
		email.sendKeys(emailID);
	}
	public void inpPassword(String exPassword) {
		password.sendKeys(exPassword);
	}
	public void clickLoginBtn() {
		
		LogInBtn.click();
	}
}
