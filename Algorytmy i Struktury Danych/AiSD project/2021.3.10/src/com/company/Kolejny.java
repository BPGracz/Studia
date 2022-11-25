package com.company;

public class Kolejny {
    static ObiektListy poczatek;
    static ObiektListy kolejny;
    static ObiektListy wczesniejszy;
    static ObiektListy koniec;

    public static void main(String[] args){
        wczesniejszy = kolejny;
        kolejny = new ObiektListy();
        poczatek = kolejny;
        kolejny.osoba = new Osoba("Kazimierz","Wiśniewski","1998-01-11");

        wczesniejszy = kolejny;
        kolejny.nastepny = new ObiektListy();
        kolejny = kolejny.nastepny;
        kolejny.osoba = new Osoba("Janusz","Wiśniak","1998-10-11");

        wczesniejszy = kolejny;
        kolejny.nastepny = new ObiektListy();
        kolejny = kolejny.nastepny;
        kolejny.osoba = new Osoba("Bartosz","Adamski","1998-10-11");

        wczesniejszy = kolejny;
        kolejny.nastepny = new ObiektListy();
        kolejny = kolejny.nastepny;
        kolejny.osoba = new Osoba("Zygmunt","Boruta","1998-05-24");

        kolejny.nastepny = null;

        koniec = kolejny;

        int ile = 0;
        kolejny = poczatek;

        do {
            ile++;
            System.out.print(kolejny.osoba + "\n");
            kolejny = kolejny.nastepny;
        }while(kolejny != null);

        kolejny = koniec;
        System.out.println("===========================================================================");

        do{
            ile++;
            System.out.print(kolejny.osoba + "\n");
            kolejny = kolejny.nastepny;
        }while(kolejny != null);

        System.out.println("Elementów na liscie jest: " + ile);

        kolejny = poczatek;
        kolejny.nastepny.nastepny.nastepny.osoba.nazwisko = "Zabłocki";
        System.out.println(koniec.osoba);
    }

    static class ObiektListy{
        Osoba osoba;
        ObiektListy nastepny;
        ObiektListy poprzedni;
    }
}
