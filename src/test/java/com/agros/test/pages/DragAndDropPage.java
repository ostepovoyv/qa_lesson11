package com.agros.test.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropPage {

    private SelenideElement
            squareA = $("#column-a"),
            squareB = $("#column-b");

    @Step("Открываем страницу {url}")
    public DragAndDropPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Меняем местами A и B")
    public DragAndDropPage swapAtoB() {
        $(squareA).dragAndDropTo(squareB);
        return this;
    }

    @Step("Проверяем результат перестановки")
    public DragAndDropPage checkResultAfterSwap(String textA, String textB) {
        squareA.shouldHave(text(textB));
        squareB.shouldHave(text(textA));
        return this;
    }
}
