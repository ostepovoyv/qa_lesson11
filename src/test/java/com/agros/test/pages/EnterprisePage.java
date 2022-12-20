package com.agros.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class EnterprisePage {

    private final ElementsCollection tegH1 = $$(".h1-mktg");

    @Step("ПРоверяем наличие текста '{text}' на странице")
    public EnterprisePage checkPageText(String text){
        tegH1.findBy(Condition.text(text)).shouldHave(Condition.visible);
        return this;
    }

}
