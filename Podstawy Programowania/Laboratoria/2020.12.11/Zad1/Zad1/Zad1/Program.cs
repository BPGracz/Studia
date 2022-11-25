using System;

namespace Zad1
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
            for (Int32 i = 0; i<rozmiar; i++)
            {
                Int32 wylosowana = losowa.Next(0, rozmiarmaks);
                Tabelka[i] = wylosowana;
                Console.Write(Tabelka[i] + " ");
            };
            Console.ReadKey(true);
        }
    }
}
