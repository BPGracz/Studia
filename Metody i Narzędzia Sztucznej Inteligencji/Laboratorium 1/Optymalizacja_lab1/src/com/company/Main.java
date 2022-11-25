package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random losowa = new Random();

    public static int getInt(){
     return new Scanner(System.in).nextInt();
    }

    // Funkcja dwóch zmiennych
    static int funkcja(int tab[]){
        int f = (-tab[0]^2)+(-tab[1]^2)+2;
        return f;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Podaj liczbe iteracji");
        int M = getInt();
        int x1 = losowa.nextInt(2+2)-2;
        int x2 = losowa.nextInt(2+2)-2;
        int X0[] = {x1, x2};
        int fmax = funkcja(X0);
        int Xmax[] = X0;
        for(int i=0; i<M; i++){
            int x3 = losowa.nextInt(2+2)-2;
            int x4 = losowa.nextInt(2+2)-2;
            int X[] = {x3, x4};

            if (funkcja(X) > fmax){
                fmax = funkcja(X);
                Xmax = X;
            }

            // Zapis do plików
            try {
                FileWriter best_step_write = new FileWriter("best_step.txt", true);
                //PrintWriter best_step_write = new PrintWriter("best_step.txt");
                //best_step_write.println(fmax);
                best_step_write.write(Integer.toString(fmax) + "\n");
                best_step_write.close();

                FileWriter current_write = new FileWriter("current.txt", true);
                //PrintWriter current_write = new PrintWriter("current.txt");
                for (int j=0; j<Xmax.length; j++) {
                    //current_write.println(Xmax[j]);
                    current_write.write(Integer.toString(Xmax[j]) + "\n");
                }
                current_write.close();
            }
            catch (IOException error) {
                File beststep = new File("best_step.txt");
                File current = new File("current.txt");

                beststep.createNewFile();
                FileWriter best_step_write = new FileWriter("best_step.txt", false);
                best_step_write.write(Integer.toString(fmax) + "\n");
                best_step_write.close();

                current.createNewFile();
                FileWriter current_write = new FileWriter("current.txt",false);
                for (int j=0; j<Xmax.length; j++) {
                    current_write.write(Integer.toString(Xmax[j]) + "\n");
                }
                current_write.close();
            }
        }



        // Wydruk wartości końcowych
        System.out.println("Wartość fmax: " + fmax);
        for (int i=0; i<Xmax.length;i++)
        System.out.println("Wartość Xmax: " + Xmax[i]);

    }

}
