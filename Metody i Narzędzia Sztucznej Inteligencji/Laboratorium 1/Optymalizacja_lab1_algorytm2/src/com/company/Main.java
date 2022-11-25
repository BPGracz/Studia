package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random losowa = new Random();

    public static int getInt(){
        return new Scanner(System.in).nextInt();
    }

    // Funkcja dwóch zmiennych
    static double funkcja(double tab[]){
        double f = (Math.pow(-tab[0],2))+(Math.pow(-tab[1],2))+2;
        return f;
    }

    public static void main(String[] args) {

        System.out.println("Podaj liczbe iteracji");
        double T = losowa.nextInt(2)/10;

        double M = getInt();

        double Xt[] = new double[2];

        double x1 = losowa.nextInt(2+2)-2;
        double x2 = losowa.nextInt(2+2)-2;
        double X0[] = {x1, x2};
        double fmax = funkcja(X0);
        double Xmax[] = X0;
        for(double i=0; i<M; i++){
            if(i == 1){
                double Xk[] = X0;
                double w = losowa.nextInt(2);
                if(w == 1){
                    for (int j=0; j<Xt.length; j++) {
                        double y = losowa.nextInt(2)/10;
                        Xt[j] = Xk[j] + y;
                    }
                }
                else{
                    for (int j=0; j<Xt.length; j++) {
                        double y = losowa.nextInt(2)/10;
                        Xt[j] = Xk[j] - y;
                    }
                }
                if (funkcja(Xt) > fmax){
                    fmax = funkcja(Xt);
                    Xmax = Xt;
                    Xk = Xt;
                }
                else{
                    double Z = losowa.nextInt(2);
                    System.out.println(T);
                    if (Z < Math.exp(-((funkcja(Xt)-funkcja(Xk))/T))){
                        fmax = funkcja(Xt);
                        Xmax = Xt;
                        Xk = Xt;
                    }
                }
            }
        }

        // Wydruk wartości końcowych
        System.out.println("Wartość fmax: " + fmax);
        for (int i=0; i<Xmax.length;i++)
            System.out.println("Wartość Xmax: " + Xmax[i]);
    }
}
