package com.automationpractice.pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ar.com.informatorio.calidad.Exceptions.ReflectionConstrutorInvocationException;
import ar.com.informatorio.calidad.pages.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement singInAnchor;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * click in the sing in anchor and return the next PO
	 * @param returnPage
	 * @return
	 * @throws ReflectionConstrutorInvocationException
	 */
	public <T extends BasePage> T clickSingIn(Class<T> returnPage) throws ReflectionConstrutorInvocationException {
		singInAnchor.click();
		try {
			return returnPage.getConstructor(WebDriver.class).newInstance(this.driver);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new ReflectionConstrutorInvocationException("The strategy for Object Construction might fail");
		}
	}

}
