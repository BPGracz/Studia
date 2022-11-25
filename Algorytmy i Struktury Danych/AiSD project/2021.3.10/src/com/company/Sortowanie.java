package com.company;

public class Sortowanie
{
    Kolejka <Trójka> kTr = new Kolejka<>();

    public static void main(String[] args) {

        Sortowanie obiekt = new Sortowanie();
        int[] lista = {4, 6, 3, 47, 34, 7, 8, 10, 12, 5, 78};
        int[] pomocnicza = new int[lista.length];
        int ile = obiekt.utwórzTrójki(lista.length);             // TODO Auto-generated method stub
        System.out.println(ile);

        Trójka trójka;

        for (int i = 0; i < ile; i++) {
            trójka = obiekt.kTr.pobierzPierwszego();
            if (trójka.x == 0) for (int k = 0; k < lista.length; k++) pomocnicza[k] = lista[k];

            obiekt.scal(lista, pomocnicza, trójka.x, trójka.y, trójka.z);
        }
        for (int k = 0; k < lista.length; k++) System.out.print(lista[k] + " ");

        System.out.println();

    }

    int utwórzTrójki(int n)
    {
        int numer=0;
        int tr1,tr2,tr3,pzakres;
        for(int zakres=2; zakres<2*n; zakres*=2)
        {
            for (int x=0; x<n; x+=zakres)
            {
                tr1=x; tr2=x+(zakres-1)/2;
                pzakres=zakres;
                while (tr2>n-1) {
                    pzakres=pzakres/2; tr2=x+(pzakres-1)/2;}
                tr3=x+zakres-1;
                if(tr3>n-1) tr3=n-1;
                kTr.dodajDoKolejki(new Trójka(tr1,tr2,tr3));
                System.out.println(tr1+" "+tr2+" "+tr3);
                numer ++;
            }
        }
        return numer;
    }
    void scal(int[] lista, int[] pomocnicza, int odPoz, int srodek, int doPoz)
    {
        int i=odPoz, j=srodek+1;
        for (int k=odPoz; k<=doPoz; k++)
        {
            if (i>srodek) lista[k]=pomocnicza[j++];
            else if (j>doPoz) lista[k]=pomocnicza[i++];
            else if (pomocnicza[j]<pomocnicza[i]) lista[k]=pomocnicza[j++];
            else lista[k]=pomocnicza[i++];
        }
    }

}
class Trójka
{
    int x, y, z;
    public Trójka(int x, int y, int z)
    {
        this.x=x;
        this.y=y;
        this.z=z;

    }
    public Trójka() {}
}