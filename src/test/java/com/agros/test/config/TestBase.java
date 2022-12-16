package com.agros.test.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    private static final String URL = "https://github.com";

    @BeforeAll
    public static void setUpMain(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 10000;
        Configuration.baseUrl= URL;

    }

    @BeforeEach
    public void beforeEachTest(){
        open(URL);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEachTest(){
        Selenide.closeWebDriver();
    }

}
