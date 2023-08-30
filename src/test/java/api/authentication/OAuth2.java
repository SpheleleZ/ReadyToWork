package api.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/*
 * OAuth2 Authentication we use Auth.oauth2()
 * given.auth().oauth2("accessToken)
 */

public class OAuth2 {

    /*
     * Request Tokens
     * With OAuth2 we pass ("accessToken")
     * we use Given.auth.oauth2()
     */

    @Test
    public void OAuth1Authentication(){
        given()
                .auth().oauth2("accessToken")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }
}

