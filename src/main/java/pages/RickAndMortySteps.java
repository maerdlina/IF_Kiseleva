package pages;

import config.PropertyConfiguration;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RickAndMortySteps {
    public Response getShortResponce(String get, int statusCode) {
        Response responce = given()
                .get(get)
                .then()
                .statusCode(statusCode)
                .extract().response();
        return responce;
    }

    public void characterSearch(String baseUri, int status){
        Response characterResponse = given()
                .baseUri(baseUri)
                .queryParam("name", PropertyConfiguration.get("searchCharacterByRickAndMorty"))
                .when()
                .get("/character")
                .then()
                .statusCode(status)
                .extract().response();

        String lastEpisode = characterResponse.jsonPath().getString("results[0].episode[-1]");
        Response lastEpisodeResponse = getShortResponce(lastEpisode, status);

        String lastCharacter = lastEpisodeResponse.jsonPath().getString("characters[-1]");
        Response lastCharacterResponse = getShortResponce(lastCharacter, status);

        String lastCharacterLocation = lastCharacterResponse.jsonPath().getString("location.name");
        String lastCharacterRace = lastCharacterResponse.jsonPath().getString("species");

        Assertions.assertNotEquals(lastCharacterLocation, characterResponse.jsonPath().getString("results[0].location.name"));
        Assertions.assertEquals(lastCharacterRace, characterResponse.jsonPath().getString("results[0].species"));
    }
}
