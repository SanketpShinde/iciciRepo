package iciciLombardPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ICICILoginPage {

	@FindBy(xpath = "//a[@id='login-revamp-click']")private WebElement signInBtn;
	@FindBy(xpath = "//input[@id='TxtEmailAddreg_lp']") private WebElement email;
	@FindBy(xpath = "//input[@id='TxtPasswordreg_lp']") private WebElement password;
	@FindBy(xpath = "//a[@id='btnloginform_lp']") private WebElement LogInBtn;
	
	public ICICILoginPage(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	
	}
	
	public void clickOnsignInbtn() {
		signInBtn.click();
	}
	public void inpEnterEmail() {
		email.sendKeys("imnotsanket@gmail.com");
	}
	public void inpPassword() {
		password.sendKeys("4@@2231Prime");
	}
	public void clickLoginBtn() {
		
		LogInBtn.click();
	}
}
