package handlers;

import io.qameta.allure.selenide.AllureSelenide;

public class SelenideAllureCustom extends AllureSelenide {
    public SelenideAllureCustom() {
        super();
        this.screenshots(true);
        this.savePageSource(true);
    }
}