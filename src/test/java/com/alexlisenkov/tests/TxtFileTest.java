package com.alexlisenkov.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TxtFileTest {

    @Test
    void txtFileTest() throws IOException {
        String txtFilePath = "./src/test/resources/txtdocument.txt";
        String s;
        try (InputStream is = new FileInputStream(txtFilePath)) {
            s = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }

        Assertions.assertTrue(s.contains("This is txt document"));
    }
}