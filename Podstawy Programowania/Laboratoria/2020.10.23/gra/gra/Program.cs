﻿using System;

namespace gra
{
    class Program
    {
        static void Main(string[] args)
        {
            Random liczba = new Random();
            Int32 a, b, c;
            a = liczba.Next(0,5);
            Console.WriteLine("Zgadnij liczbę z przedziału od 0 do 100 masz na to 6 prób. Powodzenia.");
            for (b = 5; b >= 0; b--)
            {
                c = Int32.Parse(Console.ReadLine());
                if (c>a)
                {
                    Console.WriteLine("Liczba wylosowana przez komputer jest mniejsza. Pozostało ci prób " + b + ".");
                }
                if (c<a)
                {
                    Console.WriteLine("Liczba wylosowana przez komputer jest większa. Pozostało ci prób " + b + ".");
                };
                if (c==a)
                {
                    Console.WriteLine("Udało ci się odgadnąć liczbę!");
                    break;
                };
                if (b == 0)
                {
                    Console.WriteLine("Nie udało ci się odgadnąć liczby.");
                };
            };
        }
    }
}
