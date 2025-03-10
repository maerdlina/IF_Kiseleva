package steps;

import config.PropertyConfiguration;
import io.cucumber.java.ru.Допустим;
import pages.*;
import handlers.ErrorHandler;

import java.io.IOException;

public class RickAndMortyStep {
    @Допустим("поиск персонажа и сравнение")
    public void searchAndCompare() throws IOException {
        try {
            String characterName = PropertyConfiguration.get("searchCharacterByRickAndMorty");
            if (!characterName.equals("Morty Smith")) {
                throw new RuntimeException("Неверное имя персонажа в config.properties. Ожидалось: Morty Smith, получено: " + characterName);
            }

            String statusCode = PropertyConfiguration.get("statusCodeRickAndMorty");
            if (!statusCode.equals("200")) {
                throw new RuntimeException("Неверный статус код в config.properties. Ожидалось: 200, получено: " + statusCode);
            }

            String baseUrl = PropertyConfiguration.get("baseUrlRickAndMorty");
            if (baseUrl == null || baseUrl.isEmpty()) {
                throw new RuntimeException("Неверный URL в config.properties. Ожидалось корректный URL, получено: " + baseUrl);
            }

            new RickAndMorty().characterSearch(baseUrl, Integer.parseInt(statusCode));
        } catch (Exception e) {
            ErrorHandler.attachErrorDetails(e);
            throw e;
        }
    }
}