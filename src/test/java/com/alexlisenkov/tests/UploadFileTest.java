package com.alexlisenkov.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileTest {
    @Test
    void txtTest(){
        Selenide.open("https://the-internet.herokuapp.com/upload");
        $("#file-upload").uploadFromClasspath("txtdocument.txt");
        $("#file-submit").click();
        $("#content").shouldHave(Condition.text("txtdocument.txt"));
    }

}

//    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//    InputStream inputStream = classLoader.getResourceAsStream("/src/resources/txtdocument.txt");