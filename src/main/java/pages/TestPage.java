package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    private final SelenideElement projButton = $x("//a[@id='browse_link']");
    private final SelenideElement icoTest = $x("//a[@id='admin_main_proj_link_lnk']");
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    private final SelenideElement tasksCount = $x("//div[@class='showing']/child::span");

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