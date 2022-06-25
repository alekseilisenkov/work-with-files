package com.alexlisenkov.tests;

import com.codeborne.xlstest.XLS;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static com.alexlisenkov.utils.Files.getXls;

import static org.assertj.core.api.Assertions.assertThat;

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