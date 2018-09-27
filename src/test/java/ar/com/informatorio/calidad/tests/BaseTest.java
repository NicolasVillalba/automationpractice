package ar.com.informatorio.calidad.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;

import com.google.inject.Inject;

import ar.com.informatorio.calidad.dependencies.DriverModule;

@Guice(modules = { DriverModule.class })
public class BaseTest {
	
	@Inject
	public WebDriver driver;

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
