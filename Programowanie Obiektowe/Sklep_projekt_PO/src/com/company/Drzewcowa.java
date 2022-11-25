package com.company;

import java.util.ArrayList;

public class Drzewcowa extends Main {
    String typ = "Drzewcowa";
    String nazwa = "";
    int cena = 0;
    int dlugosc_drzewca = 0;
    int dlugosc_szpikulca = 0;

    static ArrayList<Drzewcowa> Drzewcowe = new ArrayList<>();

    public Drzewcowa(String nazwa, int cena, int dlugosc_drzewca, int dlugosc_szpikulca){
        this.nazwa = nazwa;
        this.cena = cena;
        this.dlugosc_drzewca = dlugosc_drzewca;
        this.dlugosc_szpikulca = dlugosc_szpikulca;
        Drzewcowe.add(this);
    }

    @Override
    public String toString(){
        return "Typ: " + typ + "\nNazwa: " + nazwa + "\nCena: " + cena + "zl" + "\nDlugosc drzewca: " + dlugosc_drzewca + "cm" +"\nDlugosc szpikulca: " + dlugosc_szpikulca + "cm\n";
    }
}
