package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Random;

public class Main {

    static Random losowa = new Random();

    // funkcja (x1,x2)
    static double funkcja(double x1, double x2){
        double f = (x1*x1)-(x2*x2)+2;
        return f;
    }

    static int[] kodowanie(){
        int binary[] = new int[38];

        for (int i=0; i<38; i++){
            binary[i] = losowa.nextInt(2);
        }
        return binary;
    }

    static int krzyzowanie_jednopunktowe(int A[], int B[]) {
        int zamiana = 0;
        int punkt = losowa.nextInt(36)+1;
        for (int i=0; i<A.length; i++) {
            if (i>=punkt) {
                zamiana = A[i];
                A[i] = B[i];
                B[i] = zamiana;
            }
        }
        return zamiana;
    }

    /*
    static int krzyzowanie_wielopunktowe(int A[], int B[]) {

        int zamiana = 0;
        int punktA = losowa.nextInt(36)+1;
        int punktB = losowa.nextInt(36)+1;

        // Określanie przedziału
        while (true){
            if(punktA < punktB) {
                int mniejsza = 0;
                int wieksza = 0;
                mniejsza = punktA;
                wieksza = punktB;
                break;
            } else if (punktB < punktA) {
                int mniejsza = 0;
                int wieksza = 0;
                mniejsza = punktB;
                wieksza = punktA;
                break;
            } else {
                punktA = losowa.nextInt(36)+1;
                punktB = losowa.nextInt(36)+1;
                continue;
            }
            return mniejsza, wieksza;
        }

        for (int i=0; i<A.length; i++) {
            if (i > mniejsza && i < wieksza) {
                zamiana = A[i];
                A[i] = B[i];
                B[i] = zamiana;
            }
        }
        return zamiana;
    }
    */

    public static void main(String[] args) {

        int A[] = kodowanie();
        int B[] = kodowanie();
        System.out.println("Ciąg A: ");
        for (int i=0; i<A.length; i++) {
            System.out.print(A[i]);
        }
        System.out.println("\nCiąg B: ");
        for (int i=0; i<B.length; i++) {
            System.out.print(B[i]);
        }

        krzyzowanie_jednopunktowe(A,B);

        System.out.println("\nCiąg A: ");
        for (int i=0; i<A.length; i++) {
            System.out.print(A[i]);
        }
        System.out.println("\nCiąg B: ");
        for (int i=0; i<B.length; i++) {
            System.out.print(B[i]);
        }





    }
}
