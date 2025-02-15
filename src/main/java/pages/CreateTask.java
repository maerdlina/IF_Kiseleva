package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CreateTask {
    private final SelenideElement createTask = $x("//a[@id='create_link']").as("Создание задачи");
    private final SelenideElement inputTheme = $x("//input[@id='summary']").as("Заполнение темы");
    private final SelenideElement createButton = $x("//input[@value='Создать']").as("Кнопка создания внутри формы задачи");
    private final SelenideElement checkTask = $x("//a[@class='issue-created-key issue-link']").as("Созданная задача");
    private final SelenideElement dropdownPriority = $x("//a[@class='order-options aui-button aui-style-default jira-aui-dropdown2-trigger']").as("Выпадающий список сортировки");
    private final SelenideElement labelCheck = $x("//label[@class='item-label checkbox']").as("Пункты выпадающего списка");
    private final SelenideElement lastTask = $x("//ol[@class='issue-list']/li[1]/a").as("Последняя задача");
    private final SelenideElement workButton = $x("//a[@id='action_id_21']").as("Смена статуса задачи");
    private final SelenideElement businessProcess =$x("//a[@id='opsbar-transitions_more']").as("Бизнес-процесс выпадающий список");
    private final SelenideElement workDone =$x("//span[text()='Выполнено']/parent::a[@role='menuitem']").as("Статус выполнено");
    SelenideElement iframe = $x("//iframe[@id='mce_0_ifr']").as("iFrame описания ошибки");
    SelenideElement iframeTextarea = $x("//body[@id='tinymce']").as("Textarea куда записывается описнаие ошибки");
    SelenideElement issueTypeField = $x("//input[@id='issuetype-field']").as("Поле выбора типа задачи");

    public void createTask(String taskTheme, String description) {
        createTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

        issueTypeField.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

        inputTheme.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(taskTheme);

        Selenide.switchTo().frame(iframe);
        iframeTextarea.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(description);

        Selenide.switchTo().defaultContent();

        createButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

        checkTask.shouldBe(Condition.visible, Duration.ofSeconds(10));
        lastTask.shouldBe(Condition.visible, Duration.ofSeconds(10));

        Selenide.refresh();
    }

    public void statusChange(){
        dropdownPriority.click();
        labelCheck.click();
        lastTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        workButton.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        workButton.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        businessProcess.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        workDone.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}
