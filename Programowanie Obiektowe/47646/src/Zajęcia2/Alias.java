package Zajêcia2;

public class Alias {
	String nazwisko = "Kowalski";
	String imie = "Dariusz";
	String dataUr = "1999-10-12";
	
	public static void main(String[] args) {
		Alias obiekt1 = new Alias();
		Alias obiekt2 = obiekt1;
		
	}
	System.out.println(obiekt1==obiekt2);

}
