package iciciLombard_POM_TestNG_DDF_BaseClass_UtilityClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ICICIMyProfilePage {

	@FindBy(xpath = "//h3[text()='Sanket p shinde']")
	private WebElement profileName;
	@FindBy(xpath = "//img[@class='lazy']")
	private WebElement iciciLogo;

	public ICICIMyProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getMyProfileFullName() {

		String actText = profileName.getText();
		return actText;
	}

	public void clickOnIciciLogo() {
		iciciLogo.click();
	}

}
