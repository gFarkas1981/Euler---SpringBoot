package com.gfarkas.euler.service.DsignPDF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class Dsign {

//    private WatermarkPdf watermarkPdf;
//    private PdfSigner pdfSigner;
    //    private FTPDownload ftpDownload;
//    private FTPUpload ftpUpload;
    private OutputStream os = new OutputStream() {
        @Override
        public void write(int b) throws IOException {

        }
    };


//    @Autowired
//    public void setWatermarkPdf(WatermarkPdf watermarkPdf) {
//        this.watermarkPdf = watermarkPdf;
//    }

//    @Autowired
//    public void setPdfSigner(PdfSigner pdfSigner) {
//        this.pdfSigner = pdfSigner;
//    }

//    @Autowired
//    public void setFtpDownload(FTPDownload ftpDownload) {
//        this.ftpDownload = ftpDownload;
//    }
//
//    @Autowired
//    public void setFtpUpload(FTPUpload ftpUpload) {
//        this.ftpUpload = ftpUpload;
//    }

    public void dsign() throws Exception {

//        InputStream inputStream = ftpDownload.ftpDownload("gfcv.pdf");
//
//        PipedOutputStream pos = watermarkPdf.watermarkPdf(inputStream);
//        PipedInputStream pis = new PipedInputStream(pos);
//
//        ftpUpload.ftpUpload(pis);
//        is.close();
//        s3.putObject(new PutObjectRequest("gfarkaseuler", "watermarked1.pdf", new File(String.valueOf(os))));
//        S3Object watermarkedPDF = s3.getObject(new GetObjectRequest("gfarkaseuler", "watermarked1.pdf"));
//        InputStream wmPdfIs = watermarkedPDF.getObjectContent();
//        S3Object PFXObject = s3.getObject(new GetObjectRequest("gfarkaseuler", PFXKey));
//        InputStream PFXIs = PFXObject.getObjectContent();

//        PdfSigner.pdfSigner(wmPdfIs, os, PFXIs, "test");
//        s3.putObject(new PutObjectRequest("gfarkaseuler", "signed.pdf", new File(String.valueOf(os))));
    }


}
