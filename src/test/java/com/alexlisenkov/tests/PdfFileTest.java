package com.alexlisenkov.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class PdfFileTest {
    @Test
    void downloadPdfTest() throws Exception {

        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("pdf.pdf")) {
            PDF parsed = new PDF(stream);
            assertThat(parsed.text).contains("REWRITING GIT HISTORY");
        }
    }
}
