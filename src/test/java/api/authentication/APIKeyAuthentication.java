package api.authentication;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * APIKey Authentication we use queryParam or Headers depends on
 * given.queryParam("key","value")
 */

public class APIKeyAuthentication {
    /*
     * Request Tokens
     * With APIKey we pass ("appid","token")
     * we use Given.queryPath
     */

    @Test
    public void OAuth1Authentication(){
        given()
                .queryParam("appid","Token")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }
}
