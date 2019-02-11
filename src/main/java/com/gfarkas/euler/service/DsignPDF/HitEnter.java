package com.gfarkas.euler.service.DsignPDF;

import java.util.Scanner;

public class HitEnter {
    public HitEnter() {
    }

    public static void hitEnter() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
