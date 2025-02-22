package pages;

import config.PropertyConfiguration;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReqresSteps {
    public void createResponce(String baseUri, String postUri, int statusCode) throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get(PropertyConfiguration.get("urlToJson")))));

        body.put("name", PropertyConfiguration.get("newUserName"));
        body.put("job", PropertyConfiguration.get("newUserJob"));

        given()
                .header("Content-Type", "application/json")
                .header("Accept-Charset", "UTF-8")
                .baseUri(baseUri)
                .body(body.toString())
                .when()
                .post(postUri)
                .then()
                .statusCode(statusCode)
                .body("name", equalTo(PropertyConfiguration.get("newUserName")))
                .body("job", equalTo(PropertyConfiguration.get("newUserJob")));
    }
}
