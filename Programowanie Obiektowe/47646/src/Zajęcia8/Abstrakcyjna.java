package Zaj�cia8;

import java.time.LocalDate;

public abstract class Abstrakcyjna <Element> {
	LocalDate teraz=LocalDate.now();
	String napis="abcd";
	public abstract void dodaj(Element x);
	public abstract boolean wyst�puje(Element x);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
