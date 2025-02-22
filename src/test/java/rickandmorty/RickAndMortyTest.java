package rickandmorty;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RickAndMortySteps;

import static io.restassured.RestAssured.given;

public class RickAndMortyTest {
    @DisplayName("Compare Race and Location")
    @Test
    public void check(){
        new RickAndMortySteps().
                characterSearch("https://rickandmortyapi.com/api",200);
    }
}
