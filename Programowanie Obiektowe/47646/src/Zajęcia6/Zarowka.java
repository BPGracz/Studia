package Zaj�cia6;

public class Zarowka {
	
	/*
	private int napZasilania = 0;
	private int napMaksymalne = 230;
	
	void zapal() { napZasilania = napMaksymalne; }
	void zga�() { napZasilania = 0; }
	*/
	
	double napAkt = 0;
	int napMax = 230;
	String stan = "brak inicjacji" ;// nie b�a ani razy w��czana ani wy��czana
	
	Zarowka() {}
	
	Zarowka(int nap, int napMax) {
		napAkt = nap;
		this.napMax = napMax;
	}//end of constructor 2
	
	void zapal() {
		napAkt = napMax;
	}
	
	void zga�() {
		napAkt = 0;
	}
	
	void drukujStan() {
		if (napAkt > 0)
			stan = " �wieci";
		else
			stan = " zgaszona";
		System.out.println("�ar�wka " + /*this.getClass().getName() + " " +*/ stan);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}//end of class Zarowka
