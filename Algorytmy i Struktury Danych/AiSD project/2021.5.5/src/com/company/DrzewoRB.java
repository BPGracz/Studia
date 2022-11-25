package com.company;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class DrzewoRB<Klucz,Wartość> {

    class Wierzchołek {
        Klucz klucz;
        Wartość wartość;
        Wierzchołek lewyPotomek;
        Wierzchołek prawyPotomek;
        int N;

        boolean kolor;

        public Wierzchołek(Klucz a, Wartość b, int N,boolean kolor) {
            this.klucz = a;
            this.wartość = b;
            this.N = N;
            this.kolor = kolor;
        }

        public String toString() {
            return klucz.toString() + " " + wartość.toString() + " ";
        }

    }
    Comparator<Klucz> compS = new Comparator<Klucz>() {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));

        @Override
        public int compare(Klucz s1, Klucz s2) {
            if (s1.getClass().getName().endsWith("Integer"))
                return (int) Math.signum((int) s1 - (int) s2);
            return c.compare(s1, s2);
        }
    };

    static final boolean CZERWONY = true;
    static final boolean CZARNY = false;
    private Wierzchołek korzeń;

    public int rozmiar(Wierzchołek w) {
        if (w == null) return 0;
        else return w.N;
    }
    public Wierzchołek rotacjaLewa(Wierzchołek h){
        Wierzchołek x = h.prawyPotomek;
        h.prawyPotomek = x.lewyPotomek;
        x.lewyPotomek = h; x.N = h.N;
        x.kolor = h.kolor; h.kolor = CZERWONY;
        h.N=1+rozmiar(h.lewyPotomek)+rozmiar(h.prawyPotomek);
        return x;
    }

    public Wierzchołek rotacjaPrawa(Wierzchołek h){
        Wierzchołek x = h.lewyPotomek;
        h.lewyPotomek = x.prawyPotomek;
        x.prawyPotomek = h;
        x.kolor = h.kolor;
        h.kolor = CZERWONY;
        x.N = h.N;
        h.N=1+rozmiar(h.lewyPotomek)+rozmiar(h.prawyPotomek);
        return  x;
    }

    void zmieńKolory(Wierzchołek h){
        h.kolor=CZERWONY;
        h.lewyPotomek.kolor = CZARNY;
        h.prawyPotomek.kolor = CZARNY;
    }

    boolean jestCzerwony(Wierzchołek x){
        if(x==null) return false;
        return x.kolor==CZERWONY;
    }

    public void dodaj(Klucz klucz, Wartość wartość){
        korzeń=dodaj(korzeń, klucz, wartość);
        korzeń.kolor = CZARNY;
    }

    private Wierzchołek dodaj(Wierzchołek wierz, Klucz klucz, Wartość wartość) {
        if (wierz == null)
            return new Wierzchołek(klucz, wartość, 1, CZERWONY);
        int porównanie=compS.compare(klucz, wierz.klucz);
        if (porównanie<0) wierz.lewyPotomek=dodaj(wierz.lewyPotomek,klucz,wartość);
        else if (porównanie>0) wierz.prawyPotomek=dodaj(wierz.prawyPotomek,klucz,wartość);
        else wierz.wartość=wartość;
        if(jestCzerwony(wierz.prawyPotomek)&&!jestCzerwony(wierz.lewyPotomek)) wierz=rotacjaLewa(wierz);
        if(jestCzerwony(wierz.lewyPotomek)&&jestCzerwony(wierz.lewyPotomek.lewyPotomek)) wierz=rotacjaPrawa(wierz);
        if(jestCzerwony(wierz.prawyPotomek)&&jestCzerwony(wierz.lewyPotomek)) zmieńKolory(wierz);
        wierz.N=rozmiar(wierz.lewyPotomek) + rozmiar(wierz.prawyPotomek)+1;
        return wierz;
    }

    public static void main(String[] args) {
        DrzewoRB<String,String> drzewo = new DrzewoRB<>();
        drzewo.dodaj("Ala", "kot");
        drzewo.dodaj("Aleksandra", "pies");
        drzewo.dodaj("Gdynia", "1999");
        drzewo.dodaj("Gdańsk", "2010");
        drzewo.dodaj("Drezno", "2010-11-11");
        drzewo.dodaj("Gniezno", "2015-12-11");
        drzewo.dodaj("Grudziądz", "2017-11-11");
        drzewo.dodaj("Hrubieszów", "2017-01-21");
        drzewo.dodaj("Poznań", "2018-01-21");
        drzewo.dodaj("Przemyśl", "2008-01-21");
        drzewo.dodaj("Słupsk", "2010-10-12");
        drzewo.dodaj("Środa", "3");
        drzewo.dodaj("Zawada", "2011");
        drzewo.dodaj("Żabińska", "2011");
    }
}


