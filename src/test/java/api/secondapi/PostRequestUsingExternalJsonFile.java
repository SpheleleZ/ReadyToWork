package api.secondapi;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 *Post request using External Json File
 * Data should be changed to toString before passing it
 */

public class PostRequestUsingExternalJsonFile {
    @Test
    public void createUsers() throws FileNotFoundException {
        baseURI = "http://localhost:3000/";

        File file = new File("src/test/resources/files/body.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject data = new JSONObject(jsonTokener);


        given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .pathParam("myPath", "friends")
                .when()
                .post("{myPath}")
                .then()
                .statusCode(201)
                .body("firstName", equalTo("Kitso"))
                .body("lastName", equalTo("Mbhele"))
                .body("age", equalTo(40))
                .body("job", equalTo("Security Officer"))
                .body("soccer_teams[0]", equalTo("Kaizer Chiefs"))
                .body("soccer_teams[1]", equalTo("Chelsea"))
                .log().body();
    }

    @Test(priority = 1, dependsOnMethods = "createUsers")
    public void deleteUser() {

        baseURI = "http://localhost:3000/";
        given()
                .pathParam("myPath", "friends")
                .pathParam("myPath1", "7")
                .when()
                .delete("{myPath}/{myPath1}")
                .then()
                .statusCode(200);
    }
}
