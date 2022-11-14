using System;
using System.Drawing;
using System.Threading;

namespace Projekt
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Witaj w programie, który zlicza pola figur płaskich i brył geometrycznych! :)");
            start:
            Console.WriteLine("Czego pole potrzebujesz policzyć?");
            Console.WriteLine("1 - Figury płaskiej");
            Console.WriteLine("2 - Bryły geometrycznej");
            Int32 PB;
            PB = Int32.Parse(Console.ReadLine());
            if (PB == 1)
            {
            figury:
                Console.WriteLine("Jaką figurę płaską chcesz policzyć?");
                Console.WriteLine("1 - Kwadrat");
                Console.WriteLine("2 - Prostokąt");
                Console.WriteLine("3 - Trójkąt");
                Console.WriteLine("4 - Koło");
                Console.WriteLine("5 - Trapez");
                Int32 figura;
                figura = Int32.Parse(Console.ReadLine());
                switch (figura)
                {
                    case 1:
                        double kwadrat, ka;
                        Console.WriteLine("Podaj długość boku kwadratu");
                        ka = Int32.Parse(Console.ReadLine());
                        kwadrat = Math.Pow(ka, 2);
                        Console.WriteLine("Pole twojego kwadratu wynosi: " + kwadrat);
                        break;
                    case 2:
                        Int32 prostokat, pa, pb;
                        Console.WriteLine("Podaj długość jednego boku prostokąta");
                        pa = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Podaj długość drugiego boku prostokąta");
                        pb = Int32.Parse(Console.ReadLine());
                        prostokat = pa * pb;
                        Console.WriteLine("Pole twojego prostokątu wynosi: " + prostokat);
                        break;
                    case 3:
                        Int32 trojkat, ta, th;
                        Console.WriteLine("Podaj długość jednego boku trójkąta");
                        ta = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Podaj wysokość trójkąta");
                        th = Int32.Parse(Console.ReadLine());
                        trojkat = (ta * th) / 2;
                        Console.WriteLine("Pole twojego trójkąta wynosi: " + trojkat);
                        break;
                    case 4:
                        double kolo, kr;
                        Console.WriteLine("Podaj długość promienia koła");
                        kr = Int32.Parse(Console.ReadLine());
                        kolo = Math.PI * Math.Pow(kr, 2);
                        Console.WriteLine("Pole twojego koła wynosi: " + kolo);
                        break;
                    case 5:
                        Int32 trapez, tra, trb, trh;
                        Console.WriteLine("Podaj długość jednej podstawy trapezu");
                        tra = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Podaj długość drugiej podstawy trapezu");
                        trb = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Podaj wysokość trapezu");
                        trh = Int32.Parse(Console.ReadLine());
                        trapez = (tra + trb) * trh / 2;
                        Console.WriteLine("Pole twojego trapezu wynosi: " + trapez);
                        break;
                    default:
                        Console.WriteLine("Nie wybrałeś żadnej figury");
                        goto figury;
                };
            };
            if (PB == 2)
            {
            bryly:
                Console.WriteLine("Jaką bryłę geometryczną chcesz policzyć?");
                Console.WriteLine("1 - Sześcian");
                Console.WriteLine("2 - Prostopadłościan");
                Console.WriteLine("3 - Kula");
                Console.WriteLine("4 - Walec");
                Console.WriteLine("5 - Stożek");
                Int32 bryla;
                bryla = Int32.Parse(Console.ReadLine());
                switch (bryla)
                {
                    case 1:
                        Double szescian, sa;
                        Console.WriteLine("Podaj długość boku kwadratu");
                        sa = Int32.Parse(Console.ReadLine());
                        szescian = 6 * Math.Pow(sa, 2);
                        Console.WriteLine("Pole twojego szescianu wynosi: " + szescian);
                        break;
                    case 2:
                        Int32 prostopadloscian, pa, pb, pc;
                        Console.WriteLine("Podaj długość jednego boku podstawy prostopadloscianu");
                        pa = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Podaj długość drugiego boku podstawy prostopadloscianu");
                        pb = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Podaj wysokość prostopadloscianu");
                        pc = Int32.Parse(Console.ReadLine());
                        prostopadloscian = 2 * (pa * pb + pa * pc + pb * pc);
                        Console.WriteLine("Pole twojego prostopadłościanu wynosi: " + prostopadloscian);
                        break;
                    case 3:
                        Double kula, kr;
                        Console.WriteLine("Podaj długość promienia kuli");
                        kr = Int32.Parse(Console.ReadLine());
                        kula = 4 * Math.PI * Math.Pow(kr, 2);
                        Console.WriteLine("Pole twojej kuli wynosi: " + kula);
                        break;
                    case 4:
                        Double walec, wr, wh;
                        Console.WriteLine("Podaj długość promienia podstawy walca");
                        wr = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Podaj wysokość walca");
                        wh = Int32.Parse(Console.ReadLine());
                        walec = 2 * Math.PI * wr * (wr + wh);
                        Console.WriteLine("Pole twojego walca wynosi: " + walec);
                        break;
                    case 5:
                        Double stozek, sr, sl;
                        Console.WriteLine("Podaj długość promienia podstawy stożka");
                        sr = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Podaj długość tworzącej stożka");
                        sl = Int32.Parse(Console.ReadLine());
                        stozek = Math.PI * sr * (sr + sl);
                        Console.WriteLine("Pole twojego stożka wynosi: " + stozek);
                        break;
                    default:
                        Console.WriteLine("Nie wybrałeś żadnej bryły");
                        goto bryly;
                };
            }
            else
            {
                Console.WriteLine("Nie wybrałeś żadnego pola");
                goto start;
            };
            Console.ReadKey(true);
        }
    }
}
