package com.gfarkas.euler.service.DsignPDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCopier {

    static void fileCopier(File FROM, File TO) throws IOException {
        InputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            inStream = new FileInputStream(FROM);
            outStream = new FileOutputStream(TO);
            byte[] buffer = new byte[1024];

            int length;
            while((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            inStream.close();
            outStream.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }
}
