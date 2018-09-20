package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;

public class BingSearchPage extends BasePage {
	
	//@FindBy(xpath = "//*[@id='sb_form_q']")
	private WebElement sb_form_q;

	//@FindBy(xpath = "//*[@id='sb_form_go']")
	private WebElement sb_form_go;
	
	public BingSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public BingResultPage search(String query) {
		sb_form_q.clear();
		sb_form_q.sendKeys(query);
		sb_form_q.sendKeys(Keys.TAB);
		sb_form_go.click();
		return new BingResultPage(this.driver);
	}

}