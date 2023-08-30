package api.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * These Authentications are almost the same Basic ,Digest and preemptive
 */
public class Authentications {

    /*
     * Basic Authentication we only need to pass Username and Password
     * we use Given.auth().basic
     */
    @Test
    public void basicAuthentication(){

        baseURI = "https://postman-echo.com/";

        given()
                .auth().basic("Sphelele","Nok2lasphe")
                .pathParam("myPath","basic-auth")
                .when()
                .get("{myPath}")
                .then()
                .statusCode(200);
    }

    /*
     * Digest Authentication we only need to pass Username and Password
     * we use Given.auth().digest()
     */
    @Test
    public void digestAuthentication(){
        baseURI = "https://postman-echo.com/";

        given()
                .auth().digest("Sphelele","Nok2lasphe")
                .pathParam("myPath","basic-auth")
                .when()
                .get("{myPath}")
                .then()
                .statusCode(200);
    }

    /*
     * Preemptive Authentication we only need to pass Username and Password, and it also uses Basic
     * we use Given.auth().preemptive().basic
     */
    @Test
    public void preemptiveAuthentication(){
        baseURI = "https://postman-echo.com/";

        given()
                .auth().preemptive().basic("Sphelele","Nok2lasphe")
                .pathParam("myPath","basic-auth")
                .when()
                .get("{myPath}")
                .then()
                .statusCode(200);
    }
}

