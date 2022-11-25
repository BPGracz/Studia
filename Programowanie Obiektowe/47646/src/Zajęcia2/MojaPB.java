package Zajêcia2;

public class MojaPB {
	int x = 23;
	public String toString() {
	return "klasa bazowa "+
	this.getClass().getName()+ "\n";
	}

	public static void main(String[] args) {
		MojaPB obiekt1 = new MojaPB();
		System.out.println(obiekt1);	

	}

}
