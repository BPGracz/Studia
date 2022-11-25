package Zaj�cia5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Osoba {
	String nazwisko = "Kowalski";
	String imi� = "Jan";
	String dataUr = "1999-10-12";
	static LocalDate dzisiaj=LocalDate.now();
	static int bRok = dzisiaj.getYear();
	static int bMiesi�c = dzisiaj.getMonthValue();
	
static ArrayList<Osoba> listaOs�b = new ArrayList<Osoba>();

public Osoba(String imi�, String nazwisko, String dataUr) {
	this.imi�=imi�;
	this.nazwisko=nazwisko;
	this.dataUr=dataUr;
	listaOs�b.add(this);
}
	
public Osoba() {listaOs�b.add(this);}
	
static double wiek(String dataUr) {
	String[] data=dataUr.split("-");
	int lata=bRok-Integer.parseInt(data[0]);
	int miesi�ce=bMiesi�c-Integer.parseInt(data[1]);
	if(miesi�ce<0) {lata-=1; miesi�ce=12+miesi�ce;}
	return lata + miesi�ce/12.0;
}

public String toString() {
	return "Imi�:	" + this.imi� + "\nNazwisko:	" + this.nazwisko + "\nData ur.:	" + this.dataUr + String.format("\nWiek:	%5.2f",wiek(dataUr));
}

	public static void main(String[] args) {
		
		Osoba obiekt1 = new Osoba();
		Osoba obiekt2 = new Osoba("Beata","Gargie�","1987-01-05");
		Osoba obiekt3 = new Osoba("Gargamel","Deniro","1989-06-24");
		Osoba obiekt4 = new Osoba("Arek","Odmarek","1998-11-17");
		
		System.out.println(obiekt1.toString());
		obiekt1.dataUr = "2009-05-28";
		
		double starszy;
		double m�odszy;
		
		for (int i=1;i<listaOs�b.size();i++) {
			if (wiek(listaOs�b.get(i).dataUr) < starszy) {
				starszy = wiek(listaOs�b.get(i).dataUr); 
				m�odszy = i;
			}
			System.out.println(toString(listaOs�b.get(m�odszy)));
		}
		
		
		
	}

}
