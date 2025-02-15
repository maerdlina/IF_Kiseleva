package webHooks;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = WebHooks.class.getResourceAsStream("/config.properties")) {
            if (input == null) {
                throw new RuntimeException("Config file not found");
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading config", e);
        }
    }

    @Before
    public void openChrome() {
        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }


    @After
    public void closeChrome() {
        Selenide.closeWebDriver();
    }
}
