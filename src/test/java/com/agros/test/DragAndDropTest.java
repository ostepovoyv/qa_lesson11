package com.agros.test;

import com.agros.test.data.TestData;
import com.agros.test.pages.DragAndDropPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DragAndDropTest {

    @Test
    @DisplayName("Drag and Drop тест")
    public void dragAndDropTest(){
        new DragAndDropPage()
                .openPage(TestData.URL_HEROKUAPP)
                .swapAtoB()
                .checkResultAfterSwap("A","B");
    }
}
