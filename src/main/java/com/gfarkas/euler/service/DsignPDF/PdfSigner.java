//package com.gfarkas.euler.service.DsignPDF;
//
//import com.lowagie.text.Image;
//import com.lowagie.text.Rectangle;
//import com.lowagie.text.pdf.PdfReader;
//import com.lowagie.text.pdf.PdfSignatureAppearance;
//import com.lowagie.text.pdf.PdfStamper;
//import org.springframework.stereotype.Component;
//
//import java.io.*;
//import java.security.KeyStore;
//import java.security.PrivateKey;
//import java.security.SecureRandom;
//import java.security.cert.CRL;
//import java.security.cert.Certificate;
//import javax.net.ssl.KeyManagerFactory;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//
//@Component
//public class PdfSigner {
//
//    public static void pdfSigner(InputStream src, OutputStream dest, InputStream pfx, String password) throws IOException {
//        try {
//            SSLContext ctx = SSLContext.getInstance("SSL");
//            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
//            KeyStore ks = KeyStore.getInstance("pkcs12");
//            ks.load(pfx, password.toCharArray());
//            kmf.init(ks, password.toCharArray());
//            ctx.init(kmf.getKeyManagers(), (TrustManager[])null, (SecureRandom)null);
//            String alias = (String)ks.aliases().nextElement();
//            PrivateKey key = (PrivateKey)ks.getKey(alias, password.toCharArray());
//            Certificate[] chain = ks.getCertificateChain(alias);
//            PdfReader reader = new PdfReader(src);
//            FileOutputStream fout = new FileOutputStream(String.valueOf(dest));
//            PdfStamper stp = PdfStamper.createSignature(reader, fout, '\u0000', (File)null, true);
//            PdfSignatureAppearance sap = stp.getSignatureAppearance();
//            sap.setCrypto(key, chain, (CRL[])null, PdfSignatureAppearance.WINCER_SIGNED);
//            sap.setLayer2Text("");
//            sap.setLayer4Text("");
//            String imagePath = "C:/PdfWaterMarker/watermark2.png";
//            File file = new File(imagePath);
//            byte[] imageByte = new byte[(int)file.length()];
//            FileInputStream fileInputStream = new FileInputStream(file);
//
//
//            sap.setVisibleSignature(new Rectangle(500, 100, 200, 200), 1, "first");
//            sap.setImage(Image.getInstance(imagePath));
//            stp.close();
//        } catch (Exception var29) {
//            var29.printStackTrace();
//        }
//
//    }
//}
