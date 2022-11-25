package Zaj�cia8;

import java.util.ArrayList;

import Zaj�cia4.Osoba;

public class PAbstrak extends Abstrakcyjna<Osoba> {
	public static ArrayList<Osoba> lista = new ArrayList<Osoba>();
	public void dodaj(Osoba x) {lista.add(x);}
	public boolean wyst�puje(Osoba x) {
		for(Osoba xx:lista) {if (xx.jestR�wna(x)) return true;}
		return false;
	}

	public static void main(String[] args) {
		
		PAbstrak obiekt = new PAbstrak();
		obiekt.dodaj(new Osoba("Kowal","�bigniew","2003-11-11"));
		Osoba nowa = new Osoba("Kowali�ski","Zbigniew","2011-11-11");
		obiekt.dodaj(nowa);
		Osoba nowa1 = new Osoba("Kowali�ski","Zbigniew","2011-11-11");
		System.out.println("r�wno�� " + nowa.jestR�wna(lista.get(0)));
		System.out.println("wyst�powanie " + obiekt.wyst�puje(nowa1));
		obiekt.napis = "Jan";
		System.out.println("napis " + obiekt.napis);
		System.out.println("data " + obiekt.teraz);

	}

}
