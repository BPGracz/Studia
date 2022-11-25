package com.company;

import java.text.CollationKey;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class Nazwiska
{
    static String[] lista3 = new String[]{"","Żbikowski","Milewska","Czarnecki","Wikliński","Sobieraj","Ćwikliński","Zawadzki"};
    static String[] ListaNazwisk = new String[]{"","Kowalski","Frąckowiak","Sobolewski","Tochowicz","Grzybek"};
    static Collator collator = Collator.getInstance(new Locale("pl","PL"));

    public static void main(String[] args)
    {
        System.out.println(collator.compare(lista3[1],lista3[2]));
        System.out.println(collator.compare("Żabinska","Żreda"));
// Kopiec 1
        System.out.println("jest kopcem " + czyJestKopcem(lista3));
        wypiszElementyListy(lista3);
        wynurzanie(lista3, 7);
        System.out.println("jest kopcem " + czyJestKopcem(lista3));
        wypiszElementyListy(lista3);
// Kopiec 2
        sortowanie(ListaNazwisk);
        System.out.println("jest kopcem " + czyJestKopcem(lista3));
        wypiszElementyListy(ListaNazwisk);
    }
    public static boolean czyJestKopcem(String[] abc) {
        int dlugosc=abc.length;
        boolean jestKopcem = true;
        for(int k=1; k<abc.length;k++) {
            if(2*k>=dlugosc) return true;
            jestKopcem= collator.compare(abc[k], abc[2*k]) > -1;
            if(2*k+1>=dlugosc) return jestKopcem;
            jestKopcem=jestKopcem && collator.compare(abc[k], abc[2*k+1]) > -1;
            if (!jestKopcem) return false;}
        return true;
    }
    public static void zanurzanie(String[] lista, int k)
    { int N=lista.length-1;
        int j;
        while(2*k<=N) {
            j = 2*k;
            if(j<N && collator.compare(lista[j],lista[j+1]) <0) j++;
            if(collator.compare(lista[k],lista[j])>-1) break;
            String pom=lista[k];
            lista[k]=lista[j];
            lista[j]=pom;
            k=j;}
    }
    public static void wypiszElementyListy(String[] lista)
    {
        for(int i=1;i < lista.length; i++){
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }
    public static void zanurzanie(String[] lista, int k, int N)
    {
        int j;
        while (2 * k <= N) {
            j = 2 * k;
            if (j < N && collator.compare(lista[j], lista[j + 1]) < 0) j++;
            if (collator.compare(lista[k], lista[j]) > -1) break;
            String pom = lista[k];
            lista[k] = lista[j];
            lista[j] = pom;
            k = j;
        }
    }
    public static void sortowanie(String[] abc) {
        int N = abc.length - 1;
        for (int k = N / 2; k >= 1; k--) zanurzanie(abc, k);
        while (N > 1) {
            String pom = abc[1];
            abc[1] = abc[N];
            abc[N--] = pom;
            zanurzanie(abc, 1, N);
        }
    }
    public static void wynurzanie(String[] lista, int k)
    {
        String pom;
        while(k>1 && collator.compare(lista[k/2],lista[k]) == -1) {
            pom=lista[k];
            lista[k]=lista[k/2];
            lista[k/2]=pom;
            k=k/2;}
    }

}
