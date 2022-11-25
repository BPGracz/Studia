using System;

namespace Zad2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj rozmiar tablicy");
            Int32 rozmiar = Int32.Parse(Console.ReadLine());
            Int32[] Tabelka = new int[rozmiar];
            Random losowa = new Random();
            Int32 rozmiarmaks = rozmiar * 5;
            Console.WriteLine("Zawartość tablicy:");
            for (Int32 i = 0; i < rozmiar; i++)
            {
                Int32 wylosowana = losowa.Next(0, rozmiarmaks);
                Tabelka[i] = wylosowana;
                Console.Write(Tabelka[i] + " ");
            };

            Console.WriteLine();

            for (Int32 a = 0; a < Tabelka.Length -1; a++)
            {
                for (Int32 b = 0; b < Tabelka.Length - 1; b++)
                {
                    if (Tabelka[b] > Tabelka[b + 1])
                    {
                        Int32 n = Tabelka[b];
                        Tabelka[b] = Tabelka[b + 1];
                        Tabelka[b + 1] = n;
                    };
                };
            };

            Console.WriteLine("Tablica posortowana:");
            for (Int32 j = 0; j < Tabelka.Length; j++)
                Console.Write(Tabelka[j] +" ");
            Console.WriteLine();

            Console.WriteLine("Test poprawności wartosci tabeli, jeśli wartosc została poprawnie rozdyscpocjonowana pojawi się OK jeśli nie to NOT:");
            for (Int32 test = 0; test < Tabelka.Length - 1; test++)
            {
                if (Tabelka[test] <= Tabelka[test + 1])
                {
                    Console.Write(" {0}.OK", test + 1);
                }
                else
                {
                    Console.Write(" {0}.NOT", test + 1);
                };
            };
            Console.ReadKey(true);
        }
    }
}
