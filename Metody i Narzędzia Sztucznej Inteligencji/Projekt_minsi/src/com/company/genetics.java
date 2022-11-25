package com.company;

import java.util.ArrayList;
import java.util.Random;

public class genetics {

    /**
     * Tworzy populację o długości N jako tablicę chromosomów.
     * @param M Liczba genów.
     * @param N Liczebność populacji.
     * @param k Maksymalna wartość+1.
     * @return Populacja jako tablica chromosomów.
     */
    public static int[][] generatePopulation(int N,int k) {
        int[][] pop = new int[N][];
        for(int i=0; i<N; i++) {
            pop[i] = permute(k);
        }
        return pop;
    }

    /**
     *@param a1 - tablica indeksow
     *@param a2-  tablica po permutacji
     *@param ok - jesli ok true wykonuje zamiane, jesli false zakonczyl permutowac i wypisuje tablice permutacji
     */
    public static int[] permute(int len) {
        int[] a1 = new int[len];
        int[] a2 = new int[len];
        int[] index = new int[len];
        boolean ok = true;
        for(int i=0; i<len; i++)
            a1[i] = i;
        Random rnd = new Random();
        for(int i=0; i<len; i++) {
            do {
                ok = true;
                index[i] = rnd.nextInt(len);
                for(int j=0; j<i; j++)
                    if(index[i]==index[j])
                        ok = false;
            } while(!ok);
        }
        for(int i=0; i<len; i++)
            a2[i] = a1[index[i]];
        return a2;
    }
    /**
     * Sprawdza, czy można skorzystać z operatora PMX na zadanych operatorach.
     * @param c1 Chromosom pierwszego rodzica.
     * @param c2 Chromosom drugiego rodzica.
     * @param cut1 Punkt krzyżowania 1.
     * @param cut2 Punkt krzyżowania 2.
     * @return Czy można użyć na tych chromosomach PMX?
     */
    public static boolean checkPMX(int[] c1, int[] c2, int cut1, int cut2) {
        for(int i=0; i<c1.length; i++) {
            if(i <= cut1 || i > cut2)
                continue;
            for(int j=0; j<c2.length; j++) {
                if(j <= cut1 || j > cut2)
                    continue;
                if(c1[i] == c2[j] && i != j)
                    return false;
            }
        }
        return true;
    }

    /**
     * @param c1 Chromosom pierwszego rodzica.
     * @param c2 Chromosom drugiego rodzica.
     * @param cut1 Punkt krzyżowania 1.
     * @param cut2 Punkt krzyżowania 2.
     * @return Tablica chromosomów dwóch dzieci po operacji krzyżowania z częściowym odwzorowaniem (PMX).
     */
    public static int[][] PMX(int[] c1, int[] c2, int cut1, int cut2) {
        int[][] out = new int[2][c1.length];
        for(int i=0; i<c1.length; i++) {
            out[0][i] = c1[i];
            out[1][i] = c2[i];
        }
        ArrayList<Integer> pair1 = new ArrayList<>();
        ArrayList<Integer> pair2 = new ArrayList<>();
        for(int i=0; i<c1.length; i++) {
            if(i > cut1 && i <= cut2) {
                out[0][i] = c2[i];
                out[1][i] = c1[i];
                if(!pair1.contains(c1[i]) && !pair2.contains(c2[i])) {
                    pair1.add(c1[i]);
                    pair2.add(c2[i]);
                }
            }
        }
        for(int i=0; i<c1.length; i++) {
            if(i <= cut1 || i > cut2) {
                for(int j=0; j<pair1.size(); j++) {
                    if(out[0][i] == pair2.get(j)) {
                        //System.out.println(pair2.get(j) + " → " + pair1.get(j));
                        out[0][i] = pair1.get(j);
                    }
                }
                for(int j=0; j<pair1.size(); j++) {
                    if(out[1][i] == pair1.get(j)) {
                        //System.out.println(pair1.get(j) + " → " + pair2.get(j));
                        out[1][i] = pair2.get(j);
                    }
                }
            }
        }
        return out;
    }

    /**
     * Zwraca wyniki funkcji przystosowania dla całej populacji.
     * @param population Tablica chromosomów populacji.
     * @param fitness Klasa anonimowa oparta o interfejs funkcji przystosowania.
     * @return Wyniki funkcji przystosowania dla całej populacji.
     * @see Fitness
     */
    public static int[] getPopulationFitness(int[][] population, FitnessSequence fitness) {
        return fitness.fitnessFunction(population);
    }

    /**
     * Lista metod selekcji.
     */
    enum SelectionMethods {
        Roulette,
        RouletteMin,
    }

    /**
     * Wykonuje selekcję ruletki z podanej populacji.
     * @param population Populacja.
     * @param fitness Funkcja przystosowania.
     * @return Wybrany osobnik na podstawie funkcji przystosowania.
     */
    public static int[] roulette(int[][] population, FitnessSequence fitness, boolean minimize) {
        int[] fitnesses = getPopulationFitness(population,fitness);
        double sum = 0;

        //Ten mechanizm utworzono, aby w sumowaniu nie było problemów ze znakiem.
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(int i=0; i<fitnesses.length; i++)
            if(min>fitnesses[i])
                min = fitnesses[i];
        for(int i=0; i<fitnesses.length; i++)
            if(max<fitnesses[i])
                max = fitnesses[i];

        for(int i=0; i<fitnesses.length; i++)
            sum += fitnesses[i]-min;
        double score = sum*Math.random();
        sum = 0;
        for(int i=0; i<fitnesses.length; i++) {
            if(!minimize) {
                sum += fitnesses[i]-min;
                if(score<=sum || i==fitnesses.length-1) {
                    return population[i];
                }
            }
            else {
                sum -= fitnesses[i]+min;
                if(score>=sum || i==fitnesses.length-1) {
                    return population[i];
                }
            }
        }

        return new int[]{0}; //nigdy nie osiągnie tej instrukcji
    }

