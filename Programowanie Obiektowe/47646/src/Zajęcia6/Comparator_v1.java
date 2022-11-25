package Zajêcia6;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Comparator_v1 {
	
	public String s1 = "dwa2";
	public String s2 = "trzy3";
	public String s3 = "trzy3";
	public String s4 = "trzy3";
	public String s5 = "piêæ5";
	public String s6 = "cztery4";
	
	String suma;
	
	public String suma() {
		this.suma = this.s1 + " plus " + this.s2 + " = " + s1 + s2;
		return this.suma;
	}
	
	Comparator <String> komparator = new Comparator<String>() {
		Collator c = Collator.getInstance(new Locale("pl", "PL"));
		
		@Override
		public int compare(String s1, String s2) {
			return c.compare(s1, s2);
			
			/* gdy s1 < s2 compare zwraca: -1
			 * gdy s1 = s2 compare zwraca:  0
			 * gdy s1 > s2 compare zwraca:  1	*/
			
		}//end of compare
	};//end of Comparator;

	public static void main(String[] args) {
		
		Comparator_v1 o1 = new Comparator_v1();
		System.out.println(o1.suma());
		
		//zbyteczna instrukcja -> o1.komparator.compare("¹","b");
		//System.out.println(o1.komparator.compare("¹","b"));
		
		System.out.print("dwa2 < trzy3: ");
		System.out.println(o1.komparator.compare(o1.s1, o1.s2));
		
		System.out.print("trzy3 = trzy3: ");
		System.out.println(o1.komparator.compare(o1.s3, o1.s4));
		
		System.out.print("piêæ5 > cztery4: ");
		System.out.println(o1.komparator.compare(o1.s5, o1.s6));

	}//end of main

}//end of Comparator_v1
