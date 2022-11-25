package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void Menu(){
        System.out.println("Witaj w sklepie");
        System.out.println("Co chcesz zrobic?");
        System.out.println("Jesli chcesz zobaczyc wystawe wpisz 1");
        System.out.println("Jesli chcesz coś porównać wpisz 2");
        System.out.println("Jesli chcesz coś kupić wpisz 3");
        System.out.println("Jesli chcesz oposcic sklep wpisz 4");
        System.out.print("Twoja decyzja: ");

    }

    public static void Kategorie(){
        System.out.println("Kategorie:");
        System.out.println("Bron dystansowa:");
        System.out.println("1.Miotajace   2.Palne");
        System.out.println("Bron biala:");
        System.out.println("3.Obuchowe   4.Sieczne\n5.Drzewcowe  6.Toporki");
        System.out.print("Wybierz kategorie: ");
    }

    public static void Porownaj(Object a, Object b){
        String A = a.getClass().getName();
        String B = b.getClass().getName();
        if(A.equals(B)){
            a.toString();
            b.toString();
        }
        else{
            System.out.println("Nie mozna porownac ze soba dwoch roznych typow broni");
        }
    }

    static ArrayList<String> Zamowienie = new ArrayList<>();
    public static void Dodaj(String zakup){
        Zamowienie.add(zakup);
    }

    public static void Zakupy(){
        for (String Z:Zamowienie) {
            System.out.println(Z);
        }
    }

    public static void Wystawa(int i) {
        switch (i) {
            case 1:
                System.out.println("Na wystawie:");
                System.out.println("Miotane:");
                for (Miotajaca M : Miotajaca.Miotane) {
                    System.out.println(M.toString());
                }
                break;
            case 2:
                System.out.println("Na wystawie:");
                System.out.println("Palne:");
                for (Palna P : Palna.Palne) {
                    System.out.println(P.toString());
                }
                break;
            case 3:
                System.out.println("Na wystawie:");
                System.out.println("Obuchowe:");
                for (Obuchowa O : Obuchowa.Obuchowe) {
                    System.out.println(O.toString());
                }
                break;
            case 4:
                System.out.println("Na wystawie:");
                System.out.println("Sieczne:");
                for (Sieczna S : Sieczna.Sieczne) {
                    System.out.println(S.toString());
                }
                break;
            case 5:
                System.out.println("Na wystawie:");
                System.out.println("Drzewcowe:");
                for (Drzewcowa D : Drzewcowa.Drzewcowe) {
                    System.out.println(D.toString());
                }
                break;
            case 6:
                System.out.println("Na wystawie:");
                System.out.println("Toporki:");
                for (Topory T : Topory.Toporki) {
                    System.out.println(T.toString());
                }
                break;
        }
    }



    public static void main(String[] args) {

        Miotajaca Ciezka_kusza = new Miotajaca("Ciezka kusza" , 1000 , "Dąb" , 120);
        Miotajaca Kusza = new Miotajaca("Kusza", 800, "Buk", 100);
        Miotajaca Krotki_luk = new Miotajaca("Krotki luk", 300, "Klon", 30);
        Miotajaca Luk_mysliwski = new Miotajaca("Luk mysliwski", 500, "Lipa", 60);
        Miotajaca Luk_wojenny = new Miotajaca("Luk wojenny", 900, "Cis", 80);
        Palna Karabin_M16 = new Palna("Karabin M16",1500, 1000, 500, 3, 556);
        Palna Karabin_M65 = new Palna("Karabin M65", 3000, 1100, 560, 10, 762);
        Obuchowa Laga = new Obuchowa("Laga", 10,50, 2);
        Obuchowa Morgensztern = new Obuchowa("Morgensztern", 400, 55,4);
        Obuchowa Lomotacz = new Obuchowa("Lotomacz", 600, 60, 6);
        Sieczna Miecz = new Sieczna("Miecz", 400, 40,2,10);
        Sieczna Miecz_dwureczny = new Sieczna("Miecz dworeczny",800,100,6,15);
        Drzewcowa Pika_bojowa = new Drzewcowa("Pika bojowa", 200,200,0);
        Drzewcowa Halabarda_krotka = new Drzewcowa("Halabarda krotka", 500, 130, 30);
        Drzewcowa Halabarda = new Drzewcowa("Halabarda", 800,150,50);
        Topory Topor = new Topory("Topor", 600,50,5,100);
        Topory Wielki_Topor = new Topory("Wielki Topor", 1200,80,8,140);

        Scanner wpisz = new Scanner(System.in);
        Integer odpowiedz = 0;
        while (odpowiedz != 4) {
            Menu();
            try {
                odpowiedz = Integer.parseInt(wpisz.nextLine());
                switch (odpowiedz) {
                    case 1:
                        Kategorie();
                        Integer kategoria = Integer.parseInt(wpisz.nextLine());
                        Wystawa(kategoria);
                        break;
                    case 2:
                        System.out.print("Podaj nazwe pierwszej broni do porownania: ");
                        String bron1 = wpisz.nextLine();
                        System.out.print("Podaj nazwe drugiej broni do porownania: ");
                        String bron2 = wpisz.nextLine();
                        Porownaj(bron1, bron2);
                        break;
                    case 3:
                        String zakup_cd = "Y";
                        while (zakup_cd.equals("Y")) {
                            System.out.print("Podaj nazwe broni ktora chcesz kupic: ");
                            String zakup = wpisz.nextLine();
                            Dodaj(zakup);
                            System.out.print("Czy chcesz kontynuowac zakupy? (Y/N): ");
                            zakup_cd = wpisz.nextLine();
                        }
                        Zakupy();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Można wprowadzić tylko liczbe od 1 do 4");
            }
        }

    }

}

