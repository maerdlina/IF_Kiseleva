package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTask {
    private final SelenideElement status =$x("//span[@id='status-val']/child::span");
    private final SelenideElement version =$x("//span[@id='fixVersions-field']/child::a");

    public List<String> statusCheck(){
        return List.of(status.getText().toUpperCase(), version.getText());
    }
}
