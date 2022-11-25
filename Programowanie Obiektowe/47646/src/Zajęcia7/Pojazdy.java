package Zaj�cia7;

public class Pojazdy {
	public void przegl�dPojazdu() {
		System.out.println("specyfikacja przegl�du pojazdu");
	}
	
	public static void zr�bTo(Pojazdy p) {
		String a = p.getClass().getGenericSuperclass().getTypeName();
		System.out.println("\n super: " + a);
		String aa = p.getClass().getTypeName();
		System.out.println(" klasa: " + aa);
		
		p.przegl�dPojazdu();
		
		/*
		if(aa.equals("Testy.Doro�ki"))
			System.out.println(((Doro�ki)p).typ);
		else
			System.out.println(((Samochody)p).typ);
		*/
	}

	public static void main(String[] args) {
		Samochody samoch�d = new Samochody();
		Doro�ki doro�ka = new Doro�ki();
		
		zr�bTo(samoch�d);
		zr�bTo(doro�ka);

	}

}
