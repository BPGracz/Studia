package Zaj�cia9;

import java.util.ArrayList;

import Zaj�cia5.Osoba;
import Zaj�cia8.PAbstrak;

public abstract class ZbPrzyk�ad implements Zbi�rM<Osoba> {
	
	Zbi�rM<Osoba> obListy = new Zbi�rM<Osoba>() {

		@Override
		public boolean nalezy(Osoba x) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void dodaj(Osoba x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int podajIlo�c() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String poka�Wszystkie() {
			// TODO Auto-generated method stub
			return null;
		}
		
	};

	public static void main(String[] args) {
		MInterfejs<Osoba> obInt = new MInterfejs<Osoba>() {
			public ArrayList<Osoba>lista = new ArrayList<Osoba>();
			public void dodaj(Osoba x) {lista.add(x);}
			public boolean wyst�puje(Osoba x) {
				for(Osoba xx:lista) {
					if (xx.jestR�wna(x)) return true;
				}
			return false;};
		};
		
		Osoba nowa = new Osoba("Kowal","�bigniew","2003-11-11");
		obInt.dodaj(nowa);
		nowa = new Osoba("Kowali�ski","Zbigniew","2011-11-11");
		obInt.dodaj(nowa);
		Osoba nowa1 = new Osoba("Kowali�ski","Zbigniew","2011-11-11");
		System.out.println("wyst�powanie " + obInt.wyst�puje(nowa1));
		System.out.println("napis " + MInterfejs.napis);
		System.out.println("data " + MInterfejs.teraz);

	}

}
