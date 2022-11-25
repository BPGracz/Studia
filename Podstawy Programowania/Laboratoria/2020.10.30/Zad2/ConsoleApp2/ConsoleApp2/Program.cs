using System;

namespace Zad2
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 i, a = 9;
            Int32[] tab1 = new int[10];
            for (i = 0; i < 10; ++i)
            {
                tab1[i] = a;
                Console.WriteLine("Indeks " + i + " wynosi " + a);
                --a;
            };
            Console.ReadKey(true);
        }
    }
}
