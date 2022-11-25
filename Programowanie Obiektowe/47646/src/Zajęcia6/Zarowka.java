package Zajêcia6;

public class Zarowka {
	
	/*
	private int napZasilania = 0;
	private int napMaksymalne = 230;
	
	void zapal() { napZasilania = napMaksymalne; }
	void zgaœ() { napZasilania = 0; }
	*/
	
	double napAkt = 0;
	int napMax = 230;
	String stan = "brak inicjacji" ;// nie b³a ani razy w³¹czana ani wy³¹czana
	
	Zarowka() {}
	
	Zarowka(int nap, int napMax) {
		napAkt = nap;
		this.napMax = napMax;
	}//end of constructor 2
	
	void zapal() {
		napAkt = napMax;
	}
	
	void zgaœ() {
		napAkt = 0;
	}
	
	void drukujStan() {
		if (napAkt > 0)
			stan = " œwieci";
		else
			stan = " zgaszona";
		System.out.println("¯arówka " + /*this.getClass().getName() + " " +*/ stan);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}//end of class Zarowka
