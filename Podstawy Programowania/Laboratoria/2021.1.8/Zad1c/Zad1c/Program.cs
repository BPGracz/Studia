using System;

namespace Zad1cid
{
    class Program
    {
        class Tools
        {
            static double SinFmDeg(int Deg)
            {
                double Sin = Math.Sin(Math.PI * Deg / 180.0);
                return Sin;
            }
            static double CosFmDeg(int Deg)
            {
                double Cos = Math.Cos(Math.PI * Deg / 180.0);
                return Cos;
            }
            public static void Wariantcid()
            {
                Console.WriteLine("Sinusy:");
                for (int i = 0; i <= 90; i += 10)
                {
                    Console.WriteLine("Dla " + i + " stopni: " + Math.Round(Tools.SinFmDeg(i), 6) + " rad");
                }
                Console.WriteLine("------------------------------------------------" + Environment.NewLine + "Cosinusy:");
                for (int i = 0; i <= 90; i += 10)
                {
                    Console.WriteLine("Dla " + i + " stopni: " + Math.Round(Tools.CosFmDeg(i), 6) + " rad");
                }
            }
        }
        static void Main(string[] args)
        {
            Tools.Wariantcid();
            Console.ReadKey(true);
        }
    }
}
