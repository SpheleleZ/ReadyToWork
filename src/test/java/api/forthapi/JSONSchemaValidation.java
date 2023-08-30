package api.forthapi;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONSchemaValidation {
     @Test
    public void jsonSchemaValidation(){

         baseURI = "http://localhost:3000/";

         given()
                 .pathParam("myPath","friends")
                 .when()
                 .get("{myPath}")
                 .then()
                 .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("files/jsonSchemaData.json"));
     }
}
