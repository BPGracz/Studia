package com.company;

import java.util.ArrayList;

public class Miotajaca extends Main {
    String typ = "Miotajaca";
    String nazwa = "";
    int cena = 0;
    String material = "";
    int dlugosc_cieciwy = 0;

    static ArrayList<Miotajaca> Miotane = new ArrayList<>();

    public Miotajaca(String nazwa, int cena, String material, int dlugosc_cieciwy){
    this.nazwa = nazwa;
    this.cena = cena;
    this.material = material;
    this.dlugosc_cieciwy = dlugosc_cieciwy;
    Miotane.add(this);
    }

    @Override
    public String toString(){
    return "Typ: " + typ + "\nNazwa: " + nazwa + "\nCena: " + cena + "zł" + "\nMaterial: " + material + "\nDlugosc cieciwy: " + dlugosc_cieciwy + "cm\n";
    }
}
