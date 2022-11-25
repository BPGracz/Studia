using Microsoft.VisualBasic;
using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {

            Int32 a,b, suma = 0, min=1000, mina=0, minb=0, maks=0, maksa=0, maksb=0, a2, b2;
            Int32 [,] tab1 = new Int32 [4,6];
            Int32 [,] tab2 = new Int32 [6,4];
            Random los = new Random();
            for (a=0 ; a<4 ; a++)
            {
                for (b=0 ; b <6 ; b++)
                {
                    tab1[a,b] = los.Next(100, 999);
                    if (maks<tab1[a,b])
                    {
                        maks = tab1[a,b];
                        maksa = a;
                        maksb = b;
                    };
                    if (min>tab1[a,b])
                    {
                        min = tab1[a, b];
                        mina = a;
                        minb = b;
                    };
                    Console.Write(tab1[a,b] + " ");
                    suma = suma + tab1[a, b];

                };
                Console.WriteLine();
            };
            Console.WriteLine("Suma wynosi " + suma);
            Console.WriteLine("Największa wartość to " + maks);
            Console.WriteLine("Indeksy największej liczby wynoszą a=" + maksa + " b=" + maksb);
            Console.WriteLine("Największa wartość to " + min);
            Console.WriteLine("Indeksy najmniejszej liczby wynoszą a=" + mina + " b=" + minb);

            for (a2=0 ; a2<6 ; a2++)
            {
                for (b2=0 ; b2<a ; b2++)
                {
                    tab2[a2,b2] = tab1[b2,a2];
                    Console.Write(tab2[a2,b2] + " ");
                };
                Console.WriteLine();
            };
            Console.ReadKey(true);
        }
    }
}
