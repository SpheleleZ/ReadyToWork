package api.chaining.firstapproach;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateAUser {
    @Test
    public void updateAUser(ITestContext context) {
        baseURI = "http://localhost:3000/";

        int id = (int) context.getSuite().getAttribute("userId");//getAttributes to get a global value

        Faker faker = new Faker();
        String[] soccerTeams = {"Polokwane", "Brighton"};

        JSONObject data = new JSONObject();
        data.put("firstName", faker.name().firstName());
        data.put("lastName", faker.name().lastName());
        data.put("age", 30);
        data.put("job", "Teacher");
        data.put("soccer_teams", soccerTeams);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(data.toString())
                        .pathParam("myPath", "friends")
                        .pathParam("id", id)
                        .when()
                        .put("{myPath}/{id}");

        assertEquals(response.statusCode(), 200, "status code incorrect");
        assertEquals(response.jsonPath().getInt("age"), 30, "Age incorrect");
        assertEquals(response.jsonPath().get("job"), "Teacher", "Job incorrect");
        assertEquals(response.jsonPath().get("soccer_teams[0]"), "Polokwane", "soccer team incorrect");
    }
}
