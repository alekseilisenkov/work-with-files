package com.alexlisenkov.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.*;

import static com.alexlisenkov.utils.Files.getXls;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.apache.commons.io.FileUtils.getFile;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.nio.charset.StandardCharsets;

public class XlsFileTest {

    @Test
    void getExelFirstTest() throws Exception {
        String txtFilePath = "./src/test/resources/xls.xlsx";
        String expectedData = "Просмотр реестр рассылок";

        XLS xls = getXls(txtFilePath);
        String x = xls.excel.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
        assertThat(x).isEqualTo("На странице отображается реестр рассылок");
    }

    @Test
    void getExcelSecondTest() throws Exception {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("xls.xlsx")) {
            XLS parsed = new XLS(stream);

            assertThat(parsed.excel.getSheetAt(0).getRow(1).getCell(3).getStringCellValue())
                    .isEqualTo("На странице отображается реестр рассылок");
        }
    }
}


