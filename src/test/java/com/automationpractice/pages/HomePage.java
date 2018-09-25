package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ar.com.informatorio.calidad.pages.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement singInAnchor;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public AuthenticationPage clickSingIn() {
		singInAnchor.click();
		return new AuthenticationPage(this.driver);
	}

}
