package api.authentication;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/*
 * OAuth1 Authentication we use Auth.oauth()
 * given.auth().oauth()
 */

public class OAuth1 {

    /*
     * Request Tokens
     * With OAuth1 we pass ("consumerKey","consumerSecret","accessToken","tokenSecret")
     * we use Given.headers()
     */

    @Test
    public void OAuth1Authentication(){
        given()
                .auth().oauth("consumerKey","consumerSecret","accessToken","tokenSecret") //We receive all these from Dev
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }
}
