package rickandmorty;

import org.junit.jupiter.api.Test;
import pages.RickAndMortySteps;

import static io.restassured.RestAssured.given;

public class RickAndMortyTest {
    @Test
    public void check(){
        new RickAndMortySteps().
                characterSearch("https://rickandmortyapi.com/api",200);
    }
}
