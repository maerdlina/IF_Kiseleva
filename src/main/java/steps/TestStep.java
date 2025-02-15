package steps;

import com.codeborne.selenide.Config;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import org.junit.jupiter.api.Assertions;
import pages.*;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class TestStep {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = Config.class.getResourceAsStream("/config.properties")) {
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading config", e);
        }
    }

    private final String login = props.getProperty("login");
    private final String password =  props.getProperty("password");
    private final JiraTask jiraTask = new JiraTask();
    private final CreateTask createJiraTask = new CreateTask();

    private final AuthPage authPage = new AuthPage();
    private final TestPage testPage = new TestPage();

    private int startNumTask, endNumTask;

    @И("авторизоваться в Jira")
    public void loginInJira() {
        authPage.login(login, password);
        Assertions.assertTrue(ChecksTask.isUserProfileDisplayed(), "User profile is not displayed after login");
    }

    @И("открыть проект Тест")
    public void openTestProject(){
        testPage.projectPage();
        Assertions.assertTrue(ChecksTask.isTitleExist("Открытые задачи"));
    }

    @И("проверяем status {string}")
    public void setVersion(String expectedStatus) {
        List<String> status = jiraTask.statusCheck();
        Assertions.assertEquals(expectedStatus, status.get(0), "Версия задачи не соответствует ожидаемой");
    }


    @И("проверяем fix version {string}")
    public void checkFixVersion(String expectedVersion) {
        List<String> status = jiraTask.statusCheck();
        Assertions.assertEquals(expectedVersion, status.get(1), "Версия задачи не соответствует ожидаемой");
    }

    @И("проверка версии и статуса TestSeleniumATHomework")
    public void taskTestSelenium() {
        ChecksTask.waitSignIn();
        testPage.searchText("TestSeleniumATHomework");
    }

    @Допустим("создание нового бага с темой {string} и описанием {string}")
    public void newBug(String taskTopic, String description){
        createJiraTask.createTask(taskTopic, description);
    }

    @И ("провести созданную задачу по всем статусам")
    public void changeStatus(){
        createJiraTask.statusChange();
    }

    @И ("посчитать количество задач до добавления")
    public void checkCountBefore(){
        startNumTask =  testPage.countTask();
    }

    @И ("посчитать количество задач после добавления")
    public void checkCountAfter(){
        endNumTask =  testPage.countTask();
    }

    @И("проверить изменилось ли количество задач")
    public void compareNums(){
        Assertions.assertTrue(endNumTask>startNumTask);
    }

}
