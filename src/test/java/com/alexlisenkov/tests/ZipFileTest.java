package com.alexlisenkov.tests;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileTest {
    @Test
    void parseFilesInsideZipTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("zip_2MB.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    void parseTextFilesInZippedFilesTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("zip_2MB.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            Scanner sc = new Scanner(zis);

            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}