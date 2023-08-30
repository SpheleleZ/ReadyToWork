package api.chaining.firstapproach;

import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteAUser {
    @Test
    public void deleteAUser(ITestContext context) {

        baseURI = "http://localhost:3000/";

        int id = (int) context.getSuite().getAttribute("userId");//getAttributes to get a global value

        Response response =
                given()
                        .pathParam("myPath", "friends")
                        .pathParam("id", id)
                        .when()
                        .delete("{myPath}/{id}");

        assertEquals(response.statusCode(), 200, "Status code incorrect");
    }
}
