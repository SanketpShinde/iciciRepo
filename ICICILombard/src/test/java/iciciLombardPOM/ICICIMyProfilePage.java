package iciciLombardPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ICICIMyProfilePage {

	

	@FindBy(xpath = "//h3[text()='Sanket p shinde']") private WebElement profileName;


	public ICICIMyProfilePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	
	public String getMyProfileFullName() {
		
		
		String actText = profileName.getText();
		return actText; 
	}
	









}

