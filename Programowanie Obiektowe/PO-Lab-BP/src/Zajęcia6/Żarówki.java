package Zajêcia6;

public class ¯arówki extends Zarowka {
	
	static ¯arówki kolekcja[] = new ¯arówki[100];
	static int koniec = 0;
	//static ArrayList<¯arówki> kolekcja = new ArrayList();
	
	String producent = "No name";
	String typ¯arówki = "¿arowa";
	
public ¯arówki(String prod, String typ, int napM, int napZ) {
	super(napM, napZ);
	producent=prod;
	typ¯arówki=typ;
	kolekcja[koniec++] = this;
}

public ¯arówki() {kolekcja[koniec++] = this;}

	void drukujStan() {
		super.drukujStan();
		System.out.println("producent	" + producent);
		System.out.println("Typ ¿arówki	" + typ¯arówki);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
