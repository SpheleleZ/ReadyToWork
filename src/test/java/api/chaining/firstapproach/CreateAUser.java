package api.chaining.firstapproach;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Chaining Post,Get,Update and delete
 * Running using XMl file
 */
public class CreateAUser {

    @Test
    public void createAUser(ITestContext context) {
        baseURI = "http://localhost:3000/";

        Faker faker = new Faker();
        String[] soccerTeams = {"Sundowns", "Brighton"};

        JSONObject data = new JSONObject();  //creating Data using JSONObject
        data.put("firstName", faker.name().firstName());
        data.put("lastName", faker.name().lastName());
        data.put("age", 55);
        data.put("job", "QA");
        data.put("soccer_teams", soccerTeams);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(data.toString())
                        .pathParam("myPath", "friends")
                        .when()
                        .post("{myPath}");

        int id = response.jsonPath().getInt("id"); //Get id from response body
        context.getSuite().setAttribute("userId", id); //SetAttributes Making id value global to be accessible to another test

        assertEquals(response.statusCode(), 201, "status code incorrect"); //Validations
        assertEquals(response.jsonPath().getInt("age"), 55, "Age incorrect");
        assertEquals(response.jsonPath().get("job"), "QA", "Job incorrect");
    }
}
