﻿using System;

namespace Zad5
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 n, a, b, i;
            Console.WriteLine("Podaj n-ty wyraz ciągiu Fibonacciego");
            n = Int32.Parse(Console.ReadLine());
            ++n;
            Int32[] F = new Int32[n];
            --n;
            a = 0;
            b = 1;
            F[a] = 0;
            F[b] = 1;
            for (i=2 ; i<F.Length ; i++)
            {
                F[i] = F[a] + F[b];
                a++;
                b++;
                if (i == n)
                {
                    Console.WriteLine("Fibonacci " + i + " wynosi: " + F[i]);
                };
            };
            Console.ReadKey(true);
        }
    }
}
