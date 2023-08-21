package api.firstapi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPDeleteRequest {

    int id;

    @Test
    public void createUser() {
        baseURI = "https://reqres.in/";

        HashMap data = new HashMap();
        data.put("name", "Thabo");
        data.put("job", "Security officer");

        id = given()
                .contentType(ContentType.JSON)
                .body(data)
                .pathParam("myPath", "api")
                .pathParam("myPath1", "users")
                .when()
                .post("{myPath}/{myPath1}")
                .jsonPath().getInt("id");
    }

    @Test(priority = 1, dependsOnMethods = "createUser")
    public void deleteUser() {

        baseURI = "https://reqres.in/";

        given()
                .pathParam("myPath", "api")
                .pathParam("myPath1", "users")
                .pathParam("myPath2", id)
                .when()
                .delete("{myPath}/{myPath1}/{myPath2}")
                .then()
                .statusCode(204)
                .log().body();
    }
}
