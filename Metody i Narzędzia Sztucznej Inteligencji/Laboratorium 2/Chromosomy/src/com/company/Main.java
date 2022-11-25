package com.company;

import java.util.Random;

public class Main {

    static Random losowa = new Random();

    // Funkcja (x1,x2)
    static double funkcja(double x1, double x2){
        double f = -(Math.pow(x1,2))-(Math.pow(x2,2))+2;
        return f;
    }

    // Logarytm przy podstawie 2
    public static int log(int x){
        return (int) (Math.log(x) / Math.log(2));
    }

    // Najmniejsza liczba bitów porzebnych do zakodowania
    static double liczba_bitow(bi, ai, d){
        double mi = log((bi - ai)*Math.pow(10,d));
        return mi;
    }
    /*
    static int[] kodowanie(int mi){
        int binary[] = new int[(mi*2)];

        for (int i=0; i<mi*2;i++){
            binary[i] = losowa.nextInt(2);
        }
        return binary;
    }

    static int dekodowanie(int mi, int binary[], int pol){
        int dec[] = new int[mi];
        int value = 0;

        if (pol == 1)
            for (int i=0; i<mi; i++) {
                dec[i] = binary[i];
                if(dec[i]==1)
                    value += Math.pow(2,mi-i);
            }

        if (pol == 2)
            for (int i=0; i<mi; i++) {
                dec[i] = binary[i];
                if (dec[i]==1)
                    value += Math.pow(2,mi-i);
            }
        return value;
    }
     */

    public static void main(String[] args) {
        double x1, x2;

        /*
        int ai=-2, bi=2, d=5;
        double x1, x2, x1d = 0.0, x2d = 0.0;
        int binary[];
        //int mi = log((bi-ai)*Math.pow(10,d));
        int mi = (int) (Math.ceil(((Math.log(bi-ai)*Math.pow(10,d))))/Math.log(2));

        while (true){
            binary = kodowanie(mi);

            x1 = ai+dekodowanie(mi,binary,1)*((bi-ai)/(Math.pow(2,mi)-1));
            x2 = ai+dekodowanie(mi,binary,2)*((bi-ai)/(Math.pow(2,mi)-1));

            if(x1>=-2.0 && x1<2.0 && x2>=-2.0 && x2<=2.0) break;
        }
        double f=funkcja(x1,x2);
        System.out.println(x1d + " " + x2d);
        System.out.println(x1 + " " + x2);
        System.out.println(f);
         */
    }
}
