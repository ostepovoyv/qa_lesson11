package com.agros.test;

import com.agros.test.config.TestBase;
import com.agros.test.data.TestData;
import com.agros.test.pages.EnterprisePage;
import com.agros.test.pages.GitHubPage;
import com.agros.test.pages.WikiPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GitHubTest extends TestBase {

    @Test
    @DisplayName("Проверка наличия страницы и текста на GitHub")
    public void gitHubTest(){
        new GitHubPage()
                .openMainPage(TestData.URL_GITHUB)
                .openRepoPage(TestData.REPO)
                .openWikiPage();
        new WikiPage()
                .checkWikiPageContainsSoftAssertionsPage(TestData.PAGE)
                .checkSoftAssertionsPageContainsJUnit5Example(TestData.PAGE, TestData.EXAMPLE_TEXT_FOR_JUNIT5);
    }

    @Test
    @DisplayName("Проверка меню с использованием hover")
    public void hoverMenuTest(){
        new GitHubPage()
                .openMainPage(TestData.URL_GITHUB)
                .selectMenuItem("Solutions")
                .goToMenuItem("Enterprise");
        new EnterprisePage()
                .checkPageText("Build like the best");
    }
}
