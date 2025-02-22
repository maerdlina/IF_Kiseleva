package webHooks;

import org.junit.jupiter.api.BeforeEach;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.util.Arrays;
import java.util.List;

public class WebHooks {
    @BeforeEach
    public void beforeEach(){
        Filter requestLogFilter = new RequestLoggingFilter(LogDetail.ALL);
        Filter responseLogFilter = new ResponseLoggingFilter(LogDetail.ALL);

        List<Filter> filters = Arrays.asList(requestLogFilter, responseLogFilter);

        RestAssured.filters(filters);
    }
}
