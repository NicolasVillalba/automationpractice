package ar.com.informatorio.calidad.pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ar.com.informatorio.calidad.Exceptions.ReflectionConstrutorInvocationException;

public class GoogleResultPage extends BasePage{

	@FindBy(xpath = "(//*[@class='g']/descendant::a)[1]")
	private WebElement firstResultLink;
	
	public GoogleResultPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * for opening a new page 
	 * @param returnPage any class that receives as argument
	 * @return an instance of the new page Object created with Page factory
	 * @throws Exception 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public <T extends BasePage> T openFirstResult(Class<T> returnPage) throws ReflectionConstrutorInvocationException {
		firstResultLink.click();
		try {
			return returnPage.getConstructor(WebDriver.class).newInstance(this.driver);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new ReflectionConstrutorInvocationException("The strategy for Object Construction might fail");
		}
	}
}