package handlers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.util.Arrays;

public class AllureExceptionHandler {

    @Attachment(type = "image/png", value = "Скриншот на момент ошибки")
    public static byte[] attachScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(type = "text/plain", value = "Детали ошибки")
    public static String attachErrorDetails(Throwable error) {
        attachScreenshot();
        return String.format(
                "🛑 Ошибка: %s\n\n🔍 StackTrace:\n%s",
                error.getMessage(),
                Arrays.toString(error.getStackTrace())
        );
    }
}
