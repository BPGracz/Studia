using System;
using System.Diagnostics;

namespace Zad7
{
    class Program
    {
        static void sortowanie(Int32[] Tabelka)
        {
            for (Int32 n = 0; n < Tabelka.Length - 1; n++)
            {
                for (Int32 j = n+1; j < Tabelka.Length; j++)
                {
                    if (Tabelka[j]<Tabelka[n])
                    {
                        Int32 t = Tabelka[j];
                        Tabelka[j] = Tabelka[n];
                        Tabelka[n] = t;
                    };
                };
            };
        }
        static void Main(string[] args)
        {
            Stopwatch czas;
            czas = Stopwatch.StartNew();
            Int32[] Tabelka = new Int32[100];
            Random losowa = new Random();

            for (Int32 i = 0; i < 100; i++)
            {
                Int32 wylosowana = losowa.Next(0, 100);
                Tabelka[i] = wylosowana;
            };

            czas.Restart();

            sortowanie(Tabelka);

            czas.Stop();
            Console.WriteLine("czas: {0}", czas.Elapsed);

            /*for (Int32 j = 0; j < Tabelka.Length; j++)
                Console.Write(Tabelka[j] + " ");*/

            Int32[] Tabelka2 = new Int32[1000];

            for (Int32 i = 0; i < 1000; i++)
            {
                Int32 wylosowana = losowa.Next(0, 1000);
                Tabelka2[i] = wylosowana;
            };

            czas.Restart();

            sortowanie(Tabelka2);

            czas.Stop();
            Console.WriteLine();
            Console.WriteLine("czas: {0}", czas.Elapsed);

            /*for (Int32 j = 0; j < Tabelka2.Length; j++)
                Console.Write(Tabelka2[j] + " ");*/

            Int32[] Tabelka3 = new Int32[10000];

            for (Int32 i = 0; i < 10000; i++)
            {
                Int32 wylosowana = losowa.Next(0, 10000);
                Tabelka3[i] = wylosowana;
            };

            czas.Restart();

            sortowanie(Tabelka3);

            czas.Stop();
            Console.WriteLine();
            Console.WriteLine("czas: {0}", czas.Elapsed);

            /*for (Int32 j = 0; j < Tabelka3.Length; j++)
                Console.Write(Tabelka3[j] + " ");*/

            Console.WriteLine();
            Console.WriteLine("Test poprawności wartosci tabeli, jeśli wartosc została poprawnie rozdyscpocjonowana pojawi się OK jeśli nie to NOT:");
            for (Int32 test = 0; test < Tabelka.Length - 1; test++)
            {
                if (Tabelka[test] <= Tabelka[test + 1])
                {
                    Console.Write("{0}.OK ", test + 1);
                }
                else
                {
                    Console.Write("{0}.NOT ", test + 1);
                };
            };
            Console.ReadKey(true);
        }
    }
}