    /**
     * Dokonuje selekcji za pomocą zadanej metody.
     * @param population Populacja.
     * @param fitness Funkcja przystosowania.
     * @param method Metoda selekcji.
     * @return Wybrany chromosom.
     */
    public static int[] select(int[][] population, FitnessSequence fitness, SelectionMethods method) {
        int[] out;
        switch (method) {
            case RouletteMin: out = roulette(population,fitness,true); break;
            default: out = roulette(population,fitness,false); break;
        }
        return out;
    }

    /**
     * Dokonuje selekcji N razy za pomocą zadanej metody.
     * @param population Populacja.
     * @param fitness Funkcja przystosowania.
     * @param method Metoda selekcji.
     * @param N Liczba osobników wynikowej populacji.
     * @return Nowa populacja z wybranych chromosomów.
     */
    public static int[][] selectPopulation(int[][] population, FitnessSequence fitness, SelectionMethods method, int N) {
        int[][] pop = new int[population.length][population[0].length];
        for(int i=0; i<N; i++)
            pop[i] = select(population,fitness,method);
        return pop;
    }

    public static double[] current;
    public static double[] bestCurrent;
    public static double[] bestGlobal;

    /**
     * Prosty algorytm genetyczny.
     * @param M Liczba zmiennych.
     * @param P Liczba osobników populacji.
     * @param ev Liczba ewaluacji FP.
     * @param pi Prawdopodobieństwo inwersji.
     * @param fitness Funkcja przystosowania.
     * @param minimize Jeżeli prawda, algorytm szuka minimum zamiast maksimum.
     * @return Najlepszy osobnik.
     */
    public static int[] geneticAlgorithm(int Miasta, int P, int ev, double px, FitnessSequence fitness, boolean minimize) {
        current = new double[ev];
        bestCurrent = new double[ev];
        bestGlobal = new double[ev];

        int iterations = 0;
        double max = Double.MIN_VALUE+1;
        double min = Double.MAX_VALUE-1;
        double bestG = minimize?Double.MAX_VALUE-1:Double.MIN_VALUE+1;
        int[] bestChrom = new int[Miasta];

        // krok 1 - Inicjacja - wybór początkowej populacji chromosomów
        int[][] pop = generatePopulation(P,Miasta);
        int[] fitnesses;
        do {

            // krok 2 - Ocena przystosowania chromosomów w populacji
            fitnesses = getPopulationFitness(pop,fitness);
            double maxC = Double.MIN_VALUE+1;
            double minC = Double.MAX_VALUE-1;
            double bestL = minimize?Double.MAX_VALUE-1:Double.MIN_VALUE+1;
            for(int i=0; i<fitnesses.length; i++) {
                if(fitnesses[i]>max) {
                    max = fitnesses[i];
                    if(!minimize) {
                        bestChrom = pop[i];
                        bestG = fitnesses[i];
                    }
                }
                if(fitnesses[i]<min) {
                    min = fitnesses[i];
                    if(minimize) {
                        bestChrom = pop[i];
                        bestG = fitnesses[i];
                    }
                }
                if(fitnesses[i]>maxC) {
                    maxC = fitnesses[i];
                    if(!minimize)
                        bestL = fitnesses[i];
                }
                if(fitnesses[i]<minC) {
                    minC = fitnesses[i];
                    if(minimize)
                        bestL = fitnesses[i];
                }
            }

            // krok 3 - Warunek zatrzymania
            if(iterations>=ev)
                break;

            //zapisywanie wszystkich
            for(int i=0; i<P; i++) {
                //System.out.println(fitnesses[i]);
                try {
                    current[iterations*P+i]=fitnesses[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return bestChrom;
                }
            }

            //zapisywanie najlepszego obecnie
            for(int i=0; i<P; i++) {
                //System.out.println(bestL);
                try {
                    bestCurrent[iterations*P+i]=bestL;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return bestChrom;
                }
            }

            //zapisywanie najlepszego globalnie
            for(int i=0; i<P; i++) {
                //System.out.println(bestG);
                try {
                    bestGlobal[iterations*P+i]=bestG;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return bestChrom;
                }
            }

            iterations++;

            // krok 4 - Selekcja chromosomów (Metoda ruletki)
            if(minimize)
                pop = selectPopulation(pop, fitness, SelectionMethods.RouletteMin, P);
            else
                pop = selectPopulation(pop, fitness, SelectionMethods.Roulette, P);

            // krok 5 - Zastosowanie operatorów genetycznych

            for(int i=0; i<pop.length; i++){
                int x1,x2,i2;
                do{
                    x1=(int)(Miasta*Math.random());
                    x2=(int)(Miasta*Math.random());

                }
                while(x2<=x1);
                i2=(int)(Miasta*Math.random());
                if(Math.random()<px && checkPMX(pop[i], pop[i2], x1, x2)){
                    pop[i] = PMX(pop[i], pop[i2], x1, x2)[0];
                    pop[i2] = PMX(pop[i], pop[i2], x1, x2)[1];
                }
            }

            // krok 6 - Utworzenie nowej populacji z chromosomów otrzymanych po zastosowaniu selekcji i
            //operatorów genetycznych
            //Wykonuje się w metodach operatorów.

        } while(true);
        return bestChrom;
    }


    public interface FitnessSequence {
        /**
         * Zwraca wyniki funkcji przystosowania dla całej populacji.
         * @param population Populacja chromosomów.
         * @return Metoda powinna być tak nadpisana, aby zwracała wyniki funkcji przystosowania.
         */
        int[] fitnessFunction(int[][] population);
    }
}
