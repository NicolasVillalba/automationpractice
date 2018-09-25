package ar.com.informatorio.calidad.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import ar.com.informatorio.calidad.Exceptions.ReflectionConstrutorInvocationException;
import ar.com.informatorio.calidad.pages.BingResultPage;
import ar.com.informatorio.calidad.pages.BingSearchPage;
import ar.com.informatorio.calidad.pages.GoogleResultPage;
import ar.com.informatorio.calidad.pages.GoogleSearchPage;
import ar.com.informatorio.calidad.pages.WikiArticlePage;

public class SearchingCitiesTest extends BaseTest {
	
	@Test
	public void searchingResistenciaCityUsingBING() {
		driver.get("https://www.bing.com/");
		BingSearchPage searchPage = new BingSearchPage(driver);
		BingResultPage resultPage = searchPage.search("resistencia ciudad wiki");
		WikiArticlePage page = resultPage.openTirdResult(WikiArticlePage.class);
		assertEquals(page.getFirstHeadingText(), "Resistencia (ciudad)");
	}
	
	//TODO: Create another to test obtaining all elements and searching the query in
	//the link's text
	
	@Test(enabled = false)
	public void searchingResistenciaCityUsingGOOGLE() throws ReflectionConstrutorInvocationException {
		driver.get("https://www.google.com.ar/");
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Resistencia wiki");
		WikiArticlePage page = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals(page.getFirstHeadingText(), "Resistencia (ciudad)");
	}

}
