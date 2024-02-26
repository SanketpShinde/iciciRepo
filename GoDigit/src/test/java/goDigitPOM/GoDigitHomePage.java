package goDigitPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoDigitHomePage {

	@FindBy(xpath = "(//div[@class='qf-switcher-img-holder'])[1]") private WebElement carInsurance;
	@FindBy (xpath = "(//input[@name='registration-search'])[1]") private WebElement CarRegisterNum;
	@FindBy (xpath = "//input[@id='car-mobile-number']") private WebElement mobNum;
	@FindBy(xpath = "(//button[@type='submit'])[1]") private WebElement submitButton;
	
	WebDriver driver1;
	public GoDigitHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver1 = driver;
	}
	
	public void ClickonGoDigitHomePagecarInsurance() {
		carInsurance.click();
	}

	public void inpGoDigitHomePageCarRegisterNum(String carRegNum) {
	CarRegisterNum.sendKeys(carRegNum);
	}
	
	public void inpGoDigitHomePageMobNum(String mobileNum) {
		mobNum.sendKeys(mobileNum);
	}
	public void clickOnGoDigitHomePagesubmitButton() {
		submitButton.click();
	}
}
