package api.secondapi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 *Post request using HashMap
 * key and Value
 */

public class PostRequestUsingHashMap {

    @Test
    public void createUsers() {
        baseURI = "http://localhost:3000/";

        String[] soccerTeams = {"Kaizer Chiefs", "Chelsea"};

        HashMap data = new HashMap();
        data.put("firstName", "Kitso");
        data.put("lastName", "Mbhele");
        data.put("age", 40);
        data.put("job", "Security Officer");
        data.put("soccer_teams", soccerTeams);

        given()
                .contentType(ContentType.JSON)
                .body(data)
                .pathParam("myPath", "users")
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
                .pathParam("myPath", "users")
                .pathParam("myPath1", "11")
                .when()
                .delete("{myPath}/{myPath1}")
                .then()
                .statusCode(200);
    }
}
