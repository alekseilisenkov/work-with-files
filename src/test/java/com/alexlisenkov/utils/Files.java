package com.alexlisenkov.utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.apache.commons.io.FileUtils.getFile;

public class Files {
    public static XLS getXls(String path) throws IOException {
        return new XLS(getFile(path));
    }
}
