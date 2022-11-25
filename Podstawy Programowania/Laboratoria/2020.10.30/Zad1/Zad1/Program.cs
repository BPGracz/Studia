using System;

namespace Zad5
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 i;
            Int32[] tab1 = new int[20];
            Random liczba = new Random();
            for (i=0;i<=20;++i)
            {
                tab1[i] = liczba.Next(0,9);
                Console.WriteLine("Numer indeksu: "+ i + " jest równe " + tab1[i]);
            };
            Console.ReadKey(true);
        }
    }
}
