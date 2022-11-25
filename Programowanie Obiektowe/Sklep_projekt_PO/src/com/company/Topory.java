package com.company;

import java.util.ArrayList;

public class Topory extends Main{
    String typ = "Topory";
    String nazwa = "";
    int cena = 0;
    int szerokosc_ostrza = 0;
    int masa = 0;
    int dlugosc_trzonka = 0;

    static ArrayList<Topory> Toporki = new ArrayList<>();

    public Topory(String nazwa, int cena, int szerokosc_ostrza, int masa, int dlugosc_trzonka){
        this.nazwa = nazwa;
        this.cena = cena;
        this.szerokosc_ostrza = szerokosc_ostrza;
        this.masa = masa;
        this.dlugosc_trzonka = dlugosc_trzonka;
        Toporki.add(this);
    }

    @Override
    public String toString(){
        return "Typ: " + typ + "\nNazwa: " + nazwa + "\nCena: " + cena + "zl" + "\nSzerokosc ostrza: " + szerokosc_ostrza + "cm" + "\nMasa: " + masa + "kg" + "\nDlugosc trzonka: " + dlugosc_trzonka + "cm\n";
    }
}
