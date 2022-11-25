package com.company;

public class Lista<Element> {
    ObiektListy ostatni;
    ObiektListy pierwszy;
    int N=0;
    public static void main(String[] args){
        Lista<Osoba> lista = new Lista<Osoba>();
        lista.dodajDoListy(new Osoba());
        lista.dodajDoListy(new Osoba("Kazimierz","Wiśniewski", "1998-01-11"));
        lista.dodajDoListy(new Osoba("Zygmunt","Boruta", "1999-05-24"));
        lista.dodajDoListy(new Osoba("Kacper","Boruta", "1999-05-24"));
        lista.dodajDoListy(new Osoba("Zygmunt","Boruta", "1999-05-24"));
        lista.dodajDoListy(new Osoba("Zygmunt","Boruta", "1999-05-24"));

        System.out.println(lista.N);
        lista.drukuj();
        System.out.println(((Osoba)(lista.pierwszy.nastepny.nastepny.osoba)).nazwisko);
        System.out.println(lista.pierwszy.nastepny.nastepny.osoba.nazwisko);

        System.out.println();
        Lista.ObiektListy nowy = lista.pobierzItego(2);
        ((Osoba) nowy.osoba).nazwisko = "Ćwikliński";
        lista.drukuj();
        System.out.println();
        lista.zamien(1,2);
        lista.drukuj();

        System.out.println();
        lista.usuńItego(3);
        lista.drukuj();

    }
    public void dodajDoListy(Element el) {
        ObiektListy staryOstatni = ostatni;
        ostatni = new ObiektListy();
        ostatni.osoba = el;
        ostatni.nastepny = null;
        if (jestPusta()) pierwszy=ostatni;
        else
            staryOstatni.nastepny=ostatni;
        N++;
    }
    public boolean jestPusta() {
        return N==0;

    }
    class ObiektListy{
        Element osoba;
        ObiektListy nastepny;
        ObiektListy poprzedni;
    }

    public void drukuj(){
        ObiektListy kolejny = pierwszy;
        do {
            System.out.println(kolejny.osoba);
            kolejny = kolejny.nastepny;
        }
        while(kolejny!=null);

    }

    public Element pobierzPierwszego() {
        if (jestPusta()) return null;
        Element el=pierwszy.osoba;
        pierwszy=pierwszy.nastepny;
        if (jestPusta()) ostatni = null;
        N--;
        return el;}

    public ObiektListy pobierzItego(int ity) {
        if (jestPusta()) return null;
        ObiektListy zwracany=pierwszy;
        for(int i=0; i<N; i++){
            if (i==ity) return zwracany;
            zwracany = zwracany.nastepny;
        }
        return null;
    }

    public boolean zamien(int i, int j){
        if(i>N || j>N)return false;
        ObiektListy pierwszyit = pobierzItego(i);
        ObiektListy pierwszyjt = pobierzItego(j);
        Element pomocniczy = pierwszyit.osoba;
        pierwszyit.osoba = pierwszyjt.osoba;
        pierwszyjt.osoba = pomocniczy;
        return true;
    }

    public ObiektListy usuńItego(int ity) {
        if (jestPusta()) return null;
        ObiektListy poprzedni = pierwszy;
        ObiektListy usuwany = pierwszy;
        for (int i=0; i<N; i++){
            if (i==ity) {
                poprzedni.nastepny = usuwany.nastepny;
                if (i==0) pierwszy=usuwany.nastepny;
                else if (i==N-1) ostatni=poprzedni;
                N--;
                return usuwany;}
            poprzedni=usuwany;
            usuwany=usuwany.nastepny;}
        return null;
            }
        }

