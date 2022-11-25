with Ada.Command_Line; use Ada.Command_Line;
with Gnat.Io; use Gnat.Io;
-- Przekazywanie parametrów przez wartość i wynik
procedure zamiana is

  zm: Integer;
  lista : Array (Positive range 1..5) of Integer;
     
  Procedure zamien(a : in out Integer; b : in out Integer)
  is
    pom :Integer;
        
   begin
      pom := a;
      a := b;
      b := pom;
  end zamien;
  
  begin
    zm :=2;
	-- wypelnienie tablicy
    Put("wygenerowana lista: "); 
	for i in 1..5 loop
	  lista(i):= 2*i-1;
	  put(lista(i)); Put(", "); 
	end loop;  
	New_Line;
	zamien(zm, lista(zm)); 
    Put("Po zamianie: zm= "); Put(zm);
	-- wyswietl wynik zamiany
	 
	-- Jakie tu było niebezpieczeństwo? Kiedy parametry zostały przekazane do procedury?
	-- Co się dzieje, gdy tryby parametrów (in out) zmieniasz na in, na out?
end zamiana;