package webHooks;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    @BeforeEach
    public void openBrowser(){
        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
