﻿using System;

namespace Zad9
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 a, b, i, I, ilosc = 0;
            Console.WriteLine("Podaj maksymalny rozmiar twojego przedziału");
            a = Int32.Parse(Console.ReadLine());
            for (I = 1; I <= a; I++)
            {
                b = 0;
                for (i = 1; i <= I; i++)
                {
                    if (I % i == 0)
                    {
                        b += 1;
                    }
                };
                if (b == 2)
                {
                    ilosc++;
                };
            };
            Console.WriteLine("Ilość liczb pierwszych w przedziale wynosi: " + ilosc);
            Console.ReadKey(true);
        }
    }
}
