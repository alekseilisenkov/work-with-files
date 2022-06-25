package com.alexlisenkov.utils;

import com.codeborne.xlstest.XLS;

import java.io.IOException;

import static org.apache.commons.io.FileUtils.getFile;

public class Files {
    public static XLS getXls(String path) throws IOException {
        return new XLS(getFile(path));
    }
}
