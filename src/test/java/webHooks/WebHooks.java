package webHooks;

import com.codeborne.selenide.Selenide;
import config.PropertyConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    @BeforeEach
    public void openBrowser(){
        Selenide.open(PropertyConfiguration.get("url"));
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
