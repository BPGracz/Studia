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
	
public void rozja�nij() {
	for (double i = 0; i < super.napMax ; i++) {
		super.napAkt = i;
	}
}

public void przy�mij() {
	for (double i = super.napMax; i > 0 ; i--) {
		super.napAkt = i;
	}
}

@Override
public String toString() {
	return "Producent: " + producent + "\nTyp �ar�wki: " + typ�ar�wki + "\nStan: " + stan ;
}

	public static void main(String[] args) {
		
		/*
		�ar�wki o = new �ar�wki("Toshiba","�arowa", 0, 230);
		o.rozja�nij();
		o.drukujStan();
		o.przy�mij();
		o.drukujStan();
		*/
		
		�ar�wki o0 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o1 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o2 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o3 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o4 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o5 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o6 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o7 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o8 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o9 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o10 = new �ar�wki("Toshiba","�arowa", 0, 230);
		�ar�wki o11 = new �ar�wki("Toshiba","�arowa", 0, 230);

		o1.zapal();
		o2.zapal();
		o5.zapal();
		
		o0.zga�();
		o9.zga�();
		o3.zga�();
		o11.zga�();
		
		o5.toString();
		
		
		for (int i=0; i <= kolekcja.length ; i++) {
			kolekcja[i].zga�();
			kolekcja[i].toString();
		}
		
		
		
	}

}
