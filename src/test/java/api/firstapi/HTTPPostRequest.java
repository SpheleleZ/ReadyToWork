package api.firstapi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPPostRequest {
    @Test
    public void createUser() {
       baseURI = "https://reqres.in/";

        HashMap data = new HashMap();
        data.put("name","Sphelele");
        data.put("job","Tester");

        given()
                .contentType(ContentType.JSON)
                .body(data)
                .pathParam("myPath","api")
                .pathParam("myPath1","users")
                .when()
                .post("{myPath}/{myPath1}")
                .then()
                .statusCode(201)
                .body("name",equalTo("Sphelele"))
                .log().body();
    }
}
