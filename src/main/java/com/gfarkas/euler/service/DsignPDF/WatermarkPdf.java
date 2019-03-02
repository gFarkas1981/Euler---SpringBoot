//package com.gfarkas.euler.service.DsignPDF;
//
//import com.itextpdf.io.font.FontProgramFactory;
//import com.itextpdf.kernel.color.Color;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfReader;
//import com.itextpdf.kernel.pdf.PdfResources;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
//import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
//import com.itextpdf.layout.Canvas;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.property.TextAlignment;
//import com.itextpdf.layout.property.VerticalAlignment;
//import org.springframework.stereotype.Component;
//
//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Component
//public class WatermarkPdf {
//
//    PipedOutputStream watermarkPdf(InputStream SRC) throws Exception {
//
//        PipedOutputStream DEST = null;
//
//        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(String.valueOf(DEST)));
//
//        int n = pdfDoc.getNumberOfPages();
//        new PdfCanvas(pdfDoc.getFirstPage().newContentStreamBefore(), new PdfResources(), pdfDoc);
//        PdfFont font = PdfFontFactory.createFont(FontProgramFactory.createFont("Helvetica"));
//        new Paragraph("");
//        for (int i = 1; i <= n; ++i) {
//            PdfCanvas over = new PdfCanvas(pdfDoc.getPage(i));
//            over.setFillColor(Color.CYAN);
//
//            PdfPageOrientation.pdfPageOrientation(pdfDoc, i);
//            Paragraph p;
//            Date date = new Date();
//            SimpleDateFormat ft = new SimpleDateFormat("MM.dd.yyyy'@'HH:mm:ss zzz");
//            System.out.println("Current Date: " + ft.format(date));
//            PdfExtGState gs1;
//            p = (new Paragraph(ft.format(date))).setFont(font).setFontSize(40.0F);
//            over.saveState();
//            gs1 = new PdfExtGState();
//            gs1.setFillOpacity(0.3F);
//            over.setExtGState(gs1);
//            if (PdfPageOrientation.landscape == 0) {
//                (new Canvas(over, pdfDoc, pdfDoc.getDefaultPageSize())).showTextAligned(p, 290.0F, 430.0F, 1, TextAlignment.CENTER, VerticalAlignment.MIDDLE, (float) Math.toRadians(60.0D));
//            } else {
//                (new Canvas(over, pdfDoc, pdfDoc.getDefaultPageSize())).showTextAligned(p, 430.0F, 290.0F, 1, TextAlignment.CENTER, VerticalAlignment.MIDDLE, (float) Math.toRadians(30.0D));
//            }
//            over.restoreState();
//        }
//        pdfDoc.close();
//
//        return DEST;
//    }
//}
