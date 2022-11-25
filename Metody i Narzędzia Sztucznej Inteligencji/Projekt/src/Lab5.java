public class Lab5 {

    public static void main(String[] args) {
        System.out.println("\n+++ 1.1 +++");
        int leng = MiNSI.gen_dlugosc(-2.0,2.0,5);
        MiNSI.chrom_dlugosc(leng,2);
        String[] pop = MiNSI.stworz_pop(17);

        System.out.println("\n+++ 1.2 +++");
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
        double[] popFitnesses = MiNSI.stworz_pop_fit(pop, fitness);

        System.out.println("\n+++ 1.3 +++\n");
        System.out.println("Populacja:");
        MiNSI.wypisz_pop(pop);
        System.out.println("\nWartości funkcji przystosowania:");
        MiNSI.wypisz_pop_fit(pop,fitness);
        System.out.println("\nPopulacja i jej wartości funkcji przystosowania:");
        MiNSI.wypisz_pop_i_fit(pop,fitness);

        System.out.println("\n+++ 1.4 +++\n");
        System.out.println("Średnia wartość funkcji przystosowania = "+MiNSI.policz_srednia_fit(pop,fitness));

        System.out.println("\n+++ 1.5 +++\n");
        System.out.println("Liczba osobników o wartości funkcji przystosowania poniżej średniej = "+
                MiNSI.policz_ilosc_person_ponizej_sredniej(pop,fitness));

        System.out.println("\n+++ 1.6 +++\n");
        System.out.println("Liczba osobników o wartości funkcji przystosowania równej lub wyższj od średniej = "+
                MiNSI.policz_ilosc_person_powyzej_lub_rownej_sredniej(pop,fitness));



        System.out.println("\n+++ 2.1 +++");
        MiNSI.A = 10;
        leng = MiNSI.gen_dlugosc(-5.21,5.21,3);
        MiNSI.chrom_dlugosc(leng,10);
        pop = MiNSI.stworz_pop(17);

        System.out.println("\n+++ 2.2 +++");
        fitness = new Fitness() {
            @Override
            public double[] fitnessFunction(String[] population) {
                double[] ary = new double[population.length];
                for(int i=0; i<population.length; i++) {
                    double[] X = MiNSI.dekoduj_chrom(population[i]);
                    ary[i] = MiNSI.rastrigin(X);
                }
                return ary;
            }
        };
        popFitnesses = MiNSI.stworz_pop_fit(pop, fitness);

        System.out.println("\n+++ 2.3 +++\n");
        System.out.println("Populacja:");
        MiNSI.wypisz_pop(pop);
        System.out.println("\nWartości funkcji przystosowania:");
        MiNSI.wypisz_pop_fit(pop,fitness);
        System.out.println("\nPopulacja i jej wartości funkcji przystosowania:");
        MiNSI.wypisz_pop_i_fit(pop,fitness);

        System.out.println("\n+++ 2.4 +++\n");
        System.out.println("Średnia wartość funkcji przystosowania = "+MiNSI.policz_srednia_fit(pop,fitness));

        System.out.println("\n+++ 2.5 +++\n");
        System.out.println("Liczba osobników o wartości funkcji przystosowania poniżej średniej = "+
                MiNSI.policz_ilosc_person_ponizej_sredniej(pop,fitness));

        System.out.println("\n+++ 2.6 +++\n");
        System.out.println("Liczba osobników o wartości funkcji przystosowania równej lub wyższj od średniej = "+
                MiNSI.policz_ilosc_person_powyzej_lub_rownej_sredniej(pop,fitness));
    }


}
