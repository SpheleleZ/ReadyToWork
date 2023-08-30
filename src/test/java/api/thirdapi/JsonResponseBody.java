package api.thirdapi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/*
 *verify Json response body
 */
public class JsonResponseBody {

    @Test
    public void testJsonBody(){
        baseURI =  "http://localhost:3000/";

        Response response =
                given()
                        .pathParam("myPath","friends")
                        .contentType(ContentType.JSON)
                        .when()
                        .get("{myPath}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.jsonPath().get("[4].soccer_teams[0]"),"Liverpool");
    }
}
