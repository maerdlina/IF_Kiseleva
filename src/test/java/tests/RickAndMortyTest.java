package tests;

import config.PropertyConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RickAndMortySteps;
import webHooks.WebHooks;

public class RickAndMortyTest extends WebHooks {
    @DisplayName("Compare Race and Location")
    @Test
    public void compareTest(){
        new RickAndMortySteps().
                characterSearch(PropertyConfiguration.get("baseUrlRickAndMorty"),Integer.parseInt(PropertyConfiguration.get("statusCodeRickAndMorty")));
    }
}
