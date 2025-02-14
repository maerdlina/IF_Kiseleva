package webHooks;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = Config.class.getResourceAsStream("/config.properties")){
            props.load(input);
        } catch (Exception e){
            throw new RuntimeException("Error loading config", e);
        }
    }

    @BeforeEach
    public void openBrowser(){
        Selenide.open(props.getProperty("url"));
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
