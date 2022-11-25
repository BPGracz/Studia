with Ada.Command_Line; use Ada.Command_Line;
with Gnat.Io; use Gnat.Io;

procedure testZakres is

  x: Integer := 5;
     
  -- Procedure Proc1;
  -- Procedure Proc2;
  -- tak oznacza się komentarz w Adzie

 Procedure Proc1
  is
    x :Integer:=7;

    procedure Proc2 
   is
    y: Integer;
    
   begin
    y:= x;
    Put("wartosc y z Proc2: ");
    Put(y);
    New_Line;
	
   end Proc2;

   begin
    Proc2;
  end Proc1;

  begin
  Proc1;
Put("wartosc y z Proc2: ");
Put(y);
   
end testZakres;