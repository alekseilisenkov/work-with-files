package com.alexlisenkov.utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Zip {

    public static void unzip(String source, String password, String destination) throws Exception {
        ZipFile zipFile = new ZipFile(source);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
        }
        zipFile.extractAll(destination);
    }
}