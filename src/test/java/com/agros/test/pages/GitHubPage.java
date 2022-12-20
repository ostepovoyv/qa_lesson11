package com.agros.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GitHubPage {


    private final SelenideElement
            searchInput = $(".header-search-input"),
            wikiTab = $("#wiki-tab");

    private final ElementsCollection
            headerMenu = $$(".HeaderMenu-item"),
            headerMenuItem = $$(".HeaderMenu-dropdown-link");

    @Step("Открываем страницу {url}")
    public GitHubPage openMainPage(String url){
        open(url);
        return this;
    }

    @Step("Открываем страницу {repo}")
    public GitHubPage openRepoPage(String repo) {
        searchInput.click();
        searchInput.sendKeys(repo);
        searchInput.submit();
        $(linkText(repo)).click();
        return this;
    }

    @Step("Открываем WIKI")
    public GitHubPage openWikiPage() {
        wikiTab.click();
        return this;
    }

    @Step("Выбираем меню {item} ")
    public GitHubPage selectMenuItem(String item) {
        headerMenu.findBy(Condition.text(item)).hover();
        return this;
    }

    @Step("Выбираем пункт меню {item}")
    public GitHubPage goToMenuItem(String item) {
        headerMenuItem.findBy(Condition.text(item)).click();
        return this;
    }

}
