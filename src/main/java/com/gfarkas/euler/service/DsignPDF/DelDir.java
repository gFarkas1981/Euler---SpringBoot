package com.gfarkas.euler.service.DsignPDF;

import java.io.File;
import java.io.IOException;

public class DelDir {
    public DelDir() {
    }

    public static void delDir(String LOCATION) {
        File directory = new File(LOCATION);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
        } else {
            try {
                delete(directory);
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

        System.out.println("Done");
    }

    public static void delete(File file) throws IOException {
        if (file.isDirectory()) {
            if (file.list().length == 0) {
                file.delete();
            } else {
                String[] files = file.list();
                String[] var2 = files;
                int var3 = files.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    String temp = var2[var4];
                    File fileDelete = new File(file, temp);
                    delete(fileDelete);
                }

                if (file.list().length == 0) {
                    file.delete();
                }
            }
        } else {
            file.delete();
        }

    }
}
