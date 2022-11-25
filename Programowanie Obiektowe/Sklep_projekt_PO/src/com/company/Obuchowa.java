package com.company;

import java.util.ArrayList;

public class Obuchowa extends Main {
    String typ = "Obuchowa";
    String nazwa = "";
    int cena = 0;
    int dlugosc_trzonka = 0;
    int masa = 0;

    static ArrayList<Obuchowa> Obuchowe = new ArrayList<>();

    public Obuchowa(String nazwa, int cena, int dlugosc_trzonka, int masa){
        this.nazwa = nazwa;
        this.cena = cena;
        this.dlugosc_trzonka = dlugosc_trzonka;
        this.masa = masa;
        Obuchowe.add(this);
    }

    @Override
    public String toString(){
        return "Typ: " + typ + "\nNazwa: " + nazwa + "\nCena: " + cena + "zl" + "\nDlugosc trzonka: " + dlugosc_trzonka + "cm" +"\nMasa: " + masa + "kg\n";
    }
}
