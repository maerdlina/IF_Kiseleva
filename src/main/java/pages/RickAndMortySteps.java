package pages;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RickAndMortySteps {
    public void characterSearch(String baseUri, int status){
        Response characterResponse = given()
                .baseUri(baseUri)
                .queryParam("name", "Morty Smith")
                .when()
                .get("/character")
                .then()
                .statusCode(status)
                .extract().response();
        String lastEpisode = characterResponse.jsonPath().getString("results[0].episode[-1]");

        Response lastEpisodeResponse = given()
                .get(lastEpisode)
                .then()
                .statusCode(status)
                .extract().response();

        String lastCharacter = lastEpisodeResponse.jsonPath().getString("characters[-1]");

        Response lastCharacterResponse = given()
                .get(lastCharacter)
                .then()
                .statusCode(status)
                .extract().response();

        String lastCharacterLocation = lastCharacterResponse.jsonPath().getString("location.name");
        String lastCharacterRace = lastCharacterResponse.jsonPath().getString("species");

        Assertions.assertFalse(Boolean.parseBoolean(lastCharacterLocation), characterResponse.jsonPath().getString("result[0].location.name"));
        Assertions.assertFalse(Boolean.parseBoolean(lastCharacterRace), characterResponse.jsonPath().getString("result[0].species"));
    }
}
