﻿using System;

namespace Zad8
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 a, b, i, I;
            Console.WriteLine("Podaj maksymalny rozmiar twojego przedziału");
            a = Int32.Parse(Console.ReadLine());
            for (I=1;I<a;I++)
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
                    Console.Write(I + " ");
                };
            };
            Console.ReadKey(true);
        }
    }
}
