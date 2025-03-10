package webHooks;

import com.codeborne.selenide.Selenide;
import config.PropertyConfiguration;
import handlers.SelenideAllureCustom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.codeborne.selenide.logevents.SelenideLogger;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import io.qameta.allure.Allure;

public class WebHooks {
    @BeforeEach
    public void openBrowser(){
        Selenide.open(PropertyConfiguration.get("url"));
        SelenideLogger.addListener("Allure", new SelenideAllureCustom());
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        Allure.addAttachment("Page title", getWebDriver().getTitle());
        Allure.addAttachment("Cookies", getWebDriver().manage().getCookies().toString());
        Selenide.closeWebDriver();
    }

}
