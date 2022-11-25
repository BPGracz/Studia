using System;
using System.Diagnostics;

namespace Zad10
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("Podaj maksymalny rozmiar twojego przedziału");
            Int32 a = Int32.Parse(Console.ReadLine());
            Int32 b, i, I, ilosc = 0;
            Stopwatch czas = new Stopwatch();
            #region Pierwszy kod
            // Najprostsza metoda sprawdzania liczb pierwszych

            czas.Start();
            Console.WriteLine("Najprostsza metoda sprawdzania liczb pierwszych");
            for (I = 1; I <= a; I++)
            {
                b = 0;
                for (i = 1; i <= I; i++)
                {
                    if (I % i == 0)
                    {
                        b += 1;
                    }
                };

                if (b == 2)
                {
                    ilosc++;
                };
            };
            Console.WriteLine("Ilość liczb pierwszych w przedziale wynosi: " + ilosc);
            ilosc = 0;
            czas.Stop();
            Console.WriteLine("Czas: {0}", czas.Elapsed);
            Console.ReadKey(true);
            #endregion
            #region Drugi kod
            // Pominięcie podzielników 1 i N
            
            czas.Restart();
            Console.WriteLine("Pominięcie podzielników 1 i N");
            for (I = 2; I <= a; I++)
            {
                b = 0;
                for (i = 1; i <= I; i++)
                {
                    if (I % i == 0)
                    {
                        b += 1;
                    }
                };

                if (b == 2)
                {
                    ilosc++;
                };
            };
            Console.WriteLine("Ilość liczb pierwszych w przedziale wynosi: " + ilosc);
            ilosc = 0;
            czas.Stop();
            Console.WriteLine("Czas: {0}", czas.Elapsed);
            Console.ReadKey(true);
            #endregion
            #region Trzeci kod
            // Sprawdzanie "do pierwszej wpadki"

            czas.Restart();
            Console.WriteLine("Sprawdzanie do pierwszej wpadki");
            for (I = 2; I <= a; I++)
            {
                b = 0;
                for (i = 1; i <= I; i++)
                {
                    if (I % i != 0)
                    {
                        continue;
                    }
                    if (I % i == 0)
                    {
                        b += 1;
                    }
                };

                if (b == 2)
                {
                    ilosc++;
                }
            };
            Console.WriteLine("Ilość liczb pierwszych w przedziale wynosi: " + ilosc);
            ilosc = 0;
            czas.Stop();
            Console.WriteLine("Czas: {0}", czas.Elapsed);
            Console.ReadKey(true);
            #endregion
            #region Czwarty kod
            // Sprawdzanie podzielników do √N

            czas.Restart();
            Console.WriteLine("Sprawdzanie podzielników do √N");
            for (I = 1; I <= a; I++)
            {
                b = 1;
                Int32 dzielnik = 1;
                if (I != 1)
                {
                    for (i = 1; i <= Math.Sqrt(I); i++)
                    {
                        if (I % dzielnik == 0)
                        {
                            b += 1;
                        }
                        dzielnik++;
                    };
                };
                
                if (b == 2)
                {
                    ilosc++;
                };
                b = 0;
            };
            Console.WriteLine("Ilość liczb pierwszych w przedziale wynosi: " + ilosc);
            ilosc = 0;
            czas.Stop();
            Console.WriteLine("Czas: {0}", czas.Elapsed);
            Console.ReadKey(true);
            #endregion
            #region Piąty kod
            // Sito Eratostenesa

            czas.Restart();
            Console.WriteLine("Sito Eratostenesa");
            Int32 x, y, z, v;
            Int32[] tabela = new Int32[a];
            tabela[0] = 1;
            for (x = 1; x < a; x++)
            {
                tabela[x] = tabela[x - 1] + 1;
            };
            Double p = Math.Sqrt(a);
            for (y = 2; y < p; y++)
            {
                for (z = 0; z < a - 1; z++)
                {
                    if (tabela[z] != y)
                    {
                        if (tabela[z] % y == 0)
                        {
                            tabela[z] = 1;
                        };
                    };
                };
            };
            for (v = 1; v < a; v++)
            {
                if (tabela[v] != 1 && tabela[v] != a)
                {
                    ilosc++;
                };
            };
            Console.WriteLine("Ilość liczb pierwszych w przedziale wynosi: " + ilosc);
            czas.Stop();
            Console.WriteLine("Czas: {0}", czas.Elapsed);
            #endregion
        }
    }
}
