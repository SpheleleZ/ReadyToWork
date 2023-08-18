package api.firstapi;

/*
 * given()
 * Content type,Add Auth,Add Param, Set Headers info etc.........
 *
 * when()
 * get,post,put,delete .......
 *
 * then()
 * validate status code,extract response, extract headers ,cookies and response body .......
 */

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class HTTPGetRequest {
    @Test
    public void getUser() {
        baseURI = "https://reqres.in/";

        given()
                .pathParam("myPath", "api")
                .pathParam("myPath1", "users")
                .pathParam("myPath2", "2")
                .when()
                .get("{myPath}/{myPath1}/{myPath2}")
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .log().body();
    }

    /*
     * Validate using Response from RestAssured
     */

    @Test
    public void getUserResponseOption() {
        baseURI = "https://reqres.in/";

        Response response =
                given()
                        .pathParam("myPath", "api")
                        .pathParam("myPath1", "users")
                        .pathParam("myPath2", "2")
                        .when()
                        .get("{myPath}/{myPath1}/{myPath2}");

        assertEquals(response.statusCode(), 200, "status code not equal");
        assertEquals(response.jsonPath().get("data.first_name"), "Janet", "first name  is not Janet");
    }


    @Test
    public void getAllUsers() {
        baseURI = "https://reqres.in/";

        given()
                .pathParam("myPath", "api")
                .pathParam("myPath1", "users")
                .queryParam("page", "2")
                .when()
                .get("{myPath}/{myPath1}")
                .then()
                .statusCode(200)
                .body("data[2].last_name", equalTo("Funke"))
                .log().body();

    }

    /*
     * Validate using Response from RestAssured
     */
    @Test
    public void getAllUsersResponseOption() {
        baseURI = "https://reqres.in/";

        Response response =
                given()
                        .pathParam("myPath", "api")
                        .pathParam("myPath1", "users")
                        .queryParam("page", "2")
                        .when()
                        .get("{myPath}/{myPath1}");

        assertEquals(response.statusCode(), 200, "Status code not equal");
        assertEquals(response.jsonPath().get("data[2].last_name"), "Funke", "last name not Funke");
    }
}
