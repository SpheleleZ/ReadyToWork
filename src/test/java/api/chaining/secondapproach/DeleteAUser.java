package api.chaining.secondapproach;

import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class DeleteAUser {

    @Test
    public void deleteAUser(ITestContext context) {

        String bearerToken = "e8f07a7e13ee6b78650bd8352e7b6fb6d045235fea7ab7416e3ab023cfdc9201";
        baseURI = "https://gorest.co.in/";
        int id = (int) context.getSuite().getAttribute("userId");

        Response response =
                given()
                        .headers("Authorization", "Bearer "+bearerToken)
                        .pathParam("myPath", "public/v2/users")
                        .pathParam("id", id)
                        .when()
                        .delete("{myPath}/{id}");

        System.out.println(response.getBody());
        assertEquals(response.statusCode(), 204, "Status code incorrect");
    }
}
