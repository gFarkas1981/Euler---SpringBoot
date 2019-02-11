package com.gfarkas.euler.service.DsignPDF;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Wildcard {
    static File filteredFile;
    static int lastFile;

    public Wildcard() {
    }

    public static File wildcard(File dir, FileFilter fileFilter, int num) throws IOException {
        File[] files = dir.listFiles(fileFilter);
        lastFile = files.length;
        return files[num];
    }
}
