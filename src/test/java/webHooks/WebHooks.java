package webHooks;

import com.codeborne.selenide.Selenide;
import config.PropertyConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {

    @Before
    public void openChrome() {
        Selenide.open(PropertyConfiguration.get("url"));
        getWebDriver().manage().window().maximize();
    }

    @After
    public void closeChrome() {
        Selenide.closeWebDriver();
    }
}
