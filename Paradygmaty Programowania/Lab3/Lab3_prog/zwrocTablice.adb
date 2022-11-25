with Ada.Command_Line; use Ada.Command_Line;
with Gnat.Io; use Gnat.Io;

procedure zwrocTablice is
-- definicja typu
type Wektor is array (Positive range 1..10) of Integer;
-- deklaracja dwóch wektorów 
M, O: Wektor;

-- definicja funkcji 
function Odwroc_Wektor (V : Wektor) return Wektor is
  Wynik : Wektor;

begin
  -- jakie są wartości w wektorze V?
 -- produkcja wektora wyjsciowego
 for i in Wynik'Range loop
   	Wynik(i) :=V(10-i+1);
  end loop;
  New_Line;
  -- jakie są teraz wartości w wektorze V?
  return Wynik;
end Odwroc_Wektor;

begin
  Put("wektor generowany w programie glownym"); New_Line;
  for i in M'Range loop
    M(i):=  2 * i;
	Put(M(i)); Put(", "); 
  end loop;  
  New_Line;
  O:=Odwroc_Wektor(M);
 Put("tablica O odwrocona przez funkcje"); New_Line;
-- wyświetl  zawartość tablicy O
 -- jakie liczby są teraz w tablicy M?
-- czy prawidłowe będzie wywołamie M=Odwroc_Wektor(M)????
 
end zwrocTablice;