package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class program {
    public static int[][] miasta;

    public static int liczodl(int[] tablica){
        int out = 0;
        for (int i=0 ; i<tablica.length-1 ; i++){
            out += miasta[tablica[i]][tablica[i+1]];
        }
        out += miasta[tablica[tablica.length-1]][tablica[0]];
        return out;

    }

    public static int[][] input() throws FileNotFoundException, NoSuchElementException{
        int size = 0;

        //odczyt z pliku
        File data =  new File("liczby.txt");
        Scanner loadData = new Scanner(data);

        //zapis linijki do zmiennej
        String line = loadData.nextLine();

        //sprawdz wielkosc tablicy(ilosc miast)
        String[] linearr = line.split(" ");
        for (int i = 0 ; i < linearr.length  ; i++){
            if(linearr[i] != " "){
                size++;
            }
        }

        //tworzenie tablicy
        int[][] dataBase = new int[size][size];

        //uzupelnianie odleglosci miedzy miastami do tablicy
        for(int i = 0  ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                dataBase[i][j] = Integer.parseInt(linearr[j]);
                //System.out.print(dataBase[i][k] + " ");
            }
            //System.out.print("\n");
            line = loadData.nextLine();
            linearr = line.split(" ");
        }
        loadData.close();
        return dataBase;

    }
    public static void main(String[] args) {

        genetics.FitnessSequence fit = new genetics.FitnessSequence() {
            @Override
            public int[] fitnessFunction(int[][]population){
                int[] fitnesy = new int[population.length];
                for (int i=0 ; i < fitnesy.length ; i++){
                    fitnesy[i] = liczodl(population[i]);
                }
                return fitnesy;
            }
        };
        try{
            miasta = input();
        }
        catch(Exception exception){
        };
        int[] kolejnosc = genetics.geneticAlgorithm(miasta.length, 10, 100000, 0.5, fit, true);
        int odleglosc = liczodl(kolejnosc);
        for(int i = 0 ; i < kolejnosc.length ; i++){
            System.out.println(kolejnosc[i]);
        }
        System.out.println(odleglosc);

        try{
            File file = new File("Wynik.txt");
            if(!file.exists())
                file.createNewFile();

            FileWriter fw = new FileWriter("Wynik.txt");
            fw.write("Trasa: \n");
            for(int i = 0 ; i < kolejnosc.length ; i++){
                fw.write(String.valueOf(kolejnosc[i] + " -> "));
            }
            fw.write(kolejnosc[0] +"\nOdleglosc: \n" + String.valueOf(odleglosc));
            System.out.println("Zapisano.");
            fw.close();
        }
        catch (Exception e){
            System.out.println("Błąd.");
        }
    }
}
