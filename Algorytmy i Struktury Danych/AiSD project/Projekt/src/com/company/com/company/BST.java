package com.company;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class BST <K1, K2> {

    public Wierzchołek korzeń;

    class Wierzchołek {
        K1 imie;
        K2 nazwisko;
        Wierzchołek lewyPotomek;
        Wierzchołek prawyPotomek;
        int rozmiarP;
        public Wierzchołek (K1 a, K2 b, int N) {
            this.imie = a;
            this.nazwisko = b;
            this.rozmiarP = N;
        }
        public String toString() { return imie.toString()+ " "+ nazwisko.toString()+ " "; }
    }
    public Wierzchołek miejsceDla (K1 imie, K2 nazwisko) {

        String kierunek = "";

        Wierzchołek w = korzeń, wP = null;


        while (w != null) {
            wP = w;
            int porównanie = compS.compare(imie, w.imie);
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
        if (korzeń == null) korzeń = new Wierzchołek(imie, nazwisko, 1);
        else {
            if (kierunek.equals("lewy"))
                wP.lewyPotomek = new Wierzchołek(imie, nazwisko, 1);
            if (kierunek.equals("prawy"))
                wP.prawyPotomek = new Wierzchołek(imie, nazwisko, 1);
            if (kierunek.equals("trafiony"))
                wP.nazwisko = nazwisko;
        }
        return wP;
    }

    Comparator<K1> compS = new Comparator<K1>() {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));


        @Override
        public int compare(K1 s1, K1 s2) {
            if (s1.getClass().getName().endsWith("Integer"))
                return (int) Math.signum((int) s1 - (int) s2);
            return c.compare(s1, s2);
        }
    };

    Comparator<K2> compN = new Comparator<K2>() {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));


        @Override
        public int compare(K2 s1, K2 s2) {
            if (s1.getClass().getName().endsWith("Integer"))
                return (int) Math.signum((int) s1 - (int) s2);
            return c.compare(s1, s2);
        }
    };

    public Wierzchołek czyWystępuje(K1 imie, K2 nazwisko){
        Wierzchołek w=korzeń;
        while(w!=null){
            int porównanie=compS.compare(imie,w.imie);
            int porównanien=compN.compare(nazwisko,w.nazwisko);
            if (porównanie<0 || porównanien<0) w=w.lewyPotomek;
            else if (porównanie>0 || porównanien>0) w=w.prawyPotomek;
            else return w;
        }
        return null;}

}
