package com.company;

public class Main {

    public static void main(String[] args) {
        BST <String, Integer> bst = new BST<>();
        bst.miejsceDla("Grzegorz", 1998);
        System.out.println(bst.korzeń.klucz+" "+bst.korzeń.wartość);
        bst.miejsceDla("Grzegorz",2000);
        System.out.println(bst.korzeń.klucz+" "+bst.korzeń.wartość);
        bst.miejsceDla("Bronisław",2001);
        System.out.println(bst.korzeń.lewyPotomek.klucz+" "+bst.korzeń.lewyPotomek.wartość);
        bst.miejsceDla("Zbigniew",20001);
        System.out.println(bst.korzeń.prawyPotomek.klucz+" "+bst.korzeń.prawyPotomek.wartość);

        bst.miejsceDla("Piotr", 2010);
        bst.miejsceDla("Adam", 1990);
        bst.miejsceDla("Paweł", 1989);
        bst.miejsceDla("Szczepan", 1999);
        bst.miejsceDla("Łucja", 1999);
        bst.miejsceDla("Andrzej",1991);
        bst.miejsceDla("Żaneta", 1995);

        BST<String, Integer>.Wierzchołek szukany = bst.czyWystępuje("Bronisław");
        if(szukany!=null)System.out.println("wartosc szukanego " + szukany.klucz + " " + szukany.wartość);

        String minKlucz = bst.znajdźMinKlucz();
        String maxKlucz = bst.znajdźMaxKlucz();

        System.out.println(minKlucz);
        System.out.println(maxKlucz);

        System.out.println( );

        bst.przeszukajZakres(bst.korzeń,"A","Żż");
        for(BST<String,Integer>.Wierzchołek x:bst.kolejka) System.out.println(x.toString());
        System.out.println("---------------------");
        bst.kolejka.clear();
        BST<String,Integer>.Wierzchołek x = bst.czyWystępuje("Bronisław");
        bst.przeszukajZakres(x,"A","Żż");
        for(BST<String,Integer>.Wierzchołek xx:bst.kolejka) System.out.println(xx.toString());
        String[] lista = new String[BST.kolejka.size()];
        int i = 0;
        for(BST<String,Integer>.Wierzchołek x:BST.kolejka) {
            lista[i++] = x.klucz;
        }

        int wysokość = BST.wysokośćDrzewa(lista);
        System.out.println("\n wysokość wynosi: " + wysokość);
*/
        String tekst = "Kompaktowy SUV wyraźnie urósł, co przekłada się "
                + "na przestrzeń w kabinie. Tej nie brakuje w dwóch rzędach, "
                + "dzięki czemu cztery rosłe osoby wygodnie pokonają trasę "
                + "o długości kilkuset kilometrów. Drugi rząd został wyposażony "
                + "w regulację w zakresie 14 cm i oparcie o zmiennym "
                + "kącie nachylenia. Bagażnik o pojemności 435 litrów "
                + "oferuje dość niski próg załadunku i foremny kształt."
                + "Względem poprzednika, wyraźnie poprawiono jakość "
                + "materiałów wykończeniowych. Znaczna ich część jest "
                + "miękka i przyjemna w dotyku. Zdobienia wykonane "
                + "z aluminium i tworzywa o fakturze fortepianowej "
                + "wprowadzają klimat premium. To samo możemy powiedzieć "
                + "o elektronice. Centralny panel składa się z dwóch, "
                + "calowych ekranów. Ten przed oczami kierowcy ma zmienną "
                + "grafikę i nienaganną przejrzystość. Drugi z nich zawiaduje "
                + "zestawem kamer, zewnętrznymi nośnikami pamięci i "
                + "nawigacją z funkcją rozszerzonej rzeczywistości. "
                + "Wpisuje w mapę obraz z kamery, co przekłada się na "
                + "lepsze lokalizowanie skrętów i adresów. "
                + "Systemem sterujemy za pomocą gładzika umieszczonego "
                + "między fotelami lub głosowo. "
                + "Wystarczy powiedzieć hej, Mercedes, zimno mi "
                + "by elektronika zwiększyła temperaturę nawiewu. "
                + "Komputer rozpoznaje też wiele innych komend.";
        String[] podzielony = tekst.split(" ");
        int chwilowa;
        for (int i = 0; i < podzielony.length; i++) {
            if (podzielony[i].length() > 2) {
                chwilowa = podzielony[i].hashCode()&0x7fffffff;

                BST.miejsceDla(chwilowa,podzielony[i]);

            }

        }
        System.out.println( BST.korzeń.rozmiarP);
        BST.przeszukajZakres(BST.korzeń,0,0xfffffff);
        //tworzy listę kluczy potrzebna do wypisania wysokosci
        Integer[] lista = new Integer[BST.kolejka.size()];
        int i = 0;
        System.out.println(BST.kolejka.size());
        for(BST<Integer,String>.Wierzchołek x:BST.kolejka) {
            lista[i++] = x.klucz;

            System.out.println(x.klucz);

        }
        System.out.println(BST.wysokośćDrzewa(lista));
    }
}
