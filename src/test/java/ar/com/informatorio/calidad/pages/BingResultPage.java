package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingResultPage extends BasePage {
	
	@FindBy(xpath = "//*[@id=\"b_results\"]/li[1]/h2/a")
	private WebElement firstResult;
	
	//TODO: get all anchors in the page then search for its texts

	public BingResultPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * for opening a new page 
	 * @param returnPage any class that receives as argument
	 * @return an instance of the new page Object created with Page factory
	 */
	public <T> T openTirdResult(Class<T> returnPage) {
		firstResult.click();
		return PageFactory.initElements(this.driver, returnPage);
	}

}