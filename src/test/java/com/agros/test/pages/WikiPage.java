package com.agros.test.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WikiPage {

    private final SelenideElement
            pageBox = $("#wiki-pages-box"),
            pageHeaderTitle = $(".gh-header-title"),
            showMorePages = $(".js-wiki-more-pages-link"),
            wikiBody = $("#wiki-body");

    @Step("Проверяем, что в списке страниц (Pages) есть страница {page}")
    public WikiPage checkWikiPageContainsSoftAssertionsPage(String page) {
        showMorePages.click();
        pageBox.shouldHave(text(page));
        return this;
    }

    @Step("Открываем страницу {page}, проверяем что внутри есть пример кода для JUnit5")
    public WikiPage checkSoftAssertionsPageContainsJUnit5Example(String page, String exampleText) {
        pageBox.find(byText(page)).click();
        pageHeaderTitle.shouldHave(text(page));
        wikiBody.shouldHave(text(exampleText));
        return this;
    }

}
