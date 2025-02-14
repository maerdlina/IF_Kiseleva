package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ChecksTask {
    private static final SelenideElement userProfile = $x("//a[@id='header-details-user-fullname']").as("Профиль пользователя");
    private static final SelenideElement subNavTitle = $x("//h1/span[@id='issues-subnavigation-title']").as("Заголовок задач");

    public static Boolean isUserProfileDisplayed() {
        waitSignIn();
        return userProfile.isDisplayed();
    }

    public static void waitSignIn() {
        userProfile.shouldBe(Condition.visible);
    }

    public static Boolean isTitleExist(String title) {
        return subNavTitle.getText().equals(title);
    }

}
