﻿using System;
using System.Runtime.CompilerServices;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            Double a, b, c, y, x0, x1, x2;

            Console.WriteLine("Podaj a");
            a = Double.Parse(Console.ReadLine());
            Console.WriteLine("Podaj b");
            b = Double.Parse(Console.ReadLine());
            Console.WriteLine("Podaj c");
            c = Double.Parse(Console.ReadLine());
            y = (b * b) - (4 * a * c);

            if (y > 0)
            {
                x1 = (-b - (Math.Sqrt(y))) / (2 * a);
                x2 = (-b + Math.Sqrt(y)) / (2 * a);
                Console.WriteLine("Miejsca zerowe to " + Math.Round(x1, 3) + " oraz " + Math.Round(x2, 3));
            };

            if (y == 0)
            {
                x0 = (-b) / (2 * a);
                Console.WriteLine("Miejsce zerowe to " + Math.Round(x0, 3));
            };
            
            if (y < 0)
            {
                Console.WriteLine("Niema miejsc zerowych");
            };
        }
    }
}
