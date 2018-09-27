package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ar.com.informatorio.calidad.pages.BasePage;

public class SingInPage extends BasePage{
	
	private WebElement email;
	
	private WebElement passwd;
	
	private WebElement SubmitLogin;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
	private WebElement customerName;
	
	public SingInPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void enterPassword(String passwd) {
		this.passwd.sendKeys(passwd);
	}
	
	public void clickSingInButton() {
		this.SubmitLogin.click();
	}
	
	public Boolean customerNameIsPresent(String name) {
		return this.customerName.getText().equals(name);
	}
}
