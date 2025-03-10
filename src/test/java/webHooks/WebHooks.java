package webHooks;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import com.codeborne.selenide.logevents.SelenideLogger;

import java.util.Arrays;
import java.util.List;

import io.cucumber.java.Before;

import handlers.SelenideAllureCustom;

public class WebHooks {
    @Before
    public void beforeEach(){
        SelenideLogger.addListener("Allure", new SelenideAllureCustom());
        Filter requestLogFilter = new RequestLoggingFilter(LogDetail.ALL);
        Filter responseLogFilter = new ResponseLoggingFilter(LogDetail.ALL);

        List<Filter> filters = Arrays.asList(requestLogFilter, responseLogFilter);

        RestAssured.filters(filters);
    }
}
