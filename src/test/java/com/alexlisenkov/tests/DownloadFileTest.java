package com.alexlisenkov.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DownloadFileTest {
    @Test
    void downloadFile() throws Exception {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = Selenide.$("#raw-url").download();
        System.out.println(downloadedFile.toString());
        String s;
        try (InputStream is = new FileInputStream(downloadedFile)) {
            s = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
        System.out.println(s);

        Assertions.assertTrue(s.contains("Gradle Enterprise"));
    }
}