package Zajêcia10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PierwszaOkna extends BazaOkno {
	
	private static final long serialVersionUID = 20;
	
	MouseMotionListener s³uchacz_1 = new MouseMotionListener() {
		
		public void mouseDragged(MouseEvent e) {
			String napis ="ci¹gniesz x= " + e.getX() + " y= " + e.getY();
			poletekstowe.setText(napis);
		}
		
		public void mouseMoved(MouseEvent e) {
			String napis="przesuwasz x= "+ e.getX() + " y= " + e.getY();
			poletekstowe.setText(napis);
		}//end of mouseMoved
		
	};//end of MouseMotionListener
	
	ActionListener s³uchacz_2 = new ActionListener() 
	{
		public void actionPerformed(ActionEvent ae) 
		{
			short x,y,z;
			if (ae.getSource() == przycisk)
				dispose();
		}
		
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PierwszaOkna x = new PierwszaOkna();
		x.addMouseMotionListener(x.s³uchacz_1);

	}//end of main

}//end of class PierwszaOkna
