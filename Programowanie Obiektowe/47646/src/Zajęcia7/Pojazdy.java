package Zajêcia7;

public class Pojazdy {
	public void przegl¹dPojazdu() {
		System.out.println("specyfikacja przegl¹du pojazdu");
	}
	
	public static void zróbTo(Pojazdy p) {
		String a = p.getClass().getGenericSuperclass().getTypeName();
		System.out.println("\n super: " + a);
		String aa = p.getClass().getTypeName();
		System.out.println(" klasa: " + aa);
		
		p.przegl¹dPojazdu();
		
		/*
		if(aa.equals("Testy.Doro¿ki"))
			System.out.println(((Doro¿ki)p).typ);
		else
			System.out.println(((Samochody)p).typ);
		*/
	}

	public static void main(String[] args) {
		Samochody samochód = new Samochody();
		Doro¿ki doro¿ka = new Doro¿ki();
		
		zróbTo(samochód);
		zróbTo(doro¿ka);

	}

}
