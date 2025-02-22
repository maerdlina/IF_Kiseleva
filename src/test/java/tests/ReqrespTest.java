package tests;

import config.PropertyConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ReqresSteps;
import webHooks.WebHooks;

import java.io.IOException;

public class ReqrespTest extends WebHooks {
    @DisplayName("Создание пользователя")
    @Test
    public void postUserTest() throws IOException {
        new ReqresSteps().createResponce(PropertyConfiguration.get("baseUrlReqRes"), PropertyConfiguration.get("postUrlReqRes"), Integer.parseInt(PropertyConfiguration.get("statusCodeReqRes")));
    }
}
