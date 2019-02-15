package com.gfarkas.euler.service.DsignPDF;

import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfSignatureAppearance;
import com.lowagie.text.pdf.PdfStamper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

@Component
public class PdfSigner {

    public void pdfSigner(File src, File pfx, String password) throws IOException {
        try {
            SSLContext ctx = SSLContext.getInstance("SSL");
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            KeyStore ks = KeyStore.getInstance("pkcs12");
            ks.load(new FileInputStream(pfx), password.toCharArray());
            kmf.init(ks, password.toCharArray());
            ctx.init(kmf.getKeyManagers(), (TrustManager[])null, (SecureRandom)null);
            String alias = (String)ks.aliases().nextElement();
            PrivateKey key = (PrivateKey)ks.getKey(alias, password.toCharArray());
            Certificate[] chain = ks.getCertificateChain(alias);
            PdfReader reader = new PdfReader(String.valueOf(src));
            FileOutputStream fout = new FileOutputStream("s3://gfarkaseuler/signed.pdf");
            PdfStamper stp = PdfStamper.createSignature(reader, fout, '\u0000', (File)null, true);
            PdfSignatureAppearance sap = stp.getSignatureAppearance();
            sap.setCrypto(key, chain, (CRL[])null, PdfSignatureAppearance.WINCER_SIGNED);
            sap.setLayer2Text("");
            sap.setLayer4Text("");
            String imagePath = "s3://gfarkaseuler/fg.pfx";
            File file = new File(imagePath);
            byte[] imageByte = new byte[(int)file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            Throwable var17 = null;

            try {
                fileInputStream.read(imageByte);
                Image var18 = Image.getInstance(imageByte);
            } catch (Throwable var27) {
                var17 = var27;
                throw var27;
            } finally {
                if (fileInputStream != null) {
                    if (var17 != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable var26) {
                            var17.addSuppressed(var26);
                        }
                    } else {
                        fileInputStream.close();
                    }
                }

            }

            sap.setVisibleSignature(new Rectangle(-70.0F, 840.0F, 500.0F, 805.0F), 1, "first");
            sap.setImage(Image.getInstance(imagePath));
            stp.close();
        } catch (Exception var29) {
            var29.printStackTrace();
        }

    }
}
