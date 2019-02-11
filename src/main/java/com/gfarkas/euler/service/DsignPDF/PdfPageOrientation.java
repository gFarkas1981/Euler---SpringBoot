package com.gfarkas.euler.service.DsignPDF;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import java.io.File;
import java.io.IOException;

public class PdfPageOrientation {
    static int landscape = 0;
    static float k;

    public PdfPageOrientation() {
    }

    public static int pdfPageOrientation(File SRC, int pageNumber) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(String.valueOf(SRC)));
        Rectangle mediabox = pdfDoc.getPage(pageNumber).getMediaBox();
        Rectangle pagesize = pdfDoc.getPage(pageNumber).getPageSizeWithRotation();
        k = pagesize.getHeight();
        if (k > 600.0F) {
            landscape = 0;
            System.out.println(k);
        } else {
            landscape = 1;
            System.out.println(k);
        }

        return landscape;
    }
}
