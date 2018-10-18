package ar.com.informatorio.calidad.services;

import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;

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
        RestAssured.basePath = "/api/insumo";
        this.product = new Product(14, "Mouse", 5);

    }

    @Test(description = "exercise 1")
    public void obtainAllItemsTest(){
        expect().statusCode(200)
                .and().body("insumos[1].id", equalTo(2))
                    .when()
                        .get();
    }

    @Test(description = "exercise 1 bis")
    public void obtainAllItemsTestOp2(){
        expect()
                .statusCode(200)

                .and().body("insumos[1].id", equalTo(2))

                .and().body("insumos[1].nombre", equalTo("papel A4"))

                .and().body("insumos[1].cantidad", equalTo(5))

                    .when()

                        .get();
    }

    @Test(description = "exercise 2")
    public void obtainTheThirdItemUsingPathParamTest(){
        Response response = given()
                .pathParam("pId", "2")
                .get("/{pId}");

        JsonPath json = response.jsonPath();

        assertEquals(json.getInt("id"), 2);
        assertEquals(json.getString("nombre"), "papel A4");
        assertEquals(json.getInt("cantidad"), 5);
    }

    @Test(description = "exercise 3")
    public void addItemUsingDTOInPayloadTest(){

        given().contentType(ContentType.JSON).body(this.product)

                .when().post()

                .then().statusCode(201)

                .and().body(equalTo("{\"mensaje\":\"El insumo se ha agregado\"}"));
    }

    @Test(description = "exercise 4", priority = 2)
    public void obtainTheItemAddedWithQueryParamTest(){

        given().queryParam("id", this.product.getId())

                .when().get()

                .then().body(equalTo("{\"id\":14,\"nombre\":\"Mouse\",\"cant\":5}"));

    }

    @Test(priority = 2)
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
