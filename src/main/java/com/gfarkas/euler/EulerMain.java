package com.gfarkas.euler;

import com.gfarkas.euler.s3.services.S3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class EulerMain implements CommandLineRunner {

    @Autowired
    S3Services s3Services;

    @Value("${jsa.s3.uploadfile}")
    private String uploadFilePath;

    @Value("${jsa.s3.key}")
    private String downloadKey;

    public static void main(String[] args) {
        ApplicationContext ct = SpringApplication.run(EulerMain.class, args);

        String[] beanArray = ct.getBeanDefinitionNames();
        Arrays.sort(beanArray);  //sorting bean names
        for (String name : beanArray) {
            System.out.println(name);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------- START UPLOAD FILE ----------------");
        s3Services.uploadFile("Gabor_Farkas_CV.pdf", uploadFilePath);
        System.out.println("---------------- START DOWNLOAD FILE ----------------");
        s3Services.downloadFile(downloadKey);
    }

}

