package com.gfarkas.euler.service.DsignPDF;

public class NrOElementsInArray {
    public NrOElementsInArray() {
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int count = 0;
        int i = 0;

        try {
            while(a[i] != 97) {
                ++count;
                ++i;
            }
        } catch (Exception var6) {
            System.out.println("Number of elements in array:" + count);
        }

        int n = a.length;
        System.out.println("Number of elements(Using inbuilt method named length):" + n);
    }
}
