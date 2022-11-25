public class Lab6 {

    public static void main(String[] args) {
        System.out.println("\n+++ 1.1 +++\n");
        int leng = MiNSI.gen_dlugosc(-2.0,2.0,5);
        MiNSI.chrom_dlugosc(leng,2);
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

        int N = 10;
        String[] P1 = MiNSI.stworz_pop(N);
        MiNSI.wypisz_pop_i_fit(P1,fitness);

        System.out.println("\n+++ 1.2 +++\n");
        String[] P2 = MiNSI.wybierz_pop(P1,fitness,N,false);
        MiNSI.wypisz_pop_i_fit(P2,fitness);

        System.out.println("\n+++ 1.3 +++\n");
        System.out.println("Średnia wartość FP w populacji przed selekcją: "+MiNSI.policz_srednia_fit(P1,fitness));
        System.out.println("Średnia wartość FP w populacji po selekcji: "+MiNSI.policz_srednia_fit(P2,fitness));

        System.out.println("\n+++ 2.1 +++\n");
        leng = MiNSI.gen_dlugosc(-5.21,5.21,3);
        MiNSI.chrom_dlugosc(leng,10);
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

        N = 10;
        P1 = MiNSI.stworz_pop(N);
        MiNSI.wypisz_pop_i_fit(P1,fitness);

        System.out.println("\n+++ 2.2 +++\n");
        P2 = MiNSI.wybierz_pop(P1,fitness,N,true);
        MiNSI.wypisz_pop_i_fit(P2,fitness);

        System.out.println("\n+++ 2.3 +++\n");
        System.out.println("Średnia wartość FP w populacji przed selekcją: "+MiNSI.policz_srednia_fit(P1,fitness));
        System.out.println("Średnia wartość FP w populacji po selekcji: "+MiNSI.policz_srednia_fit(P2,fitness));

        fitness = new Fitness() {
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

        //String BDP = MiNSI.geneticAlgorithm(-2,2,5,2,50,fitness,false);
        //System.out.println(BDP);
        //System.out.println(MiNSI.f(MiNSI.dekoduj_chrom(BDP)[0],MiNSI.dekoduj_chrom(BDP)[1]));

        // Rastrigin
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

        //BDP = MiNSI.geneticAlgorithm(-5.21,5.21,3,10,100,fitness,true);
        //System.out.println(BDP);
        //System.out.println(MiNSI.rastrigin(MiNSI.dekoduj_chrom(BDP)));


    }
}
