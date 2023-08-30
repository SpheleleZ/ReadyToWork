package api.thirdapi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * JSONObject is when json start with { }
 * JSONArray is when json start with [ ]
 * JSONObject can contain JSONArray and vice vesa
 */

public class JsonResponceBody2 {

    @Test
    public void testJsonBody() {
        baseURI = "http://localhost:3000/";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .pathParam("myPath", "friends")
                        .when()
                        .get("{myPath}");

        JSONArray jsonArray = new JSONArray(response.asString());

        for (int i = 0; i < jsonArray.length(); i++) {
            String firstname = jsonArray.getJSONObject(i).get("firstName").toString();
            System.out.println("Firstnames : " + firstname);
        }
    }

    @Test
    public void testBodyResponseForNamesSupportingChiefs() {
        baseURI = "http://localhost:3000/";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .pathParam("myPath", "friends")
                        .when()
                        .get("{myPath}");

        JSONArray jsonArray = new JSONArray(response.asString());

        for (int i = 0; i < jsonArray.length(); i++) {
            String team = "Chiefs";

            for (int y = 0; y < jsonArray.getJSONObject(i).getJSONArray("soccer_teams").length(); y++) {
                String soccerTeam = jsonArray.getJSONObject(i).getJSONArray("soccer_teams").get(y).toString();
                if (soccerTeam.contains(team)) {
                    String firstName = jsonArray.getJSONObject(i).get("firstName").toString();
                    System.out.println("Kaizer Chiefs supporter : " + firstName);
                }
            }
        }
    }
}