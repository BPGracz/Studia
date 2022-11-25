import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class komi {
    public static int[][] miasta;
    /**
     * Sumuje odległości między wylosowanymi miastami(chromosomami).
     * @param tablica Tablica indeksów miast z tablicy miasta.
     * @return Łączna odległość jaką wykona algorytm.
     */
    public static int liczodl(int[] tablica){
        int out = 0;
        for (int i=0 ; i<tablica.length-1 ; i++){
            out += miasta[tablica[i]][tablica[i+1]];
        }
        out += miasta[tablica[tablica.length-1]][tablica[0]];
        return out;
    }
    /**
     * Wypisuje odległości jakie wykona algorytm w kazdym kroku.
     * @param tablica Tablica indeksów miast z tablicy miasta.
     * @return odległość między miastem a następnym miastem.
     */
    public static int[] odl(int[] tablica){
        int[] odl = new int[tablica.length];
        for (int i=0 ; i<tablica.length-1 ; i++){
            odl[i]= miasta[tablica[i]][tablica[i+1]];
        }
        odl[tablica.length-1] = miasta[tablica[tablica.length-1]][tablica[0]];
        return odl;
    }
    /**
     * Sumuje odległość jaką wykonał algorytm krok po kroku.
     * @param tablica Tablica indeksów miast z tablicy miasta.
     * @return Łączna odległośc jaką wykonał algorytm z każdym krokiem.
     */
    public static int[] liczkroki(int[] tablica){
        int[] odleglosci = new int[tablica.length];
        int sum = 0;
        for (int i=0 ; i<tablica.length-1 ; i++){
            sum += miasta[tablica[i]][tablica[i+1]];
            odleglosci[i] = sum;
        }
        odleglosci[tablica.length-1] = sum + miasta[tablica[tablica.length-1]][tablica[0]]; 
        return odleglosci;
    }
    /**
     * Odczyt pliku tekstowego z odległościami między miastami.
     * @return Tablica odległości między miastami.
     * @throws FileNotFoundException
     * @throws NoSuchElementException
     */
    public static int[][] input() throws FileNotFoundException, NoSuchElementException{
        int size = 0;

        //Odczyt z pliku.
        File data =  new File("liczby.txt");
        Scanner loadData = new Scanner(data);

        //Zapis linijki do zmiennej.
        String line = loadData.nextLine();

        //sprawdz wielkosc tablicy(ilosc miast).
        String[] linearr = line.split(" ");
        for (int i = 0 ; i < linearr.length  ; i++){
            if(linearr[i] != " "){
                size++;
            }
        }

        //Utworzenie tablicy. 
        int[][] dataBase = new int[size][size];

        //Uzupelnianie odleglosci miedzy miastami do tablicy. 
        for(int i = 0  ; i < size ; i++){
            for(int k = 0 ; k < size ; k++){
                dataBase[i][k] = Integer.parseInt(linearr[k]);
            }
            if(i<size-1) 

            line = loadData.nextLine();
            linearr = line.split(" ");
        }
        loadData.close();
        return dataBase;

    }
    public static void main(String[] args) { 
        int iteracje = 1000;
        int liczbapopulacji = 10000;
        int bestodleglosc = 99999;
        int[] tablicawynik = new int[iteracje]; 
        double pGen = 0.5;
          
    
        //Tworzenie tablicy wejsciowej z pliku wejsciowego
        try{
            miasta = input();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }

        int[] bestodl = new int[miasta.length];
        int[] bestkroki = new int[miasta.length];
        int[] bestodlmiedzy = new int[miasta.length];

        //Odczyt miasta poczatkowego z klawiatury
        System.out.println("Podaj miasto początkowe:");

        Scanner in = new Scanner(System.in);
        int zmiennawej;
        boolean ok = true;

        //Sprawdza czy liczba podana jest indeksem miasta.
        try{
            do{
            zmiennawej = in.nextInt();
            ok = true;
                if(zmiennawej<miasta.length && zmiennawej>=0){
                    ok = false;
                }
                System.out.println("Nie ma takiego miasta!");
                System.out.println("Podaj miasto początkowe:");
            }
            while(ok);   
            genetics.start = zmiennawej;
            }
        catch(Exception e){
            System.out.println("To nie jest liczba! ale przyjmijmy ze zaczynam od pierwszego (0).");
        }
        in.close();
      
        //Algorytm wykonuje sie okreslona ilosc razy podaną w zmiennej "iteracje".
        for(int i=0 ; i<iteracje ; i++){

            //Nadpisanie interfejsu klasy genetics który służy do zwracania wyniku funkcji przystosowania dla całej populacji.
            genetics.fitnessseq fit = new genetics.fitnessseq() {
            @Override
                public int[] fitnessFunction(int[][]population){
                    int[] fitnesy = new int[population.length];
                    for (int i=0 ; i < fitnesy.length ; i++){
                        fitnesy[i] = liczodl(population[i]);
                    }
                    return fitnesy;
                }
            };
        
            //Wywolanie algorytmu komiwojażera, zapisanie wyników.
            int[] kroki = genetics.geneticAlgorithm(miasta.length, liczbapopulacji, 100, pGen, pGen, fit, true);
            int[] odleglosci = liczkroki(kroki);
            int[] odlmiedzy = odl(kroki);
            int odleglosc = liczodl(kroki);
            tablicawynik[i] = odleglosc;

            //Algorytm sprawdza czy wynik kazdej iteracji jest najlepszym wynikiem. Jeżeli tak, to zapisuje go w zmiennych (najlepsza odleglosc, najlepsza trasa)
            if(odleglosc<bestodleglosc){
                bestodleglosc = odleglosc;
                for(int m = 0 ; m< miasta.length ; m++){
                    bestkroki[m] = kroki[m];
                    bestodl[m] = odleglosci[m];
                    bestodlmiedzy[m] = odlmiedzy[m];
                }
            }
            System.out.println(bestodleglosc);
        

        }   

        //Sprawdza czy plik z taką nazwą już istnieje, jeżeli nie to tworzy taki plik a jeżeli już istnieje to nadpisuje wartości.
        try{
            File file = new File("Wynik" + iteracje + "x" + miasta.length + ".txt");
            if(!file.exists())
                file.createNewFile();
    
            FileWriter fw = new FileWriter("Wynik" + iteracje + "x" + miasta.length + ".txt");
            fw.write("Miasto poczatkowe: " + genetics.start + " ilosc miast: " + miasta.length + " iteracje: " + iteracje + " Liczba osobnikow populacji: " + liczbapopulacji + " Prawdopodobienstwo operatorow genetycznych: " + pGen);

            //zapisuje wynik najlepszej trasy, odległości miedzy kolejnymi miastami, odległość narastania i sumę odległości między miastami.

            fw.write("\n\nNajlepsza trasa: \n");
            for(int i = 0 ; i < bestkroki.length ; i++){
                fw.write(String.valueOf(bestkroki[i] + " -> "));
            }
            fw.write(bestkroki[0] + "\nOdleglosci miedzy miastami: \n");
            for(int i = 0 ; i < bestodlmiedzy.length-1 ; i++){
                fw.write(String.valueOf(bestodlmiedzy[i] + " -> "));
            }
            fw.write(bestodlmiedzy[bestodlmiedzy.length-1] + "\nOdleglosc narastania: \n");
            for(int i = 0 ; i < bestodl.length-1 ; i++){
                fw.write(String.valueOf(bestodl[i] + " -> "));
            }
            fw.write(bestodl[bestodl.length-1] + "\nLaczna odleglosc: \n" + String.valueOf(bestodleglosc));
            System.out.println("Zapisano.");
            fw.write("\n\nWszystkie odleglosci:");
            for(int k =0 ; k < tablicawynik.length ; k++){
                fw.write("\n" + tablicawynik[k]);
            }
            fw.close();
        }
        catch (Exception e){
            System.out.println("Błąd zapisu.");
        }
    }
}
