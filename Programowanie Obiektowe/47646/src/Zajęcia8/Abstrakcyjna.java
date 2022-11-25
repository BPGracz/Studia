package Zajêcia8;

import java.time.LocalDate;

public abstract class Abstrakcyjna <Element> {
	LocalDate teraz=LocalDate.now();
	String napis="abcd";
	public abstract void dodaj(Element x);
	public abstract boolean wystêpuje(Element x);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
