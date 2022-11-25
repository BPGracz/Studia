package Zajêcia4;

import java.util.ArrayList;

public class Uczeñ extends Osoba {
	String szko³a = "LO 123";
	String profil = "Mat-fiz";
	String dataRozp = "2017-09-01";
	Double œrednia = 4.07;
	static ArrayList<Uczeñ> listaUczniów = new ArrayList<>();

	public Uczeñ(String a, String b, String c, String d, String e, double x) {
		imiê = a;
		nazwisko = b;
		dataUr = c;
		szko³a  = d;
		dataRozp = e;
		œrednia = x;
		listaUczniów.add(this);
	}
	public Uczeñ() {listaUczniów.add(this);}
	
	public String toString( ) {
		return super.toString()+"\nszko³a:	"+ szko³a+"\nprofil:	"+ profil+"\nrozpocz¹³:	"+ dataRozp+	"\nuczy siê :"+String.format("%5.2f", wiek(dataRozp))+ " lat "+ String.format("\nœrednia %5.2f", œrednia); 
	}
	
	public boolean jestRówny(Uczeñ inny) {
		return this.imiê.equals(inny.imiê) && this.nazwisko.equals(inny.nazwisko) && this.dataUr.equals(inny.dataUr);
	}
	
	public static Uczeñ okreœlUczniaZMaxŒredni¹() {
		Uczeñ zMaxOcen¹ = listaUczniów.get(0);
		for(int i = 1; i<listaUczniów.size(); i++)
			if(listaUczniów.get(i).œrednia>zMaxOcen¹.œrednia)
				zMaxOcen¹ = listaUczniów.get(i);
		return zMaxOcen¹;
	}
	
	static Uczeñ okreœlUczniaNajstarszego() {
		Uczeñ ity;
		Uczeñ najstarszy=listaUczniów.get(0);
		for (int i = 1; i<listaUczniów.size(); i++) {
			ity=listaUczniów.get(i);
			if (ity.wiek(ity.dataUr)>najstarszy.wiek(najstarszy.dataUr))
				najstarszy=ity;
		}
		return najstarszy;
	}
	
	static boolean zamieñUczniów() {
		Uczeñ ity;
		Uczeñ najstarszy=listaUczniów.get(0);
		Uczeñ najm³odszy=listaUczniów.get(0);
		for (int i = 1; i<listaUczniów.size(); i++) {
			ity=listaUczniów.get(i);
			if (ity.wiek(ity.dataUr)>najstarszy.wiek(najstarszy.dataUr))
				najstarszy=ity;
		}
		for (int i = 1; i<listaUczniów.size(); i++) {
			ity=listaUczniów.get(i);
			if (ity.wiek(ity.dataUr)<najm³odszy.wiek(najm³odszy.dataUr))
				najm³odszy=ity;
		}
		for (int i = 1; i<listaUczniów.size(); i++) {
			ity=listaUczniów.get(i);
			if(ity == najm³odszy) {
				ity = najm³odszy;
			}
			else if (ity == najstarszy)
				ity = najstarszy;
		}
		return true;
	}
	
	public static void main(String[] args) {
	
		//Uczeñ st = new Uczeñ();
		//Uczeñ st1 = new Uczeñ();
		//System.out.println("s¹ równi "+st.jestRówny(st1));
		//System.out.println("s¹ równi "+(st==st1));
		
		Uczeñ uczen1 = new Uczeñ("W³odek", "Markowicz", "1989-09-18", "LO nr3", "2005-09-01", 4.46);
		Uczeñ uczen2 = new Uczeñ("Robert", "Mak³owicz", "1999-06-27", "LO nr4", "2015-09-01", 4.32);
		Uczeñ uczen3 = new Uczeñ("Emanuel", "Iwanowicz", "1998-12-31", "LO nr1", "2014-09-01", 5.78);
		Uczeñ uczen4 = new Uczeñ("Kontantyn", "Micha³owicz", "1995-11-07", "LO nr2", "2011-09-01", 4.90);
		
		/*
		System.out.println(uczen1.toString());
		System.out.println(uczen2.toString());
		System.out.println(uczen3.toString());
		System.out.println(uczen4.toString());
		
		System.out.println(uczen1.jestRówny(uczen2));
		System.out.println(uczen2.jestRówny(uczen3));
		System.out.println(uczen3.jestRówny(uczen4));
		
		for (int i = 0; i<listaUczniów.size(); i++) {
			for (int j = 0 ; j<listaUczniów.size(); j++) {
				if (i != j) {
					System.out.println(i + " Jest równy " + j + " " + listaUczniów.get(i).jestRówny(listaUczniów.get(j)));
				}	
			}
			
		}
		*/
		
		/*
		Uczeñ zMaxSr = okreœlUczniaZMaxŒredni¹();
		System.out.println(zMaxSr.nazwisko+" "+zMaxSr.imiê);
		System.out.println(zMaxSr);
		
		System.out.println("----------------------------------------------------");
		
		Uczeñ Najstarszy = okreœlUczniaNajstarszego();
		System.out.println(Najstarszy.nazwisko+" "+Najstarszy.imiê);
		System.out.println(Najstarszy);
		*/
		
		boolean Zamiana = zamieñUczniów();
		System.out.println(Zamiana);
		for (int i = 0; i<listaUczniów.size(); i++) 
			System.out.println(listaUczniów.get(i));
			System.out.println("------------------------------------");
		}
	}
}
