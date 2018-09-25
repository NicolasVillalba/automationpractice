package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ar.com.informatorio.calidad.pages.BasePage;

public class AuthenticationPage extends BasePage {

	private WebElement email_create;
	
	private WebElement SubmitCreate;
	
	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}
	
	public CreateAnAccountPage insertEmailAndPress(String email) {
			email_create.sendKeys(email);
			SubmitCreate.click();
			return new CreateAnAccountPage(this.driver);
	}

}
