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
	
public void rozjaœnij() {
	for (double i = 0; i < super.napMax ; i++) {
		super.napAkt = i;
	}
}

public void przyæmij() {
	for (double i = super.napMax; i > 0 ; i--) {
		super.napAkt = i;
	}
}

@Override
public String toString() {
	return "Producent: " + producent + "\nTyp ¿arówki: " + typ¯arówki + "\nStan: " + stan ;
}

	public static void main(String[] args) {
		
		/*
		¯arówki o = new ¯arówki("Toshiba","¯arowa", 0, 230);
		o.rozjaœnij();
		o.drukujStan();
		o.przyæmij();
		o.drukujStan();
		*/
		
		¯arówki o0 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o1 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o2 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o3 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o4 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o5 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o6 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o7 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o8 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o9 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o10 = new ¯arówki("Toshiba","¯arowa", 0, 230);
		¯arówki o11 = new ¯arówki("Toshiba","¯arowa", 0, 230);

		o1.zapal();
		o2.zapal();
		o5.zapal();
		
		o0.zgaœ();
		o9.zgaœ();
		o3.zgaœ();
		o11.zgaœ();
		
		o5.toString();
		
		
		for (int i=0; i <= kolekcja.length ; i++) {
			kolekcja[i].zgaœ();
			kolekcja[i].toString();
		}
		
		
		
	}

}
