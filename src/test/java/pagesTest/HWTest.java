package pagesTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import pages.*;
import webHooks.WebHooks;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // Задаем порядок тестов
public class HWTest extends WebHooks {
    private final String login = "AT4";
    private final String password = "Qwerty123";
    private int startNumTask, endNumTask;

    private final AuthPage authPage = new AuthPage();
    private final TestPage testPage = new TestPage();
    private final JiraTask jiraTask = new JiraTask();
    private final CreateTask createJiraTask = new CreateTask();

    @DisplayName("Authorization check")
    @Test
    @Order(1)
    public void loginTest(){
        authPage.login(login, password);
        Assertions.assertTrue(ChecksTask.isUserProfileDisplayed());
    }

    @DisplayName("Tasks Check")
    @Test
    @Order(2)
    public void projectPageTest(){
        authPage.login(login, password);
        testPage.projectPage();
        Assertions.assertTrue(ChecksTask.isTitleExist("Открытые задачи"));
    }

    @DisplayName("Check fields by task TestSeleniumATHomework")
    @Test
    @Order(3)
    public void taskTestSelenium(){
        authPage.login(login, password);
        ChecksTask.waitSignIn();
        testPage.searchText("TestSeleniumATHomework");
        // Добавляем ожидание перед проверкой статуса
        SelenideElement statusElement = $x("//span[@id='status-val']/child::span")
                .shouldBe(Condition.visible, Duration.ofSeconds(10));
        List<String> status = jiraTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", status.get(0));
        Assertions.assertEquals("Version 2.0", status.get(1));
    }

    @DisplayName("Create new bug")
    @Test
    @Order(4)
    public void CreateJiraTask(){
        authPage.login(login, password);
        testPage.projectPage();
        startNumTask = testPage.countTask();
        createJiraTask.createTask("Bug","New Bug" );
        SelenideElement newTask = $x("//ol[@class='issue-list']/li[1]/a")
                .shouldBe(Condition.visible, Duration.ofSeconds(10));
        Selenide.refresh();
        endNumTask = testPage.countTask();
        Assertions.assertEquals(startNumTask, endNumTask-1);
    }

    @DisplayName("Change status")
    @Test
    @Order(5)
    public void ChangeStatus(){
        authPage.login(login, password);
        testPage.projectPage();
        createJiraTask.statusChange();
    }
}