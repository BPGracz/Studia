using System;

namespace Zad7
{
    class Program
    {
        static void Main(string[] args)
        {

            Int32 a, b, i;
            Console.WriteLine("Podaj liczbe pierwszą");
            a = Int32.Parse(Console.ReadLine());
            b = 0;
            for (i=1;i<=a;i++)
            {
                if (a % i == 0)
                {
                    b += 1;
                }
            };
            if (b == 2)
            {
                Console.WriteLine("Podana przez cb liczba jest pierwsza");
            }
            else
            {
                Console.WriteLine("Podana przez cb liczba nie jest pierwsza");
            };
            Console.ReadKey(true);

        }
    }
}
