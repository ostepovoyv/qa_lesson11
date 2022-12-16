package com.agros.test;

import com.agros.test.config.TestBase;
import com.agros.test.data.TestData;
import com.agros.test.pages.GitHubPage;
import com.agros.test.pages.WikiPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GitHubTest extends TestBase {

    @Test
    @DisplayName("Проверка наличия страницы и текста на GitHub")
    public void test(){
        new GitHubPage()
                .openRepoPage(TestData.REPO)
                .openWikiPage();
        new WikiPage()
                .checkWikiPageContainsSoftAssertionsPage(TestData.PAGE)
                .checkSoftAssertionsPageContainsJUnit5Example(TestData.PAGE, TestData.EXAMPLE_TEXT_FOR_JUNIT5);

    }
}
