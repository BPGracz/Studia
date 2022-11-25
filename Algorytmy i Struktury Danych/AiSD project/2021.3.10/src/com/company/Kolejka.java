package com.company;

public class Kolejka<Element> {
    private int N=0;
    public class ObiektKolejki{
        Element element;
        ObiektKolejki następny;}
    ObiektKolejki pierwszy;
    ObiektKolejki ostatni;
    public void dodajDoKolejki (Element el) {
        Kolejka.ObiektKolejki staryOstatni = ostatni;
        ostatni = new Kolejka.ObiektKolejki(); //tworzenie nowego obiektu i umieszczenie go na końcu listy
        ostatni.element = el;
        ostatni.następny = null;
        if (jestPusta()) pierwszy=ostatni;
        else
            staryOstatni.następny=ostatni;
        N++; }

    public Element pobierzPierwszego() {
        if (jestPusta()) return null;
        Element el=pierwszy.element;
        pierwszy=pierwszy.następny;
        if (jestPusta()) ostatni = null;
        N--;
        return el;}
    public boolean jestPusta() {return N==0;}
    public int ileOczekujących(){return N;}
    public void drukuj() {
        ObiektKolejki pom;
        pom=pierwszy;
        int i=1;
        System.out.println("Elementów "+N+ " ======================");
        do{
            System.out.println(i + " " + pom.element);
            i++;
            pom = pom.następny; }
        while (pom != null) ;
        System.out.println("=================================");
    }

    public static void main(String[] args) {
        Kolejka<Osoba> kolejka = new Kolejka<Osoba>();
        kolejka.dodajDoKolejki(new Osoba("Zabłocki","Stefan","1999-10-12"));
        kolejka.dodajDoKolejki(new Osoba("Wiśniowski","Janusz","1999-10-12"));
        kolejka.dodajDoKolejki(new Osoba("Wiśniak","Stanisław","1999-10-12"));
        kolejka.dodajDoKolejki(new Osoba("Ćwikliński","Stanisław","1999-10-12"));
        kolejka.dodajDoKolejki(new Osoba("Biegała","Stanisław","1999-10-12"));
        kolejka.dodajDoKolejki(new Osoba("Domagalski","Kazimierz","1999-10-12"));
        kolejka.dodajDoKolejki(new Osoba("Adamski","Włodzimierz","1999-10-12"));
        kolejka.drukuj();

        Osoba pierwszy = kolejka.pobierzPierwszego();
        System.out.println(pierwszy.nazwisko);
        kolejka.drukuj();
    }
}



