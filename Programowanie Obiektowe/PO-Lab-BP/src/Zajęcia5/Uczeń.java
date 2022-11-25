package Zaj�cia5;

import java.util.ArrayList;

public class Ucze� extends Osoba {
	String szko�a = "LO 123";
	String profil = "Mat-fiz";
	String dataRozp = "2017-09-01";
	Double �rednia = 4.07;
	static ArrayList<Ucze�> listaUczni�w = new ArrayList<>();

	public Ucze�(String a, String b, String c, String d, String e, double x) {
		imi� = a;
		nazwisko = b;
		dataUr = c;
		szko�a  = d;
		dataRozp = e;
		�rednia = x;
		listaUczni�w.add(this);
	}
	public Ucze�() {listaUczni�w.add(this);}
	
	public String toString( ) {
		return super.toString()+"\nszko�a:	"+ szko�a+"\nprofil:	"+ profil+"\nrozpocz��:	"+ dataRozp+	"\nuczy si� :"+String.format("%5.2f", wiek(dataRozp))+ " lat "+ String.format("\n�rednia %5.2f", �rednia); 
	}
	
	public boolean jestR�wny(Ucze� inny) {
		return this.imi�.equals(inny.imi�) && this.nazwisko.equals(inny.nazwisko) && this.dataUr.equals(inny.dataUr);
	}
	
	public static void main(String[] args) {
	
		//Ucze� st = new Ucze�();
		//Ucze� st1 = new Ucze�();
		//System.out.println("s� r�wni "+st.jestR�wny(st1));
		//System.out.println("s� r�wni "+(st==st1));
		
		Ucze� uczen1 = new Ucze�("Mi�osz", "Markowicz", "1989-09-18", "LO nr3", "2005-09-01", 4.46);
		Ucze� uczen2 = new Ucze�("Robert", "Mak�owicz", "1999-06-27", "LO nr4", "2015-09-01", 4.32);
		Ucze� uczen3 = new Ucze�("Emanuel", "Iwanowicz", "1998-12-31", "LO nr1", "2014-09-01", 5.78);
		Ucze� uczen4 = new Ucze�("Kontantyn", "Micha�owicz", "1995-11-07", "LO nr2", "2011-09-01", 4.90);
		
		System.out.println(uczen1.toString());
		System.out.println(uczen2.toString());
		System.out.println(uczen3.toString());
		System.out.println(uczen4.toString());
		
		System.out.println(uczen1.jestR�wny(uczen2));
		System.out.println(uczen2.jestR�wny(uczen3));
		System.out.println(uczen3.jestR�wny(uczen4));
		
		for (int i = 0; i<listaUczni�w.size(); i++) {
			for (int j = 0 ; j<listaUczni�w.size(); j++) {
				if (i != j) {
					System.out.println(i + " Jest r�wny " + j + " " + listaUczni�w.get(i).jestR�wny(listaUczni�w.get(j)));
				}	
			}
			
		}
		
	}

}
