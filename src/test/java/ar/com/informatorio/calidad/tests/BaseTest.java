package ar.com.informatorio.calidad.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BaseTest {
	
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}
	

	@AfterClass
	public void teardown() {
		//driver.quit();
	}
}
