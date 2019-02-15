package com.gfarkas.euler.service.DsignPDF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class Dsign {
    private ImageWatermark imageWatermark;
    private WatermarkPdf watermarkPdf;
    private PdfSigner pdfSigner;


    @Autowired
    public void setImageWatermark(ImageWatermark imageWatermark) {
        this.imageWatermark = imageWatermark;
    }

    @Autowired
    public void setWatermarkPdf(WatermarkPdf watermarkPdf) {
        this.watermarkPdf = watermarkPdf;
    }

    @Autowired
    public void setPdfSigner(PdfSigner pdfSigner) { this.pdfSigner = pdfSigner;    }

    public void dsign() throws Exception {
        File fileOrigPDF = new File("s3://gfarkaseuler/Gabor_Farkas_CV.pdf");
        File fileWatermarked1 = new File("s3://gfarkaseuler/watermarked1.pdf");
        File fileWatermarked2 = new File("s3://gfarkaseuler/watermarked2.pdf");
        File filePNGimage = new File("s3://gfarkaseuler/watermark.png");
        File filePFXsecurity = new File("s3://gfarkaseuler/fg.pfx");
        watermarkPdf.watermarkPdf(fileOrigPDF, fileWatermarked1);
        imageWatermark.imageWatermark(fileWatermarked1, fileWatermarked2, filePNGimage);
        pdfSigner.pdfSigner(fileWatermarked2, filePFXsecurity, "test");
    }

}
