using System;

namespace Zad6
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Wprowadź ciąg znaków");
            string x = Console.ReadLine();
            string[] tabx = x.Split(',');
            Int32[] tabx_int32 = new Int32[tabx.Length];
            for (Int32 i = 0; i < tabx.Length; i++)
            {
                tabx_int32[i] = Int32.Parse(tabx[i]);
                Console.WriteLine("Liczba {0}   Kwadrat liczby {1}", tabx_int32[i], Math.Pow(tabx_int32[i],2));
            }
            Console.ReadKey(true);
        }
    }
}
