package api.firstapi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPPutRequest {

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
    public void updateUser() {
        baseURI = "https://reqres.in/";

        HashMap data = new HashMap();
        data.put("name", "Themba");
        data.put("job", "Electrician Engineer");

        given()
                .contentType(ContentType.JSON)
                .body(data)
                .pathParam("myPath", "api")
                .pathParam("myPath1", "users")
                .pathParam("myPath2", id)
                .when()
                .put("{myPath}/{myPath1}/{myPath2}")
                .then()
                .statusCode(200)
                .body("name", equalTo("Themba"))
                .log().body();
    }
}
