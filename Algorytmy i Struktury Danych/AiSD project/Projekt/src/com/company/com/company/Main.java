package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BST <String, String> Baza = new BST<>();
        Baza.miejsceDla("Grzesiek", "Kowalski");
        Baza.miejsceDla("Mariusz", "Wyszyński");
        Baza.miejsceDla("Dariusz","Ćwikliński");
        Baza.miejsceDla("Andrzej","Bober");
        Baza.miejsceDla("Paweł","Dudziński");

        Scanner podaj = new Scanner(System.in);
        System.out.println("Podaj imie:");
        String podaneimie = podaj.nextLine();
        System.out.println("Podaj nazwisko:");
        String podanenazwisko = podaj.nextLine();

        BST<String, String>.Wierzchołek obecny = Baza.czyWystępuje(podaneimie,podanenazwisko);
        if(obecny!=null)System.out.println(obecny.imie + " " + obecny.nazwisko + " jest obecny");
        if(obecny==null)System.out.println(podaneimie + " " + podanenazwisko +" jest nieobecny");
    }
}
