using System;

namespace Zad1
{
    class Program
    {
        static void Main(string[] args)
        {
            Int32 a, A, b, B, r, NWD1 = 0, NWD2 = 0;
            Console.WriteLine("Podaj a:");
            a = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj b");
            b = Int32.Parse(Console.ReadLine());
            A = a;
            B = b;
            while (B != 0)
            {
                r = A % B;
                A = B;
                B = r;
                NWD1 = A;
            };
            Console.WriteLine("Dzielenie: " + NWD1);
            while (a != b)
            {
                if (a > b)
                {
                    a -= b;
                }
                else
                {
                    b -= a;
                };
                NWD2 = a;
            };
            Console.WriteLine("Różnica: " + NWD2);
            Console.ReadKey(true);
        }
    }
}
