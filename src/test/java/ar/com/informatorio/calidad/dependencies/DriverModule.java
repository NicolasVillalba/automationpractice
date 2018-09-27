package ar.com.informatorio.calidad.dependencies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automationpractice.pages.SingInPage;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class DriverModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}
	
	@Provides
	public WebDriver getDriver() {
		ChromeDriverManager.getInstance().setup();
		return new ChromeDriver(); 
	}
	
	@Provides
	public SingInPage getSingInPageInstance(WebDriver driver) {
		return new SingInPage(driver);
	}

}
