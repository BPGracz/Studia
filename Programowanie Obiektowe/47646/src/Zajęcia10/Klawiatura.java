package Zajêcia10;

import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
//import java.awt.event.*;
//import java.util.*;

public class Klawiatura extends JFrame
{  static final long serialVersionUID=0;
	int szerokosc=600;
	int wysokosc=500;
	int poczp=160;
	int poczD=50;
	int szerokoscK = szerokosc/2;
	int wysokoscK = wysokosc/2;
	int szerK = szerokosc/5;
	int wysK = wysokosc/10;
	//private int xmoje=90;
	JButton przycisk1;
	JButton przycisk2;
	JButton przycisk3;
	JButton przycisk4;
	JButton przycisk5;
	JLabel etykieta;
	JLabel et;
	
	JTextField poletekstowe1;
	JTextField poletekstowe2;
	public Klawiatura() {
		Font czcionka=new Font("Serif", Font.BOLD, 20);
		przycisk1 = new JButton("KONIEC");
		przycisk1.setBounds(szerokoscK-szerK,poczp+wysK+wysK,szerK*2,wysK);
		przycisk1.setFont(czcionka);
		ImageIcon obrazek = new ImageIcon("C:\\inne\\Kalkulator1.png");
		et = new JLabel(obrazek);
		et.setBounds(szerokoscK-szerK,poczp+3*wysK,szerK*2,obrazek.getIconHeight());
		
		et.setIcon(obrazek);
		
		przycisk2 = new JButton("dodaj");
		przycisk2.setBounds(szerokoscK-szerK,poczp,szerK,wysK);
		przycisk2.setFont(czcionka);
		
		przycisk3 = new JButton("odejmij");
		przycisk3.setBounds(szerokoscK,poczp,szerK,wysK);
		przycisk3.setFont(czcionka);
		
		przycisk4 = new JButton("podziel");
		przycisk4.setBounds(szerokoscK,poczp+wysK,szerK,wysK);
		przycisk4.setFont(czcionka);
		
		przycisk5 = new JButton("pomnó¿");
		przycisk5.setBounds(szerokoscK-szerK,poczp+wysK,szerK,wysK);
		przycisk5.setFont(czcionka);
		
		etykieta = new JLabel("Wynik obliczeñ",JLabel.CENTER);
		etykieta.setBounds(szerokoscK-2*szerK,poczD,szerK*4,wysK);
		etykieta.setFont(czcionka);
		
		poletekstowe1 = new JTextField("20000");
		poletekstowe1.setBounds(szerokoscK-szerK,poczD+wysK,szerK,wysK);
		poletekstowe1.setFont(czcionka);
		
		poletekstowe2 = new JTextField("14000");
		poletekstowe2.setBounds(szerokoscK,poczD+wysK,szerK,wysK);
		poletekstowe2.setFont(czcionka);
		add(przycisk1);
		add(przycisk2);
		add(przycisk3);
		add(przycisk4);
		add(przycisk5);
		add(etykieta);
		add(poletekstowe1);
		add(poletekstowe2);
		add(et);
		
		this.setSize(szerokosc,wysokosc);
		this.setLayout(null);
		this.setVisible(true);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
