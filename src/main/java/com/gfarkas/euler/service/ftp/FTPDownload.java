package com.gfarkas.euler.service.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class FTPDownload {

    @Value("${server}")
    private String server;

    @Value("${port}")
    private int port;

    @Value("${user}")
    private String user;

    @Value("${pass}")
    private String pass;

    private InputStream inputStream;

    public InputStream ftpDownload(String remoteFile) {


        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: using retrieveFile(String, OutputStream)


            String remoteFile1 = "euler/cv/" + remoteFile;

            inputStream = ftpClient.retrieveFileStream(remoteFile1);

            //boolean success = ftpClient.retrieveFile(remoteFile1, outputStream);

//            if (success) {
//                System.out.println("File #1 has been downloaded successfully.");
//            }

//            // APPROACH #2: using InputStream retrieveFileStream(String)
//            String remoteFile2 = "/public/favicon.ico";
//            File downloadFile2 = new File("C:/temp/favicon.ico");
//            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
//            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
//            byte[] bytesArray = new byte[4096];
//            int bytesRead = -1;
//            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
//                outputStream2.write(bytesArray, 0, bytesRead);
//            }
//
//            success = ftpClient.completePendingCommand();
//            if (success) {
//                System.out.println("File #2 has been downloaded successfully.");
//            }
//            outputStream2.close();
//            inputStream.close();

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return inputStream;
    }
}