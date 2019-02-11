package com.gfarkas.euler.service.DsignPDF;

import java.io.File;

public class ReName {
    public ReName() {
    }

    public static void reName(File file, File file2) {
        file.renameTo(file2);
    }
}


