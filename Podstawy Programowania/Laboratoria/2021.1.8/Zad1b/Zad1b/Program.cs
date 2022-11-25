using System;

namespace Zad1b
{
    class Program
    {
        class Tools
        {
            static double Deg2Rad(int Deg)
            {
                double Rad = Math.PI * Deg / 180.0;
                return Rad;
            }
            public static void Wariantb()
            {
                Console.WriteLine("Sinusy:");
                for (int i = 0; i <= 90; i += 10)
                {
                    Console.WriteLine("Dla " + i + " stopni: " + Math.Round(Math.Sin(Tools.Deg2Rad(i)), 6) + " rad");
                }
                Console.WriteLine("------------------------------------------------" + Environment.NewLine + "Cosinusy:");
                for (int i = 0; i <= 90; i += 10)
                {
                    Console.WriteLine("Dla " + i + " stopni: " + Math.Round(Math.Cos(Tools.Deg2Rad(i)), 6) + " rad");
                }
            }
        }
        static void Main(string[] args)
        {
            Tools.Wariantb();
            Console.ReadKey(true);
        }
    }
}
