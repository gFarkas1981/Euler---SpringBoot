package com.gfarkas.euler.service.DsignPDF;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class ImageWatermark {

    public void imageWatermark(File src, File dest, File watermark) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(String.valueOf(src));
        int n = reader.getNumberOfPages();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.setRotateContents(false);
        Font f = new Font(FontFamily.HELVETICA, 30.0F);
        Phrase p = new Phrase("", f);
        Image img = Image.getInstance(String.valueOf(watermark));
        float w = img.getScaledWidth();
        float h = img.getScaledHeight();
        PdfGState gs1 = new PdfGState();
        gs1.setFillOpacity(0.5F);

        for(int i = 1; i <= n; ++i) {
            Rectangle pagesize = reader.getPageSize(i);
            float x = (pagesize.getLeft() + pagesize.getRight()) / 2.0F;
            float y = (pagesize.getTop() + pagesize.getBottom()) / 2.0F;
            PdfContentByte over = stamper.getOverContent(i);
            over.saveState();
            over.setGState(gs1);
            if (i % 2 == 1) {
                ColumnText.showTextAligned(over, 1, p, x, y, 0.0F);
            } else {
                over.addImage(img, w, 0.0F, 0.0F, h, x - w / 2.0F, y - h / 2.0F);
            }

            over.restoreState();
        }

        stamper.close();
        reader.close();
    }
}
