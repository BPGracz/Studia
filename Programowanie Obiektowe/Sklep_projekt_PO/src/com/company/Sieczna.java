package com.company;

import java.util.ArrayList;

public class Sieczna extends Main {
    String typ = "Sieczna";
    String nazwa = "";
    int cena = 0;
    int dlugosc_ostrza = 0;
    int masa = 0;
    int szerekosc_rekojesci = 0;

    static ArrayList<Sieczna> Sieczne = new ArrayList<>();

    public Sieczna(String nazwa, int cena, int dlugosc_ostrza, int masa, int szerekosc_rekojesci){
        this.nazwa = nazwa;
        this.cena = cena;
        this.dlugosc_ostrza = dlugosc_ostrza;
        this.masa = masa;
        this.szerekosc_rekojesci = szerekosc_rekojesci;
        Sieczne.add(this);
    }

    @Override
    public String toString(){
        return "Typ: " + typ + "\nNazwa: " + nazwa + "\nCena: " + cena + "zl" + "\nDługość ostrza: " + dlugosc_ostrza + "cm" + "\nMasa: " + masa + "kg" + "\nSzerokosc rekojesci: " + szerekosc_rekojesci + "cm\n";
    }
}
