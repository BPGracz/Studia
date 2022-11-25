package com.company;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class BST <K1, K2> {

    public Wierzchołek korzeń;

    class Wierzchołek {
        K1 klucz;
        K2 wartość;
        Wierzchołek lewyPotomek;
        Wierzchołek prawyPotomek;
        int rozmiarP;
        public Wierzchołek (K1 a, K2 b, int N) {
            this.klucz = a;
            this.wartość = b;
            this.rozmiarP = N;
        }
        public String toString(){
            return klucz.toString()+ " "+ wartość.toString()+ " ";
        }
    }

    public Wierzchołek miejsceDla (K1 klucz, K2 wartość) {

        String kierunek = "";

        Wierzchołek w = korzeń, wP = null;


        while (w != null) {
            wP = w;
            int porównanie = compS.compare(klucz, w.klucz);
            if (porównanie < 0) {
                kierunek = "lewy";
                w = w.lewyPotomek;
            }
            else if (porównanie > 0) {
                kierunek = "prawy";
                w = w.prawyPotomek;
            }
            else {
                kierunek = "trafiony";
                break;
            }
        }
        if (korzeń == null) korzeń = new Wierzchołek(klucz, wartość, 1);
        else {
            if (kierunek.equals("lewy"))
                wP.lewyPotomek = new Wierzchołek(klucz, wartość, 1);
            if (kierunek.equals("prawy"))
                wP.prawyPotomek = new Wierzchołek(klucz, wartość, 1);
            if (kierunek.equals("trafiony"))
                wP.wartość = wartość;
        }
        return wP;
    }

    public Wierzchołek czyWystępuje(K1 klucz){
        Wierzchołek w=korzeń;
        while(w!=null){
            int porównanie=compS.compare(klucz,w.klucz);
            if (porównanie<0) w=w.lewyPotomek;
            else if (porównanie>0) w=w.prawyPotomek;
            else return w;
        }
        return null;}

    Comparator <K1> compS = new Comparator<K1>() {
        Collator c= Collator.getInstance(new Locale("pl", "PL"));
        @Override
        public int compare(K1 s1, K1 s2) {
            if (s1.getClass().getName().endsWith("Integer"))
                return (int)Math.signum((int)s1-(int)s2);
            return c.compare(s1, s2);
        }
    };
    public K1 znajdźMinKlucz(){
        Wierzchołek w = korzeń;
        while(w.lewyPotomek!=null) w=w.lewyPotomek;
        return w.klucz;
    }
    public K1 znajdźMaxKlucz(){
        Wierzchołek w = korzeń;
        while(w.prawyPotomek!=null) w=w.prawyPotomek;
        return w.klucz;
    }

    ArrayList<Wierzchołek> kolejka = new ArrayList<>();

    public void przeszukajZakres(Wierzchołek x, K1 dolny, K1 górny) {
        if (x==null) {//System.out.println("\n*** powrót - pusty");
            return;}
        //System.out.println("========= "+x.klucz+" ====== ");
        int dZDanym=compS.compare(dolny, x.klucz);
        int gZDanym=compS.compare(górny, x.klucz);
        if(dZDanym==-1) {
            /*if(x.lewyPotomek!=null) System.out.println("*** w lewo "+x.klucz+" "+x.lewyPotomek.klucz);
            else System.out.println("*** w lewo "+x.klucz+" null");*/
            przeszukajZakres(x.lewyPotomek,dolny, górny);}
        // System.out.println("zdjęto ze stosu "+x.klucz);
        if(dZDanym<=0 && gZDanym>=0) kolejka.add(x);
        if(gZDanym==1) {
            /*if(x.prawyPotomek!=null) System.out.println("*** w prawo "+x.klucz+" "+x.prawyPotomek.klucz);
            else System.out.println("*** w prawo "+x.klucz+" null"); */
            przeszukajZakres(x.prawyPotomek,dolny, górny);}
    }
    public int zwróćPoziom(K1 klucz){
        int poziom=0;
        Wierzchołek w=korzeń;
        while(w!=null){
            poziom++;

            int porównanie=compS.compare(klucz, w.klucz);
            if(porównanie<0) w=w.lewyPotomek;
            else if(porównanie>0) w=w.prawyPotomek;
            else return poziom;}
        return -1;}

    public int wysokośćDrzewa(K1[] klucze)
    {
        int wysokość = 0;
        int poziomKlucza = 0;
        for(K1 klucz: klucze) {
            poziomKlucza = zwróćPoziom(klucz);
            if(wysokość<poziomKlucza)
                wysokość = poziomKlucza;
        }
        return wysokość;
    }
}