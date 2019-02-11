package com.gfarkas.euler.service.DsignPDF;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;

public class PdfAddPages {
    public PdfAddPages() {
    }

    public static void pdfAddPages(String src, String[] extra, String dest) throws IOException, java.io.IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
        PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage().newContentStreamBefore(), pdfDoc.getFirstPage().getResources(), pdfDoc);
        String[] var7 = extra;
        int var8 = extra.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            String path = var7[var9];
            PdfDocument srcDoc = new PdfDocument(new PdfReader(path));
            PdfFormXObject page = srcDoc.getFirstPage().copyAsFormXObject(pdfDoc);
            canvas.addXObject(page, 0.0F, 0.0F);
            srcDoc.close();
        }

        pdfDoc.close();
    }
}
