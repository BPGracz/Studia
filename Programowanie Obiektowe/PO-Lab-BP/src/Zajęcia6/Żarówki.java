package Zaj�cia6;

public class �ar�wki extends Zarowka {
	
	static �ar�wki kolekcja[] = new �ar�wki[100];
	static int koniec = 0;
	//static ArrayList<�ar�wki> kolekcja = new ArrayList();
	
	String producent = "No name";
	String typ�ar�wki = "�arowa";
	
public �ar�wki(String prod, String typ, int napM, int napZ) {
	super(napM, napZ);
	producent=prod;
	typ�ar�wki=typ;
	kolekcja[koniec++] = this;
}

public �ar�wki() {kolekcja[koniec++] = this;}

	void drukujStan() {
		super.drukujStan();
		System.out.println("producent	" + producent);
		System.out.println("Typ �ar�wki	" + typ�ar�wki);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
