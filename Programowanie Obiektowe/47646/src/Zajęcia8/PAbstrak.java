package Zajêcia8;

import java.util.ArrayList;

import Zajêcia4.Osoba;

public class PAbstrak extends Abstrakcyjna<Osoba> {
	public static ArrayList<Osoba> lista = new ArrayList<Osoba>();
	public void dodaj(Osoba x) {lista.add(x);}
	public boolean wystêpuje(Osoba x) {
		for(Osoba xx:lista) {if (xx.jestRówna(x)) return true;}
		return false;
	}

	public static void main(String[] args) {
		
		PAbstrak obiekt = new PAbstrak();
		obiekt.dodaj(new Osoba("Kowal","¯bigniew","2003-11-11"));
		Osoba nowa = new Osoba("Kowaliñski","Zbigniew","2011-11-11");
		obiekt.dodaj(nowa);
		Osoba nowa1 = new Osoba("Kowaliñski","Zbigniew","2011-11-11");
		System.out.println("równoœæ " + nowa.jestRówna(lista.get(0)));
		System.out.println("wystêpowanie " + obiekt.wystêpuje(nowa1));
		obiekt.napis = "Jan";
		System.out.println("napis " + obiekt.napis);
		System.out.println("data " + obiekt.teraz);

	}

}
