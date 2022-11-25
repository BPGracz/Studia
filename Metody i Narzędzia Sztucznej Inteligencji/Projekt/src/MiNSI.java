import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class MiNSI {

    //Funkcja x1 i x2
    public static double f(double x1, double x2) {
        return -Math.pow(x1,2.0d)-Math.pow(x2,2.0d)+2;
    }
    //Przedział (A,B) i liczba miejsc znaczących po przecinku D
    public static double ai = -2, bi = 2, di = 5;
    //Liczba genów = liczba zmiennych
    public static int n = 2;
    //Liczba bitów genów
    public static int mi = 0;
    //Liczba bitów chromosomu
    public static int m = 0;

    //Mnożnik funkcji Rastrigina
    public static double A = 10;

    //Funkcja Rastrigina
    public static double rastrigin(double[] X) {
        n = X.length;
        double result = A*n;
        for(int i=0; i<n; i++) {
            result += Math.pow(X[i],2)-A*Math.cos(2*Math.PI*X[i]);
        }
        return result;
    }

    //Długość genu
    public static int gen_dlugosc(double ai_, double bi_, double di_) {
        ai = ai_;
        bi = bi_;
        di = di_;
        mi = (int)Math.ceil(Math.log((bi-ai)*Math.pow(10,di))/Math.log(2));
        return mi;
    }

    //Długość chromosomu
    public static int chrom_dlugosc(int mi_, int n_) {
        mi = mi_;
        n = n_;
        m = mi*n;
        return m;
    }

    //Losowy ciąg binarny
    public static String losuj_bity(int len) {
        String str = "";
        for (int i=0; i<len; i++)
        {
            str += Math.random() > 0.5 ? "1" : "0";
        }
        return str;
    }

    //Konwersja z bitowego na dziesiętny
    public static long convert2to10(String str) {
        String s = "";
        for(int i=0; i<str.length(); i++)
            s += str.charAt(i);
        return Long.parseLong(s,2);
    }

    //Dekodowanie
    public static double dekoduj(String bin, int start, int end) {
        return ai + convert2to10(bin.substring(start,end))*((bi-ai)/(Math.pow(2,mi)-1));
    }

    //Tworzenie chromosomu (na podstawie dlugosci chromosomu i genu)
    public static String stworz_chrom(int lenc, int leng) {
        String result = "";
        String str = "";
        for(int i=0; i<lenc; i++) {
            do {
                str = losuj_bity(leng);
            } while(dekoduj(str,0,str.length()) < ai || dekoduj(str,0,str.length()) > bi);
            result += str;
        }
        return result;
    }

    //Sprawdzanie poprawności chromosomu
    public static String sprawdz_chrom(String chromosome) {
        String sep1,sep2,newstr;
        for(int i=0; i<m/mi; i++) {
            if(dekoduj(chromosome,i*mi,(i+1)*mi-1) < ai || dekoduj(chromosome,i*mi,(i+1)*mi-1) > bi) {
                sep1 = chromosome.substring(0,i*n);
                sep2 = chromosome.substring((i+1)*n,chromosome.length()-1);
                do {
                    newstr = losuj_bity(n);
                } while(dekoduj(newstr,0,newstr.length()) < ai || dekoduj(newstr,0,newstr.length()) > bi);
                chromosome = sep1+newstr+sep2;
            }
        }
        return chromosome;
    }

    //Dekodowanie chromosomu
    public static double[] dekoduj_chrom(String chromosome) {
        double[] result = new double[n];
        for(int i=0; i<n; i++)
            result[i] = dekoduj(chromosome,i*mi,(i+1)*mi-1);
        return result;
    }

    //Krzyżowanie w 1 punkcie
    public static String[] krzyz_1(String c1, String c2, int pos) {
        String[] result = new String[] {
                c1.substring(0,pos)+c2.substring(pos),
                c2.substring(0,pos)+c1.substring(pos)
        };
        return new String[] {
                sprawdz_chrom(result[0]),sprawdz_chrom(result[1])
        };
    }

    //Krzyzowanie 2 punktowe
    public static String[] krzyz_2(String c1, String c2, int pos1, int pos2) {
        String[] result = new String[] {
                c1.substring(0,pos1)+c2.substring(pos1,pos2)+c1.substring(pos2),
                c2.substring(0,pos1)+c1.substring(pos1,pos2)+c2.substring(pos2),
        };
        return new String[] {
                sprawdz_chrom(result[0]),sprawdz_chrom(result[1])
        };
    }

    //Mutacje
    public static double pm = 0.1;
    public static String mutacja(String str, double pm_) {
        pm = pm_;
        String result = "";
        boolean okay = true;
        do {
            result = "";
            okay = true;
            for(int i=0; i<str.length(); i++) {
                if(Math.random()<pm) {
                    result += str.charAt(i)=='0'?'1':'0';
                }
                else
                    result += str.charAt(i);
            }
            double[] X = dekoduj_chrom(result);
            for(double d : X)
                if(d<ai || d>bi)
                    okay = false;
        } while(!okay);
        return sprawdz_chrom(result);
    }

    //Permutacje
    public static int[] permutacja(int len) {
        int[] a1 = new int[len];
        int[] a2 = new int[len];
        int[] indices = new int[len];
        boolean ok = true;
        for(int i=0; i<len; i++)
            a1[i] = i+1;
        Random random = new Random();
        for(int i=0; i<len; i++) {
            do {
                ok = true;
                indices[i] = random.nextInt(len);
                for(int j=0; j<i; j++)
                    if(indices[i]==indices[j])
                        ok = false;
            } while(!ok);
        }
        for(int i=0; i<len; i++)
            a2[i] = a1[indices[i]];
        return a2;
    }

    //Sprawdzenie czy (na ciągach) można wykonać PMX
    public static boolean sprawdz_pmx(int[] c1, int[] c2, int pos1, int pos2) {
        for(int i=0; i<c1.length; i++) {
            if(i <= pos1 || i > pos2)
                continue;
            for(int j=0; j<c2.length; j++) {
                if(j <= pos1 || j > pos2)
                    continue;
                if(c1[i] == c2[j] && i != j)
                    return false;
            }
        }
        return true;
    }

    //PMX
    public static int[][] pmx(int[] c1, int[] c2, int pos1, int pos2) {
        int[][] result = new int[2][c1.length];
        for(int i=0; i<c1.length; i++) {
            result[0][i] = c1[i];
            result[1][i] = c2[i];
        }
        ArrayList<Integer> pair1 = new ArrayList<>();
        ArrayList<Integer> pair2 = new ArrayList<>();
        for(int i=0; i<c1.length; i++) {
            if(i > pos1 && i <= pos2) {
                result[0][i] = c2[i];
                result[1][i] = c1[i];
                if(!pair1.contains(c1[i]) && !pair2.contains(c2[i])) {
                    pair1.add(c1[i]);
                    pair2.add(c2[i]);
                }
            }
        }

        for(int i=0; i<c1.length; i++) {
            if(i <= pos1 || i > pos2) {
                for(int j=0; j<pair1.size(); j++) {
                    if(result[0][i] == pair2.get(j)) {
                        System.out.println(pair2.get(j) + " → " + pair1.get(j));
                        result[0][i] = pair1.get(j);
                    }
                }
                for(int j=0; j<pair1.size(); j++) {
                    if(result[1][i] == pair1.get(j)) {
                        System.out.println(pair1.get(j) + " → " + pair2.get(j));
                        result[1][i] = pair2.get(j);
                    }
                }
            }
        }
        return result;
    }

    //Inwersja
    public static int[] odwroc(int[] nums, int n) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            result[i] = nums[i];
        int x = nums[n], y = nums[n+1];
        result[n] = y;
        result[n+1] = x;
        return result;
    }

    //Stworzenie populacji
    public static String[] stworz_pop(int N) {
        String[] pop = new String[N];
        for(int i=0; i<N; i++) {
            pop[i] = stworz_chrom(m/mi,mi);
        }
        return pop;
    }

    //Uzyskanie wartości funkcji przystosowania (Fitness)
    public static double[] stworz_pop_fit(String[] population, Fitness fitness) {
        return fitness.fitnessFunction(population);
    }

    //Wypisz Populacje
    public static void wypisz_pop(String[] population) {
        for(int i=0; i<population.length; i++) {
            System.out.println("persona "+(i+1)+"→→→→→→→→→→→→→"+population[i]);
        }
    }

    //Wypisz wartości funkcji przystosowania
    public static void wypisz_pop_fit(String[] population, Fitness fitness) {
        double[] FP = stworz_pop_fit(population, fitness);
        for(int i=0; i<population.length; i++) {
            System.out.println("persona "+(i+1)+"→→→→→→→→→→→→→"+FP[i]);
        }
    }

    //Wypisz populacje i z wartościami funkcji przystosowania
    public static void wypisz_pop_i_fit(String[] population, Fitness fitness) {
        double[] FP = stworz_pop_fit(population, fitness);
        for(int i=0; i<population.length; i++) {
            System.out.println("persona "+(i+1+"→→→→→→→→→→→→→"+population[i])+"→→→→→→→→→→→→→fitness = "+FP[i]);
        }
    }

    //Uzyskanie średniej wartości funkcji przystosowania
    public static double policz_srednia_fit(String[] population, Fitness fitness) {
        double avg = 0;
        double[] FP = stworz_pop_fit(population, fitness);
        for(int i=0; i<FP.length; i++)
            avg += FP[i];
        return avg/(double)FP.length;
    }

    //Uzyskaj liczby person poniżej średniej
    public static int policz_ilosc_person_ponizej_sredniej(String[] population, Fitness fitness) {
        double avg = policz_srednia_fit(population,fitness);
        double[] FP = stworz_pop_fit(population, fitness);
        int count = 0;
        for(int i=0; i<FP.length; i++)
            if(FP[i]<avg)
                count++;
        return count;
    }

    //Uzyskaj liczbe person wiekszych bądź równych średniej funkcji przystosowania
    public static int policz_ilosc_person_powyzej_lub_rownej_sredniej(String[] population, Fitness fitness) {
        double avg = policz_srednia_fit(population,fitness);
        double[] FP = stworz_pop_fit(population, fitness);
        int count = 0;
        for(int i=0; i<FP.length; i++)
            if(FP[i]>=avg)
                count++;
        return count;
    }

    //Ruletka
    public static String ruletka(String[] population, Fitness fitness, boolean minimize) {
        double[] fitnesses = stworz_pop_fit(population,fitness);
        double sum = 0;

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
        return "Done";
    }

    //Selekcja populacji
    public static String[] wybierz_pop(String[] population, Fitness fitness, int N, boolean min) {
        String[] pop = new String[N];
        for(int i=0; i<N; i++)
            pop[i] = ruletka(population,fitness,min);
        return pop;
    }

    //Algorytm genetyczny
    public static double[] bestGlobal;
    public static String algorytm_gen(double ai, double bi, int di, int n,
                                          int P, int ni, int xpts, double pm, Fitness fitness, boolean minimize) {
        bestGlobal = new double[P*ni];
        double bestG = minimize?Double.MAX_VALUE-1:Double.MIN_VALUE+1;
        int iterations = 0;
        double max = Double.MIN_VALUE+1;
        double min = Double.MAX_VALUE-1;
        int leng = MiNSI.gen_dlugosc(ai,bi,di);
        String bestChrom = "";
        MiNSI.chrom_dlugosc(leng,n);

        // Krok 1 - Inicjacja - wybór początkowej populacji chromosomów
        String[] pop = stworz_pop(P);
        double[] fitnesses;
        boolean stop = false;
        do {
            // Krok 2 - Ocena przystosowania chromosomów w populacji
            fitnesses = stworz_pop_fit(pop,fitness);
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
            }

            // Krok 3 - Warunek zatrzymania
            if(iterations>=ni)
                break;
            for(int i=0; i<P; i++) {
                bestGlobal[iterations*P+i]=bestG;
            }
            iterations++;

            // Krok 4 - Selekcja chromosomów (Metoda ruletki)
            if(minimize)
                pop = wybierz_pop(pop, fitness, P, true);
            else
                pop = wybierz_pop(pop, fitness, P, false);

            int xp1,xp2=2,xpmin,xpmax;
            int len;
            String[] kids = new String[]{"",""};

            // Krok 5 i 6 Zastosowanie operatorów genetycznych i utworzenie nowej populacji z chromosomów otrzymanych po zastosowaniu selekcji i operatorów genetycznych

            // Krzyżowanie 1 punktowe
            if(xpts==1) {
                for(int i=0; i<pop.length-1; i+=2) {
                    do {
                        xp1 = (int)(pop[i].length()*Math.random());
                    } while(xp1 < 1 || xp1 > pop[i].length()-1);
                    kids = krzyz_1(pop[i],pop[i+1],xp1);
                    pop[i] = kids[0];
                    pop[i+1] = kids[1];
                }
            }

            // Krzyżowanie 2 punktowe i dla dowolnej liczby punktów
            else if(xpts>1) {
                for(int i=0; i<pop.length-1; i+=2) {
                    len = pop[0].length();
                    do {
                        xp1 = ThreadLocalRandom.current().nextInt(1, len/xpts + 1);
                    } while(xp1 < 1 || xp1 > pop[i].length()-1);

                    for(int j=1; j<xpts;j++) {
                        do {
                            xp2 = ThreadLocalRandom.current().nextInt(xp1+1, (j+1)*len/xpts + 1);
                        } while(xp2 < 1 || xp2>= pop[i].length() || xp2 <= xp1);
                        kids = krzyz_2(pop[i],pop[i+1],xp1,xp2);
                        xp1 = xp2;
                    }
                    pop[i] = kids[0];
                    pop[i+1] = kids[1];
                }
            }

            // Mutacja
            for(int i=0; i<pop.length-1; i+=2) {
                pop[i] = mutacja(pop[i],pm);
            }

        } while(true);
        return bestChrom;

    }

    public static void main(String[] args) {
        //Zadanie (przekazywanie funkcji przystosowania jako parametr)
        Fitness fitness = new Fitness() {
            @Override
            public double[] fitnessFunction(String[] population) {
                double[] ary = new double[population.length];
                for(int i=0; i<population.length; i++) {
                    double[] X = MiNSI.dekoduj_chrom(population[i]);
                    ary[i] = MiNSI.f(X[0],X[1]);
                }
                return ary;
            }
        };

        String BDP = algorytm_gen(-2,2,5,2,20,50,2,0.2,fitness,false);
        System.out.println(BDP);
        System.out.println(f(dekoduj_chrom(BDP)[0],dekoduj_chrom(BDP)[1]));

        //Zapis do pliku
        try {
            File file = new File("Wyniki.txt");
            if(!file.exists()) file.createNewFile();

            FileWriter fw = new FileWriter("Wyniki.txt");
            for(int i=0; i<bestGlobal.length; i++)
                fw.write(String.valueOf(bestGlobal[i])+"\n");
            fw.close();
            System.out.println("Zapisano");
        }
        catch (Exception e) {
            System.out.println("Błąd");
        }
    }
}
