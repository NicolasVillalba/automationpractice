package ar.com.informatorio.calidad.services;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import ar.com.informatorio.calidad.domain.Product;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.expect;
import static org.testng.Assert.assertNotNull;

public class IinsumoTests {

    private Product product;

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
        RestAssured.basePath = "/api/product";
        this.product = new Product(14, "Mouse", 5);

    }

    @Test(description = "exercise 1")
    public void obtainAllItemsTest(){
        Response response = given().get();
        assertEquals(response.statusCode(), 200);
        JsonPath jsonPath = response.jsonPath();
        assertNotNull(jsonPath);
        assertEquals(jsonPath.getInt("products[1].id"), 2);
        assertEquals(jsonPath.getString("products[1].nombre"), "CPU");
        assertEquals(jsonPath.getInt("products[1].cant"), 3);
    }

    @Test(description = "exercise 1 bis")
    public void obtainAllItemsTestOp2(){
        expect()
                .statusCode(200)

                .and().body("products[1].id", equalTo(2))

                .and().body("products[1].nombre", equalTo("CPU"))

                .and().body("products[1].cant", equalTo(3))

                    .when()

                        .get();
    }

    @Test(description = "exercise 2")
    public void obtainTheThirdItemUsingPathParamTest(){
        Response response = given()
                .pathParam("pId", "3")
                .get("/{pId}");

        JsonPath json = response.jsonPath();

        assertEquals(json.getInt("id"), 3);
        assertEquals(json.getString("nombre"), "teclado");
        assertEquals(json.getInt("cant"), 20);
    }

    @Test(description = "exercise 3")
    public void addItemUsingDTOInPayloadTest(){

        given().contentType(ContentType.JSON).body(this.product)

                .when().post()

                .then().statusCode(200)

                .and().body(equalTo("{\"message\":\"El producto se ha recibido\"}"));
    }

    @Test(description = "exercise 4")
    public void obtainTheItemAddedWithQueryParamTest(){

        given().queryParam("id", this.product.getId())

                .when().get()

                .then().body(equalTo("{\"id\":14,\"nombre\":\"Mouse\",\"cant\":5}"));

    }

    @Test
    public void checkTheIdOfTheItemUsingPathParamTest(){
        expect()
                .body("id", equalTo(14))

                .when()

                .get("/14");
    }

    @Test(description = "exercise 5")
    public void deleteProductByIdTest(){

        given().pathParam("id", this.product.getId())

                .when().delete("/{id}")

                .then().statusCode(200);

    }
}
