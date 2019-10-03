package ud.prog3.pr00.simulador.iu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import ud.prog3.pr00.simulador.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel pMundo;
	private boolean hilo;
	
	public VentanaPrincipal() {
		
		setSize(800,600);
		setTitle("Práctica ecosistema");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pMundo = new JPanel();
		JPanel pBotones = new JPanel();
		JToggleButton tb1 = new JToggleButton("Mover");
		JToggleButton tb2 = new JToggleButton("Crear");
		JComboBox<String> cb1 = new JComboBox<>( new String[] { 
			"Abejas", "Flores", "Agua"
		} );
		JButton b1 = new JButton("Vida");
		
		pMundo.setLayout(null);
		
		pBotones.add(tb1);
		pBotones.add(tb2);
		pBotones.add(cb1);
		pBotones.add(b1);
		getContentPane().add(pMundo, BorderLayout.CENTER);
		getContentPane().add(pBotones, BorderLayout.SOUTH);
		
		tb1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tb1.isSelected()) {
					tb2.setSelected(false);
				}
			}
		});
		tb2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tb2.isSelected()) {
					tb1.setSelected(false);
				}
			}
		});
		pMundo.addMouseListener( new MouseListener() {
			Point coordPulsacion = null;
			@Override
			public void mouseReleased(MouseEvent e) {
				Point coordSuelta = e.getPoint();
				if (tb1.isSelected()) {  
					for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos()) {
						if (ee.getPanel().getBounds().contains( coordPulsacion )) {   
							coordSuelta.translate( -coordPulsacion.x, -coordPulsacion.y);
							coordSuelta.translate( ee.getPanel().getLocation().x, ee.getPanel().getLocation().y );
							ee.getPanel().setLocation( coordSuelta );
							ee.setPosicion( coordSuelta );
							break;  
						}
					}
				} else if (tb2.isSelected()) {  
					ElementoEcosistema ee = null;
					if (cb1.getSelectedItem().equals("Abejas")) {
						ee = new ColoniaAbejas( "Colonia " + (Ecosistema.getMundo().getElementos().size()+1), 
								coordPulsacion.x, coordPulsacion.y, Math.abs(coordSuelta.x-coordPulsacion.x), Math.abs(coordSuelta.y-coordPulsacion.y) );
					} else if (cb1.getSelectedItem().equals("Flores")) {
						ee = new PlantacionFlores( "Pradera " + (Ecosistema.getMundo().getElementos().size()+1), 
								coordPulsacion.x, coordPulsacion.y, Math.abs(coordSuelta.x-coordPulsacion.x), Math.abs(coordSuelta.y-coordPulsacion.y) );
					} else if (cb1.getSelectedItem().equals("Agua")) {
						ee = new Agua( "Lago " + (Ecosistema.getMundo().getElementos().size()+1), 
								coordPulsacion.x, coordPulsacion.y, Math.abs(coordSuelta.x-coordPulsacion.x), Math.abs(coordSuelta.y-coordPulsacion.y) );
					}
					Ecosistema.getMundo().getElementos().add(ee);
					JPanel pNuevo = ee.getPanel();
					pMundo.add(pNuevo);
					pMundo.revalidate();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				coordPulsacion = e.getPoint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		b1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (b1.getText().equals("Vida")) {  
					b1.setText("Parar");
					hilo=true;
					Thread t = new Thread(new Runnable() {
						@Override
						public void run() {
							while (hilo) {
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {}
								for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos()) {
									if (ee instanceof Evolucionable) {
										Evolucionable e1 = (Evolucionable) ee;
										e1.evoluciona(1);
									}
								}
							}

						}
					});
					t.start();
				} else {  
					b1.setText( "Vida" );
					hilo=false;
				}
			}
		});
		
		addWindowListener( new WindowAdapter() {  
			@Override
			public void windowDeactivated(WindowEvent e) {
				hilo=false;
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run() {
				VentanaPrincipal v1 = new VentanaPrincipal();
				v1.setVisible(true);
			}
		});
	}
	
}
