package api.chaining.secondapproach;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateAUser {
    @Test
    public void updateAUser(ITestContext context) {

        String bearerToken = "e8f07a7e13ee6b78650bd8352e7b6fb6d045235fea7ab7416e3ab023cfdc9201";
        baseURI = "https://gorest.co.in/";

        int id = (int) context.getSuite().getAttribute("userId");

        Faker faker = new Faker(); // to create random fake data
        JSONObject data = new JSONObject();

        data.put("name", faker.name().fullName());
        data.put("gender", "female");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "inactive");

        Response response =
                given()
                        .headers("Authorization", "Bearer "+bearerToken)
                        .contentType(ContentType.JSON) //Content type
                        .body(data.toString())  //Body data for Post
                        .pathParam("myPath", "public/v2/users") //path param
                        .pathParam("id", id)
                        .when()
                        .put("{myPath}/{id}");

        System.out.println(response.getBody());

        assertEquals(response.statusCode(), 200, "Status code incorrect");
        assertEquals(response.jsonPath().get("gender"), "female", "Gender is  incorrect");
        assertEquals(response.jsonPath().get("status"), "inactive", "status is incorrect");
    }
}
