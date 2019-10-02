package coche;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;


public class VentanaJuego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	    
	static JPanel pCentralBlanco; // Fuera para usarlo en más funciones
	static CocheJuego coche1;        
	static boolean hilo;  

	public VentanaJuego() {
		
		pCentralBlanco= new JPanel();
		JPanel pBotones= new JPanel();
		JButton b1 = new JButton( "Acelera" );
		JButton b2 = new JButton( "Frena" );
		JButton b3 = new JButton( "Gira Izq." );
		JButton b4 = new JButton( "Gira Der." );
		pCentralBlanco.setLayout( null );
		pCentralBlanco.setBackground( Color.white );
		add( pCentralBlanco, BorderLayout.CENTER );
		pBotones.add( b1 );
		pBotones.add( b2 );
		pBotones.add( b3 );
		pBotones.add( b4 );
		add( pBotones, BorderLayout.SOUTH );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 700, 500 );
		b1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coche1.acelera(5);
				System.out.println( "Velocidad del coche: " + coche1.getMiVelocidad() );
			}
		});
		b2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coche1.acelera(-5);
				System.out.println( "Velocidad del coche: " + coche1.getMiVelocidad() );
			}
		});
		b3.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coche1.gira(10);
				System.out.println( "Dirección del coche: " + coche1.getMiDireccionActual() );
			}
		});
		b4.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coche1.gira(-10);
				System.out.println( "Dirección del coche: " + coche1.getMiDireccionActual() );
			}
		});
		
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				hilo = false;
			}
		});
	}
	
	public void creaCoche( int x, int y, String z) {
		
		//Coche coche1 = new Coche(); Prueba to String
		//coche1.setPosicion(posX, posY);
		coche1 = new CocheJuego();
		coche1.setPosicion( x, y );
		coche1.setPiloto(z);
		pCentralBlanco.add( coche1.getGrafico() );
	}
	
	public static void main(String[] args) {
		
		//Coche coche1 = new Coche(150,100,"Hamilton"); Prueba to String
		//System.out.println(coche1.toString());
		VentanaJuego miVentana = new VentanaJuego();
		miVentana.setVisible( true );
		miVentana.creaCoche( 150, 100, "Hamilton" );
		System.out.println(VentanaJuego.coche1.toString());
		hilo = true;
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (hilo) {
					coche1.mueve(0.05);//Para que cocue rebote vemos la posicion relativa del objeto en la venta y si la mitad del objeto pasa los bordes cambia de dirección
					if (coche1.getPosX() < -JLabelCoche.TAMANYO_COCHE/2 || coche1.getPosX()>pCentralBlanco.getWidth()-JLabelCoche.TAMANYO_COCHE/2 ) {
						System.out.println( coche1.getPiloto() + " " + "choca X");
						double sentido = coche1.getMiDireccionActual();
						sentido = 180-sentido; // Cambia de sentido 
						if (sentido < 0) {
							sentido = 360+sentido;  
						}
						coche1.setMiDireccionActual( sentido );
					}
					
					if (coche1.getPosY() < -JLabelCoche.TAMANYO_COCHE/2 || coche1.getPosY()>pCentralBlanco.getHeight()-JLabelCoche.TAMANYO_COCHE/2 ) {
						System.out.println( coche1.getPiloto() + " " + "choca Y");
						double sentido = coche1.getMiDireccionActual();
						sentido = 360 - sentido;  //Cambia de sentido
						coche1.setMiDireccionActual( sentido );
					}
					try {
						Thread.sleep( 40 );
					} catch (Exception e) {
					}
				}
			}
			
		});
		t.start();
	}
	
}
