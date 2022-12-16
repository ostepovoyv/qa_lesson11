package com.agros.test.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class GitHubPage {


    private final SelenideElement
            searchInput = $(".header-search-input"),
            wikiTab = $("#wiki-tab");

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

}
