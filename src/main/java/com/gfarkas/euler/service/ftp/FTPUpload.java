package com.gfarkas.euler.service.ftp;

import java.io.*;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FTPUpload {

    @Value("${server}")
    private String server;

    @Value("${port}")
    private int port;

    @Value("${user}")
    private String user;

    @Value("${pass}")
    private String pass;

    public void ftpUpload(PipedInputStream localStream) {


        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String firstRemoteFile = "euler/" + localStream;


            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, localStream);
            localStream.close();

            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }

//            // APPROACH #2: uploads second file using an OutputStream
//            File secondLocalFile = new File("C:/JAVA/firstspringboot/.gitignore");
//            String secondRemoteFile = "euler/.gitignore";
//            inputStream = new FileInputStream(secondLocalFile);
//
//            System.out.println("Start uploading second file");
//            OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
//            byte[] bytesIn = new byte[4096];
//            int read = 0;
//
//            while ((read = inputStream.read(bytesIn)) != -1) {
//                outputStream.write(bytesIn, 0, read);
//            }
//            inputStream.close();
//            outputStream.close();

            boolean completed = ftpClient.completePendingCommand();
            if (completed) {
                System.out.println("The second file is uploaded successfully.");
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            System.out.println("Connection error");
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
    }
}