package com.company;

public class Main
{
    static Stos<Integer> stosWartości = new Stos<>();
    static Stos<String> stosOperatorów = new Stos<>();

    static void wykonajDziałanie(Stos<Integer> stosW, Stos<String> stosO)
    {
        String a=stosO.zdejmijZeStosu();
        int op1=stosW.zdejmijZeStosu();
        int op2=stosW.zdejmijZeStosu();
        switch(a)
        {
            case"+": stosW.połóżNaStosie(op1+op2);
                break;
            case"*": stosW.połóżNaStosie(op1*op2);
                break;
            case"-": stosW.połóżNaStosie(op2-op1);
                break;
            case"/": stosW.połóżNaStosie(op2/op1);
                break;
        }
    }

    public static void main(String[] args)
    {
        String onp= "4 11 + 5 / 50 22 + 3 * + 7 /";
        String[] podzielonyONP= onp.split(" ");
        int k = 0;

        while( k < podzielonyONP.length)
        {
            String a = podzielonyONP[k];
            if(a.matches("[0-9]*"))
            { stosWartości.połóżNaStosie(Integer.valueOf(a));}
            else
            {stosOperatorów.połóżNaStosie(a);
                wykonajDziałanie(stosWartości, stosOperatorów);}
            k++;
        }
        System.out.println("Wartość końcowa "+ stosWartości.zdejmijZeStosu());
    }
}