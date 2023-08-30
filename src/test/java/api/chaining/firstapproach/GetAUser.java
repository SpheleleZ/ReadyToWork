package api.chaining.firstapproach;

import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAUser {
    @Test
    public void getAUser(ITestContext context) {

        baseURI = "http://localhost:3000/";

        int id = (int) context.getSuite().getAttribute("userId");//getAttributes to get a global value

        Response response =
                given()
                        .pathParam("myPath", "friends")
                        .pathParam("id", id)
                        .when()
                        .get("{myPath}/{id}");

        assertEquals(response.statusCode(), 200, "status code incorrect");
        assertEquals(response.jsonPath().getInt("age"), 55, "age incorrect");
        assertEquals(response.jsonPath().get("job"), "QA", "Job incorrect");
    }
}
