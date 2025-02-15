package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    private final SelenideElement projButton = $x("//a[@id='browse_link']").as("Проекты выпадающий список");
    private final SelenideElement icoTest = $x("//a[@id='admin_main_proj_link_lnk']").as("Кнопка ТЕСТ проекта");
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']").as("Строка поиска сверху");
    private final SelenideElement tasksCount = $x("//div[@class='showing']/child::span").as("Кол-во задач");

    public void projectPage(){
        projButton.click();
        icoTest.click();
    }

    public void searchText(String text){
        searchInput.sendKeys(text);
        searchInput.pressEnter();
    }

    public int countTask(){
        String countTaskText = tasksCount.getText();
        return Integer.parseInt(countTaskText.split(" ")[2]);
    }
}