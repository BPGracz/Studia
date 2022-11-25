package Zajêcia9;

import java.util.ArrayList;

import Zajêcia5.Osoba;
import Zajêcia8.PAbstrak;

public abstract class ZbPrzyk³ad implements ZbiórM<Osoba> {
	
	ZbiórM<Osoba> obListy = new ZbiórM<Osoba>() {

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
		public int podajIloœc() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String poka¿Wszystkie() {
			// TODO Auto-generated method stub
			return null;
		}
		
	};

	public static void main(String[] args) {
		MInterfejs<Osoba> obInt = new MInterfejs<Osoba>() {
			public ArrayList<Osoba>lista = new ArrayList<Osoba>();
			public void dodaj(Osoba x) {lista.add(x);}
			public boolean wystêpuje(Osoba x) {
				for(Osoba xx:lista) {
					if (xx.jestRówna(x)) return true;
				}
			return false;};
		};
		
		Osoba nowa = new Osoba("Kowal","¯bigniew","2003-11-11");
		obInt.dodaj(nowa);
		nowa = new Osoba("Kowaliñski","Zbigniew","2011-11-11");
		obInt.dodaj(nowa);
		Osoba nowa1 = new Osoba("Kowaliñski","Zbigniew","2011-11-11");
		System.out.println("wystêpowanie " + obInt.wystêpuje(nowa1));
		System.out.println("napis " + MInterfejs.napis);
		System.out.println("data " + MInterfejs.teraz);

	}

}
