package Zajêcia9;

import java.time.LocalDate;

public interface MInterfejs <Element> {
	LocalDate teraz=LocalDate.now();
	String napis="abcd";
	public abstract void dodaj(Element x);
	public abstract boolean wystêpuje(Element x);
}
