package Zaj�cia7;

class Samochody extends Pojazdy {
	
	String typ="spalinowe";
	
	public void przegl�dPojazdu() {
		System.out.println("\nTyp pojazdu: " + typ);
		System.out.println("Specyfikacja przegl�du samochodu");
		System.out.println("==================================");
		System.out.println("Wymie� olej w skrzyni bieg�w");
		System.out.println("Wymie�/uzupe�nij olej w silniku");
		System.out.println("Sprawd� pasek rozrz�du");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
