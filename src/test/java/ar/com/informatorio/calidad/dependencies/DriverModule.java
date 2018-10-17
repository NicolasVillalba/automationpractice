package ar.com.informatorio.calidad.dependencies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automationpractice.pages.SingInPage;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class DriverModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}
	
	@Provides
	@Singleton
	@Named("Chrome")
	public WebDriver getChomeDriver() {
		ChromeDriverManager.getInstance().setup();
		return new ChromeDriver(); 
	}
	
	@Provides
	@Singleton
	@Named("FireFox")
	public WebDriver getFirefoxDriver() {
		FirefoxDriverManager.getInstance().setup();
		return new FirefoxDriver(); 
	}
	
	@Provides
	public SingInPage getSingInPageInstance(WebDriver driver) {
		return new SingInPage(driver);
	}

}
