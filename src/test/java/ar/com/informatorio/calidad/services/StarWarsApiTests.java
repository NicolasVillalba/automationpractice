package ar.com.informatorio.calidad.services;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StarWarsApiTests {
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://swapi.co";
		RestAssured.basePath = "/api/people";
	}
	
	@Test(description = "Searching character in the api")
	public void caracterSearchTest() {
		Response rp = RestAssured.get("/1");
		JsonPath jpath = rp.jsonPath();
		assertEquals(jpath.getString("name"), "Luke Skywalker");
		assertEquals(jpath.getInt("height"), 172);
	}
	
	@Test(description = "Look for a given film in the array available y the body response")
	public void filmSearchTest() {
		Response rp = RestAssured.get("/1");
		rp.prettyPrint();
		JsonPath jpath = rp.jsonPath();
		String filmUrl = jpath.getString("films[0]");
		assertNotNull(filmUrl);
		assertEquals(filmUrl, "https://swapi.co/api/films/2/");
		assertTrue(filmUrl.matches("((http|https):\\\\/\\\\/)?[-a-zA-Z0-9@:%._\\\\+~#=]{2,256}\\\\.[a-z]{2,6}\\\\b([-a-zA-Z0-9@:%_\\\\+.~#?&//=]*)((http|https):\\\\/\\\\/)?[-a-zA-Z0-9@:%._\\\\+~#=]{2,256}\\\\.[a-z]{2,6}\\\\b([-a-zA-Z0-9@:%_\\\\+.~#?&//=]*)"));
	}
}
