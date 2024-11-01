﻿using Microsoft.VisualBasic;
using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Security.Cryptography.X509Certificates;

namespace Zad4
{
    class Program
    {
        static void Main(string[] args)
        {
            // Wariant 1

            System.Diagnostics.Stopwatch wariant1;
            wariant1 = System.Diagnostics.Stopwatch.StartNew();
            Int32 a, c, NWD1 = 0, x, y;
            Console.WriteLine("Podaj liczbę");
            a = Int32.Parse(Console.ReadLine());
            x = a;
            losuj:
            Random wyzsza = new Random();
            Int32 b = wyzsza.Next(x, 100);
            y = b;
            while (b != 0)
            {
                c = a % b;
                a = b;
                b = c;
                NWD1 = a;
            };
            if (NWD1 == 1)
            {
                Console.WriteLine("Liczba " + x + " i liczba wylosowana " + y + " są względnie do siebie pierwsze");
            }
            else
            {
                Console.WriteLine("Liczba " + x + " i liczba wylosowana " + y + " nie są względnie do siebie pierwsze");
                goto losuj;
            };
            wariant1.Stop();
            Console.WriteLine("Czas: {0}", wariant1.Elapsed);
            Console.ReadKey(true);

            // Wariant 2

            System.Diagnostics.Stopwatch wariant2;
            wariant2 = System.Diagnostics.Stopwatch.StartNew();
            Int32 podana, C, NWD2 = 0, X, Y;
            Console.WriteLine("Podaj liczbe");
            podana = Int32.Parse(Console.ReadLine());
            los:
            Random losowe = new Random();
            Int32 A = losowe.Next(podana, 100);
            X = A;
            Int32 B = losowe.Next(podana, 100);
            Y = B;
            while (B != 0)
            {
                C = A % B;
                A = B;
                B = C;
                NWD2 = A;
            };
            if (NWD2 == 1)
            {
                Console.WriteLine("Liczba " + X + " i liczba wylosowana " + Y + " są względnie do siebie pierwsze");
            }
            else
            {
                Console.WriteLine("Liczba " + X + " i liczba wylosowana " + Y + " nie są względnie do siebie pierwsze");
                goto los;
            };
            wariant2.Stop();
            Console.WriteLine("Czas: {0}", wariant2.Elapsed);
            Console.ReadKey(true);
        }
    }
}
