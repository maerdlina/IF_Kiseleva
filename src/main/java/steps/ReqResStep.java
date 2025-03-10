package steps;

import config.PropertyConfiguration;
import io.cucumber.java.ru.И;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import pages.ReqRes;
import handlers.ErrorHandler;

import java.io.IOException;

public class ReqResStep {
    @И("создание пользователя")
    @DisplayName("Поиск и сравнение - DisplayName")
    @Description("Поиск и сравнение - Description")
    public void postUserTest() throws IOException {
        try {
            String baseUrl = PropertyConfiguration.get("baseUrlReqRes");
            if (baseUrl == null || baseUrl.isEmpty()) {
                throw new RuntimeException("Неверный URL в config.properties. Ожидалось корректный URL, получено: " + baseUrl);
            }

            String statusCode = PropertyConfiguration.get("statusCodeReqRes");
            if (!statusCode.equals("201")) {
                throw new RuntimeException("Неверный статус код в config.properties. Ожидалось: 201, получено: " + statusCode);
            }

            new ReqRes().createResponce(baseUrl, PropertyConfiguration.get("postUrlReqRes"), Integer.parseInt(statusCode));
        } catch (Exception e) {
            ErrorHandler.attachErrorDetails(e);
            throw e;
        }
    }
}
