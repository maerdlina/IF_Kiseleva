package handlers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.util.Arrays;

public class ErrorHandler {

    @Attachment(type = "text/plain", value = "Детали ошибки")
    public static String attachErrorDetails(Throwable error) {
        attachScreenshot();
        return String.format(
                "🛑 Ошибка: %s\n\n🔍 Контекст:\n%s\n\n📄 StackTrace:\n%s",
                error.getMessage(),
                getErrorContext(error),
                Arrays.toString(error.getStackTrace())
        );
    }

    @Attachment(type = "image/png", value = "Скриншот на момент ошибки")
    public static byte[] attachScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    private static String getErrorContext(Throwable error) {
        String errorMessage = error.getMessage();
        if (errorMessage.contains("Неверное имя персонажа")) {
            return "Проверьте значение searchCharacterByRickAndMorty в config.properties. Ожидалось: Morty Smith";
        }
        if (errorMessage.contains("Неверный статус код")) {
            return "Проверьте значение statusCodeRickAndMorty в config.properties. Ожидалось: 200";
        }
        if (errorMessage.contains("Неверный URL")) {
            return "Проверьте значение baseUrlRickAndMorty в config.properties. Ожидалось корректный URL";
        }
        return "Дополнительный контекст отсутствует.";
    }
}