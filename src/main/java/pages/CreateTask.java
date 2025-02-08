package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CreateTask {
    private final SelenideElement createTask = $x("//a[@id='create_link']");
    private final SelenideElement inputTheme = $x("//input[@id='summary']");
//    private final SelenideElement inputDescription = $x("//textarea[@name='description']");
    private final SelenideElement createButton = $x("//input[@value='Создать']");
    private final SelenideElement checkTask = $x("//a[@class='issue-created-key issue-link']");
    private final SelenideElement dropdownPriority = $x("//a[@class='order-options aui-button aui-style-default jira-aui-dropdown2-trigger']");
    private final SelenideElement labelCheck = $x("//label[@class='item-label checkbox']");
    private final SelenideElement lastTask = $x("//ol[@class='issue-list']/li[1]/a");
    private final SelenideElement workButton = $x("//a[@id='action_id_21']");
    private final SelenideElement actionInWork =$x("//a[@id='action_id_21']");
    private final SelenideElement businessProcess =$x("//a[@id='opsbar-transitions_more']");
    private final SelenideElement workDone =$x("//span[text()='Выполнено']/parent::a[@role='menuitem']");


    public void createTask(String taskTheme, String description) {
        createTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        inputTheme.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(taskTheme);

        // Ожидание появления iFrame и переключение в него
        SelenideElement iframe = $x("//iframe[@id='mce_0_ifr']")
                .shouldBe(Condition.visible, Duration.ofSeconds(10));
        Selenide.switchTo().frame(iframe);

        // Взаимодействие с полем описания внутри iFrame
        SelenideElement iframeTextarea = $x("//body[@id='tinymce']");
        iframeTextarea.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(description);

        // Возвращаемся в основной контент
        Selenide.switchTo().defaultContent();

        createButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        checkTask.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }


    public void statusChange(){
        dropdownPriority.click();
        labelCheck.click();
        lastTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        workButton.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        actionInWork.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        businessProcess.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        workDone.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}
