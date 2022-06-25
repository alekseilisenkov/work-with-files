package com.alexlisenkov.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.alexlisenkov.utils.Zip.unzip;

public class ZipFileWithPasswordTest {
    @Test
    void parseFilesInsideZipTest() throws Exception {

        unzip("./src/test/resources/zip_password(0000).zip", "0000", "./src/test/resources/unzipfiles");
        String txtFilePath = "./src/test/resources/unzipfiles/txtdocument.txt";
        String s;
        try (InputStream is = new FileInputStream(txtFilePath)) {
            s = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }

        Assertions.assertTrue(s.contains("TXT have some text, and if you read it, it means that this test is passed."));
    }
}
