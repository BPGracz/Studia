package com.company;

public class KlasaOsoba {
    static ObiektListy poczatek;
    static ObiektListy kolejny;
    static ObiektListy koniec;
    static ObiektListy wczesniejszy;

    static String[][] dane=new String[][]{
            {"Janusz","Zieliński","1998-01-11"},
            {"Jan","Nowicki","2003-11-22"},
            {"Iwan","Branicki","2001-02-17"},
            {"Tadeusz","Nowicki","2000-07-21"},
            {"Jan","Nowacki","2000-01-11"},
            {"Jan","Adamski","2000-03-25"}};

    public static void main(String[] args) {

        kolejny = new ObiektListy();
        kolejny.poprzedni = null;
        kolejny.osoba = new Osoba("Janusz","Zieliński","1998-01-11");
        poczatek = kolejny;

        for (int i = 1; i < dane.length; i++) {
            wczesniejszy = kolejny;
            kolejny.nastepny = new ObiektListy();
            kolejny = kolejny.nastepny;
            kolejny.poprzedni = wczesniejszy;
            kolejny.osoba = new Osoba(dane[i][0], dane[i][1], dane[i][2]);
        }
        koniec = kolejny;
        kolejny.nastepny = null;

        kolejny = poczatek;

        int ile = 0;

        do {
            ile++;
            System.out.println(kolejny.osoba);
            kolejny = kolejny.nastepny;
        }while(kolejny != null);

        System.out.println("---------------------------------------");

        kolejny = koniec;
        do {
            ile++;
            System.out.println(kolejny.osoba);
            kolejny = kolejny.poprzedni;
        }while(kolejny != null);
    }
    static class ObiektListy{
        Osoba osoba;
        ObiektListy nastepny;
        ObiektListy poprzedni;
    }
}
