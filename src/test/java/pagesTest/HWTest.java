package pagesTest;

import config.PropertyConfiguration;
import handlers.AllureExceptionHandler;
import io.qameta.allure.Allure;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import pages.*;
import webHooks.WebHooks;
import java.util.List;

public class HWTest extends WebHooks {
    private int startNumTask, endNumTask;

    private final AuthPage authPage = new AuthPage();
    private final TestPage testPage = new TestPage();
    private final JiraTask jiraTask = new JiraTask();
    private final CreateTask createJiraTask = new CreateTask();

    @Test
    @DisplayName("Test 1 - Authentification")
    @Description("Проверка успешности аутентификации пользователя")
    public void loginTest() {
        try {
            Allure.addAttachment("User", PropertyConfiguration.get("login"));
            Allure.addAttachment("Password", PropertyConfiguration.get("password"));
            authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
            Assertions.assertTrue(ChecksTask.isUserProfileDisplayed());
        } catch (Throwable e) {
            AllureExceptionHandler.attachErrorDetails(e);
            throw e;
        }
    }

    @Test
    @DisplayName("Test 2 - Tasks Check")
    @Description("Проверка перехода на страницу проекта")
    public void projectPageTest() {
        try {
            authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
            testPage.projectPage();
            Assertions.assertTrue(ChecksTask.isTitleExist("Открытые задачи"));
        } catch (Throwable e) {
            AllureExceptionHandler.attachErrorDetails(e);
            throw e;
        }
    }

    @Test
    @DisplayName("Test 3 - Check fields by task TestSeleniumATHomework")
    @Description("Проверка полей в задании TestSeleniumATHomework")
    public void taskTestSelenium() {
        try {
            authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
            ChecksTask.waitSignIn();
            testPage.searchText("TestSeleniumATHomework");
            List<String> status = jiraTask.statusCheck();
            Assertions.assertEquals("СДЕЛАТЬ", status.get(0));
            Assertions.assertEquals("Version 2.0", status.get(1));
        } catch (Throwable e) {
            AllureExceptionHandler.attachErrorDetails(e);
            throw e;
        }
    }

    @Test
    @DisplayName("Test 4 - Create new bug")
    @Description("Проверка создания новой ошибки")
    public void CreateJiraTask() {
        try {
            authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
            testPage.projectPage();
            startNumTask = testPage.countTask();
            createJiraTask.createTask("BugBug", "New Bug2");
            endNumTask = testPage.countTask();
            Assertions.assertEquals(startNumTask, endNumTask - 1);
        } catch (Throwable e) {
            AllureExceptionHandler.attachErrorDetails(e);
            throw e;
        }
    }

    @Test
    @DisplayName("Test 5 - Change status")
    @Description("Смена статусов")
    public void ChangeStatus() {
        try {
            authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
            testPage.projectPage();
            createJiraTask.statusChange();
        } catch (Throwable e) {
            AllureExceptionHandler.attachErrorDetails(e);
            throw e;
        }
    }
}
