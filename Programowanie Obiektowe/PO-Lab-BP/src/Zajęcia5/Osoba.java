package Zajêcia5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Osoba {
	String nazwisko = "Kowalski";
	String imiê = "Jan";
	String dataUr = "1999-10-12";
	static LocalDate dzisiaj=LocalDate.now();
	static int bRok = dzisiaj.getYear();
	static int bMiesi¹c = dzisiaj.getMonthValue();
	
static ArrayList<Osoba> listaOsób = new ArrayList<Osoba>();

public Osoba(String imiê, String nazwisko, String dataUr) {
	this.imiê=imiê;
	this.nazwisko=nazwisko;
	this.dataUr=dataUr;
	listaOsób.add(this);
}
	
public Osoba() {listaOsób.add(this);}
	
static double wiek(String dataUr) {
	String[] data=dataUr.split("-");
	int lata=bRok-Integer.parseInt(data[0]);
	int miesi¹ce=bMiesi¹c-Integer.parseInt(data[1]);
	if(miesi¹ce<0) {lata-=1; miesi¹ce=12+miesi¹ce;}
	return lata + miesi¹ce/12.0;
}

public String toString() {
	return "Imiê:	" + this.imiê + "\nNazwisko:	" + this.nazwisko + "\nData ur.:	" + this.dataUr + String.format("\nWiek:	%5.2f",wiek(dataUr));
}

	public static void main(String[] args) {
		
		Osoba obiekt1 = new Osoba();
		Osoba obiekt2 = new Osoba("Beata","Gargie³","1987-01-05");
		Osoba obiekt3 = new Osoba("Gargamel","Deniro","1989-06-24");
		Osoba obiekt4 = new Osoba("Arek","Odmarek","1998-11-17");
		
		System.out.println(obiekt1.toString());
		obiekt1.dataUr = "2009-05-28";
		
		double starszy;
		double m³odszy;
		
		for (int i=1;i<listaOsób.size();i++) {
			if (wiek(listaOsób.get(i).dataUr) < starszy) {
				starszy = wiek(listaOsób.get(i).dataUr); 
				m³odszy = i;
			}
			System.out.println(toString(listaOsób.get(m³odszy)));
		}
		
		
		
	}

}
