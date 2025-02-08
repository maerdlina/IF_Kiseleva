package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private final SelenideElement inputName = $x("//input[@name='os_username']");
    private final SelenideElement inputPassword = $x("//input[@name='os_password']");
    private final SelenideElement loginButton = $x("//input[@name='login']");

    public void login(String log, String pass){
        inputName.shouldBe(Condition.visible);
        inputPassword.shouldBe(Condition.visible);
        inputName.setValue(log);
        inputPassword.setValue(pass);
        loginButton.click();
    }
}