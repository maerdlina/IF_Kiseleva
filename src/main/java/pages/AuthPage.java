package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private final SelenideElement inputName = $x("//input[@name='os_username']").as("Ввод логина");
    private final SelenideElement inputPassword = $x("//input[@name='os_password']").as("Ввод пароля");
    private final SelenideElement loginButton = $x("//input[@name='login']").as("Кнопка войти");

    @Step("Ввод логина: {log}")
    public void enterLogin(String log) {
        inputName.setValue(log);
    }

    @Step("Ввод пароля: {pass}")
    public void enterPassword(String pass) {
        inputPassword.setValue(pass);
    }

    public void login(String log, String pass) {
        inputName.shouldBe(Condition.visible);
        inputPassword.shouldBe(Condition.visible);
        enterLogin(log);
        enterPassword(pass);
        loginButton.click();
    }

}