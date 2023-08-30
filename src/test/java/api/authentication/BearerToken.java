package api.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * Bearer Token Authentication we use Headers key word then pass Bearer Token
 */
public class BearerToken {

    /*
     * With Bearer Token we pass Authorization and Bearer Token in Headers under Given
     * we use Given.headers()
     */
    @Test
    public void testBearerToken(){
          String token = "github_pat_11AHGVDBQ0brhFvDodTQRQ_6cAH42X5fLqbKKyHGK53prM1OxUmbYC1  dcifl4lwUy3CT5M2HMPYTft4DcR";

          given()
                  .headers("Authorization","Bearer " + token)
                  .when()
                  .get("https://github.com/SpheleleZ/ReadyToWork")
                  .then()
                  .statusCode(200)
                  .log().body();
    }
}
