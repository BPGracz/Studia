using System;
using System.Runtime.CompilerServices;

namespace Zad6
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 x, y;
            Int32 [,] tab1 = new Int32 [10,10];
            Random los = new Random();
            for (x=0 ; x<10 ; x++)
            {
                for (y=0 ; y<10 ; y++)
                {
                    tab1 [x,y] = los.Next(0,999);
                    Console.Write(tab1[x, y] + " ");
                    if (tab1[x,y]<10)
                    {
                        Console.Write(" ");
                    };
                    if (tab1[x,y]<100)
                    {
                        Console.Write(" ");
                    };
                };
                Console.WriteLine();
            };
            Console.ReadKey(true);
        }
    }
}
