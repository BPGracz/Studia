import java.util.ArrayList;
import java.util.Random;

public class genetics {
    //Miasto początkowe
    public static int start;

    /**
     * Tworzy tablicę permutacji chromosomu.
     */ 
    
    public static int[] permute(int len) {
        int[] a1 = new int[len];
        int[] a2 = new int[len];
        int[] index = new int[len];
        boolean ok = true;
        for(int i=0; i<len; i++)
            a1[i] = i;
        Random random = new Random();
        for(int i=0; i<len; i++) {
            //Wpisuje indeks miasta z którego ma zacząc na pierwsze miejsce tablicy
            if(i==0) {
                index[i]= start;
                i++;
            }
            do {
                ok = true;
                index[i] = random.nextInt(len);
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
     * Tworzy populację o długości N jako tablicę chromosomów.
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
     * Sprawdza, czy można skorzystać z operatora PMX na zadanych operatorach.
     * @param c1 Chromosom pierwszego rodzica.
     * @param c2 Chromosom drugiego rodzica.
     * @param cut1 Punkt krzyżowania 1.
     * @param cut2 Punkt krzyżowania 2.
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
     * Operator genetyczny krzyżowania PMX.
     * @param c1 Chromosom pierwszego rodzica.
     * @param c2 Chromosom drugiego rodzica.
     * @param cut1 Punkt krzyżowania 1.
     * @param cut2 Punkt krzyżowania 2.
     * @return Tablica chromosomów dwóch dzieci po operacji krzyżowania.
     */
    public static int[][] pmx(int[] c1, int[] c2, int cut1, int cut2) {
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

    public static int[] inversion(int[] nums, int n) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length-1; i++)
            res[i] = nums[i];
        int x = nums[n], y = nums[n+1];
        res[n] = y;
        res[n+1] = x;
        return res;
    }


    /**
     * Zwraca wyniki funkcji przystosowania dla całej populacji.
     * @param population Tablica chromosomów populacji.
     * @param fitness Klasa anonimowa oparta o interfejs funkcji przystosowania.
     * @return Wyniki funkcji przystosowania dla całej populacji.
     * @see Fitness
     */
    public static int[] getPopulationFitness(int[][] population, fitnessseq fitness) {
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
     * Wykonuje selekcję ruletki w podanej populacji.
     * @param population Populacja.
     * @param fitness Funkcja przystosowania.
     * @return Wybrany osobnik na podstawie funkcji przystosowania.
     */
    public static int[] roulette(int[][] population, fitnessseq fitness, boolean minimize) {
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
     * RouletteMin szuka najmniejszej wartości.
     * @param population Populacja.
     * @param fitness Funkcja przystosowania.
     * @param method Metoda selekcji.
     * @return Wybrany chromosom.
     */
    public static int[] select(int[][] population, fitnessseq fitness, SelectionMethods method) {
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
    public static int[][] selectPopulation(int[][] population, fitnessseq fitness, SelectionMethods method, int N) {
        int[][] pop = new int[population.length][population[0].length];
        for(int i=0; i<N; i++)
            pop[i] = select(population,fitness,method);
        return pop;
    }

    public static double[] current;
    public static double[] bestCurrent;
    public static double[] bestGlobal;

    /**
     * Algorytm genetyczny.
     * @param M Liczba zmiennych.
     * @param P Liczba osobników populacji.
     * @param ev Liczba ewaluacji FP.
     * @param fitness Funkcja przystosowania.
     * @param minimize Jeżeli prawda, algorytm szuka minimum zamiast maksimum.
     * @return Najlepszy osobnik.
     */
    public static int[] geneticAlgorithm(int Miasta, int P, int ev, double px,double pi, fitnessseq fitness, boolean minimize) {
        current = new double[ev];
        bestCurrent = new double[ev];
        bestGlobal = new double[ev];

        int iteruj = 0;
        double max = Double.MIN_VALUE+1;
        double min = Double.MAX_VALUE-1;
        double bestG = minimize?Double.MAX_VALUE-1:Double.MIN_VALUE+1;
        int[] bestChrom = new int[Miasta];

        // 1. wybór początkowej populacji chromosomów
        int[][] pop = generatePopulation(P,Miasta);
        int[] fitnesses;
        do {

            // 2. Ocena przystosowania chromosomów
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

            // 3. Warunek zatrzymania
            if(iteruj>=ev)
                break;

            //zapisywanie wszystkich
            for(int i=0; i<P; i++) {
                try {
                    current[iteruj*P+i]=fitnesses[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return bestChrom;
                }
            }

            //zapisywanie najlepszego obecnie
            for(int i=0; i<P; i++) {
                try {
                    bestCurrent[iteruj*P+i]=bestL;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return bestChrom;
                }
            }

            //zapisywanie najlepszego globalnie
            for(int i=0; i<P; i++) {
                try {
                    bestGlobal[iteruj*P+i]=bestG;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return bestChrom;
                }
            }

            iteruj++;

            // 4. Selekcja chromosomów
            // Interesuje nas najmniejsza suma odleglosci więc wybrana jest metoda Roulette min (minimize = true).

            if(minimize)
                pop = selectPopulation(pop, fitness, SelectionMethods.RouletteMin, P);
            else
                pop = selectPopulation(pop, fitness, SelectionMethods.Roulette, P);

            // 5. Zastosowanie operatorów genetycznych

            // PMX
            for(int i=0; i<pop.length; i++){
                int x1,x2,i2;
                do{
                    x1=(int)(Miasta*Math.random());
                    x2=(int)(Miasta*Math.random());

                }
                while(x2<=x1);
                i2=(int)(pop.length*Math.random());
                //Jeżeli wylosowana liczba jest wieksza niż prawdopodobienstwo krzyżowania pmx, sprawdza czy mozna wykonac te krzyzowanie. Jeżeli tak to wykonuje je w indeksie i.
                if(Math.random()<px && checkPMX(pop[i], pop[i2], x1, x2)){
                        pop[i] = pmx(pop[i], pop[i2], x1, x2)[0];
                        pop[i2] = pmx(pop[i], pop[i2], x1, x2)[1];
                }
            }

            // Inwersja
            for(int i=0; i<pop.length; i++)
                for(int j=0; j<pop[i].length-1; j++)
                    //Jeżeli wylosowana liczba jest wieksza niż prawdopodobienstwo inwersji to zamien sasiądów na indeksie j
                    if(Math.random()<pi)
                        pop[i] = inversion(pop[i],j);
            
            // 6. Utworzenie nowej populacji z chromosomów
            
        } while(true);

        return bestChrom;
    }
    

    public interface fitnessseq {
        /**
         * Zwraca wyniki funkcji przystosowania dla całej populacji.
         * @param population Populacja chromosomów.
         * @return Metoda powinna być tak nadpisana, aby zwracała wyniki funkcji przystosowania.
         */
        int[] fitnessFunction(int[][] population);
    }

}
