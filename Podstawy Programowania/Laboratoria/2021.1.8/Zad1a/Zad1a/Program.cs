using System;

namespace Zad1a
{
    class Program
    {
        static void Main(string[] args)
        {
            Double a, sinus, cosinus;
            Console.WriteLine("Wariant a)");
            Console.WriteLine("Stopnie   Sinusy          Cosinusy");
            for (a = 0; a <= 90; a += 10)
            {
                if (a == 0)
                {
                    sinus = Math.Sin((a * Math.PI) / 180);
                    cosinus = Math.Cos((a * Math.PI) / 180);
                    Console.WriteLine("{0}         {1:N6}        {2:N6}", a, sinus, cosinus);
                    a += 10;
                };
                while (a <= 90)
                {
                    Console.Write(a);
                    sinus = Math.Sin((a * Math.PI) / 180);
                    Console.Write("        {0:N6}", sinus);
                    cosinus = Math.Cos((a * Math.PI) / 180);
                    Console.WriteLine("        {0:N6}", cosinus);
                    a += 10;
                };
            };
            Console.ReadKey(true);
        }
    }
}
