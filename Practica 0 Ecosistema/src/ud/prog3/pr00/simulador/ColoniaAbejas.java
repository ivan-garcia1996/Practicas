package ud.prog3.pr00.simulador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColoniaAbejas extends ElementoEcosistema implements Evolucionable {
	
	protected long poblacion;  
	private JLabel lPoblacion = new JLabel("", JLabel.CENTER);
	
	public ColoniaAbejas(String z, int x, int y, int a, int b) {
		this.titulo = z;
		poblacion = a * b; //Ya que no pone nada supongo que el area del rectangula va a ser la población
		posicion = new Point(x, y);
		dimension = new Dimension(a, b);
	}
	
	public long getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(long poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public void evoluciona(int dias) {
		double factorCrecimiento = 1;
		int numFlores = 0;
		for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos()) {
			int dist = Ecosistema.distancia( this, ee );
			if (ee instanceof ColoniaAbejas && ee!=this) {  
				if (dist < 500) {
					factorCrecimiento = factorCrecimiento * dist / 500;
				}
			} else if (ee instanceof PlantacionFlores) {  
				if (dist < 500) {
					factorCrecimiento = factorCrecimiento / dist * 500;
				}
				numFlores += ((PlantacionFlores)ee).getCantidad();
			}
		}
		if (numFlores < 50) factorCrecimiento *= 0.1; // 
		poblacion = (long) (poblacion * factorCrecimiento * dias);
		if (poblacion > 500000) poblacion = 500000;
		lPoblacion.setText( "" + poblacion );

	}

	@Override
	public String toString(){
		return titulo + ": " + poblacion + " abejas, situado en " + posicion.x + ", " + posicion.y + " y con un tamaño de " + dimension.width + " x " + dimension.height;
	}
	
  
	@Override
	public JPanel getPanel() {
		if (miPanel == null) {
			miPanel = new JPanel();
			miPanel.setLayout( new BorderLayout() );
			miPanel.add( lTitulo, BorderLayout.NORTH );
			miPanel.add( lPoblacion, BorderLayout.CENTER );
			miPanel.add( new JLabel("Abejas", JLabel.CENTER), BorderLayout.SOUTH );
			lPoblacion.setText( ""+poblacion );
			lTitulo.setText( titulo );
			miPanel.setLocation( posicion );
			miPanel.setSize( dimension );
			miPanel.setBackground(Color.yellow);
		}
		return miPanel;
	}

}
