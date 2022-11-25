package Zajêcia10;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BazaOkno extends JFrame {
	static final long serialVersionUID=0;
		int szerokosc=400;
		int wysokosc=400;
		int poczp=60;
		int szerokoscK = szerokosc/2;
		int wysokoscK = wysokosc/2;
		int szerK = szerokosc/3;
		int wysK = wysokosc/12;
		
		JButton przycisk;
		JLabel et;
		JTextField poletekstowe;
		public BazaOkno() {
			Font czcionka=new Font("Serif", Font.BOLD, 20);
			przycisk = new JButton("KONIEC");
			przycisk.setBounds(szerokoscK-szerK,poczp+wysK/2,szerK*2,wysK);
			przycisk.setFont(czcionka);
			ImageIcon obrazek = new ImageIcon("C:\\inne\\kalkulator.jpg");
			et = new JLabel(obrazek);
			et.setBounds(szerokoscK-szerK,poczp+2*wysK,szerK*2,obrazek.getIconHeight());
			et.setIcon(obrazek);
			poletekstowe = new JTextField("Witam w UMG");
			poletekstowe.setBounds(szerokoscK-szerK,poczp-wysK/2,2*szerK,wysK);
			poletekstowe.setFont(czcionka);
			
			add(przycisk);
			add(poletekstowe);
			add(et);
			
			this.setSize(szerokosc,wysokosc);
			this.setLayout(null);
			this.setVisible(true);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
