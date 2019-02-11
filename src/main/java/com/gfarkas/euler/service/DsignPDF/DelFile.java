package com.gfarkas.euler.service.DsignPDF;

import java.io.File;

public class DelFile {
    private static boolean isFinished = false;

    public DelFile() {
    }

    public static void delFile(File LOCATION) {
        try {
            if (!LOCATION.delete()) {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
