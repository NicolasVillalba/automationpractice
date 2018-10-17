package ar.com.informatorio.calidad.services;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredTests {

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "http://192.168.42.120";
		RestAssured.port = 3000;
		RestAssured.basePath = "/api/product";
	}

	@Test
	public void getAll() {
		Response rp = RestAssured.get();
		rp.prettyPrint();
		assertEquals(rp.getStatusCode(), 200);
		JsonPath jp = rp.jsonPath();
		List<Object> products = jp.getList("products");
		assertFalse(products.isEmpty());
	}

	@Test(description = "Get request by id")
	public void getId() {
		Response rp = RestAssured.get("/1");
		rp.prettyPrint();
		assertEquals(rp.getStatusCode(), 200);
		JsonPath jp = rp.jsonPath();
		assertEquals(jp.getInt("id"), 1);
	}

	@Test(description = "Get request by id with pahtParam scheme")
	public void getByIdUsingPathParam() {
		Response rp = RestAssured.given().pathParam("productId", "1").get("/{productId}");
		rp.prettyPrint();
		assertEquals(rp.getStatusCode(), 200);
		JsonPath jp = rp.jsonPath();
		assertEquals(jp.getInt("id"), 1);
		assertEquals(jp.getString("nombre"), "monitor");
		assertEquals(jp.getInt("cantidad"), 12);
	}

	@Test(description = "Get request by id with queryParam scheme")
	public void getByIdUsingQueryParam() {
		Response rp = RestAssured.given().log().all().queryParam("productId", "1").get();
		rp.prettyPrint();
		assertEquals(rp.getStatusCode(), 200);
		JsonPath jp = rp.jsonPath();
		assertEquals(jp.getInt("id"), 1);
		assertEquals(jp.getString("nombre"), "monitor");
		assertEquals(jp.getInt("cantidad"), 12);
	}

	class Product {
		Integer id;
		String nombre;
		Integer cantidad;

		public Product() {
			// TODO Auto-generated constructor stub
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}
	}
}
