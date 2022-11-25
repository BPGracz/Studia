package com.company;

import java.util.ArrayList;

public class Palna extends Main {
    String typ = "Palna";
    String nazwa = "";
    int cena = 0;
    int dlugosc = 0;
    int dlugosc_lufy = 0;
    int masa = 0;
    int kaliber = 0;

    static ArrayList<Palna> Palne = new ArrayList<>();

    public Palna(String nazwa, int cena, int dlugosc, int dlugosc_lufy, int masa, int kaliber){
        this.nazwa = nazwa;
        this.cena = cena;
        this.dlugosc = dlugosc;
        this.dlugosc_lufy = dlugosc_lufy;
        this.masa = masa;
        this.kaliber = kaliber;
        Palne.add(this);
    }

    @Override
    public String toString(){
        return "Typ: " + typ + "\nNazwa: " + nazwa + "\nCena: " + cena + "zl" + "\nDlugosc: " + dlugosc + "mm" + "\nDlugosc lufy: " + dlugosc_lufy + "mm" + "\nMasa: " + masa + "kg" + "\nKaliber: " + kaliber + "mm\n";
    }
}
