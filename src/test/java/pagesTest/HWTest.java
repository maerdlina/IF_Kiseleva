package pagesTest;

import config.PropertyConfiguration;
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

    @DisplayName("Authentification check")
    @Test
    public void loginTest(){
        authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
        Assertions.assertTrue(ChecksTask.isUserProfileDisplayed());
    }

    @DisplayName("Tasks Check")
    @Test
    public void projectPageTest(){
        authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
        testPage.projectPage();
        Assertions.assertTrue(ChecksTask.isTitleExist("Открытые задачи"));
    }

    @DisplayName("Check fields by task TestSeleniumATHomework")
    @Test
    public void taskTestSelenium(){
        authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
        ChecksTask.waitSignIn();
        testPage.searchText("TestSeleniumATHomework");
        List<String> status = jiraTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", status.get(0));
        Assertions.assertEquals("Version 2.0", status.get(1));
    }

    @DisplayName("Create new bug")
    @Test
    public void CreateJiraTask(){
        authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
        testPage.projectPage();
        startNumTask = testPage.countTask();
        createJiraTask.createTask("BugBug","New Bug2" );
        endNumTask = testPage.countTask();
        Assertions.assertEquals(startNumTask, endNumTask-1);
    }

    @DisplayName("Change status")
    @Test
    public void ChangeStatus(){
        authPage.login(PropertyConfiguration.get("login"), PropertyConfiguration.get("password"));
        testPage.projectPage();
        createJiraTask.statusChange();
    }
}