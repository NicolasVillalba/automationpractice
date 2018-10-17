package ar.com.informatorio.calidad.services;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class RegularExpressionForSWAPITests {
	
	@Test(description = "Regex taken from https://www.regextester.com/96146")
	public void UrlSchemeRegexTest1() {
		assertTrue("https://swapi.co/".matches("((http|https):\\/\\/)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)"));
	}
	
	@Test(description = "Regex taken from https://www.regextester.com/96146")
	public void UrlSchemeRegexTest2() {
		assertTrue("https://swapi.co/api/people/1/".matches("((http|https):\\/\\/)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)"));
	}
	
	@Test(description = "Regex taken from https://www.regextester.com/96146")
	public void UrlSchemeRegexTest3() {
		assertTrue("https://swapi.co/api/films/2/".matches("((http|https):\\/\\/)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)"));
	}
}
