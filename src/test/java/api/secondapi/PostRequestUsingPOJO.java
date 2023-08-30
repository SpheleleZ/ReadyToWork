package api.secondapi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 *Post request using POJO Class
 * key and Value
 */

public class PostRequestUsingPOJO {
    @Test
    public void createUsers() {
        baseURI = "http://localhost:3000/";
        String[] soccer_teams = {"Kaizer Chiefs", "Chelsea"};

        POJOClass data = new POJOClass();
        data.setFirstName("Kitso");
        data.setLastName("Mbhele");
        data.setAge(40);
        data.setJob("Security Officer");
        data.setSoccer_teams(soccer_teams);

        given()
                .contentType(ContentType.JSON)
                .body(data)
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
