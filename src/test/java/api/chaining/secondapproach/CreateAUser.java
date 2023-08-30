package api.chaining.secondapproach;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class CreateAUser {
    @Test
    public void createUser(ITestContext context) {

        String bearerToken = "e8f07a7e13ee6b78650bd8352e7b6fb6d045235fea7ab7416e3ab023cfdc9201";
        baseURI = "https://gorest.co.in/";

        Faker faker = new Faker(); // to create random fake data
        JSONObject data = new JSONObject();

        data.put("name", faker.name().fullName());
        data.put("gender", "female");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "active");

        Response response =
                given()
                        .headers("Authorization", "Bearer "+bearerToken)
                        .contentType(ContentType.JSON) //Content type
                        .body(data.toString())  //Body data for Post
                        .pathParam("myPath", "public/v2/users") //path param
                        .when()
                        .post("{myPath}");

        int id = response.jsonPath().getInt("id");
        context.getSuite().setAttribute("UserId", id);
        System.out.println(response.getBody());

        assertEquals(response.statusCode(), 200, "Status code incorrect");
        assertEquals(response.jsonPath().get("gender"), "female", "Gender is  incorrect");
        assertEquals(response.jsonPath().get("status"), "active", "status is incorrect");
    }
}
