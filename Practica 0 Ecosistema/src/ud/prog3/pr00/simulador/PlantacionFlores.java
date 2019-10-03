package ud.prog3.pr00.simulador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlantacionFlores extends ElementoEcosistema implements Evolucionable {
	protected long cantidad;
	private JLabel lCantidad = new JLabel("", JLabel.CENTER);
	
	public PlantacionFlores(String z, int x, int y, int a, int b) {
		this.titulo = z;
		cantidad = a * b; //Ya que no pone nada supongo que el area del rectangula van a ser las flores
		posicion = new Point(x, y);
		dimension = new Dimension(a, b);
	}
	
	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public void evoluciona(int dias) {
		double factorCrecimiento = 0.25;
		for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos()) {
			int dist = Ecosistema.distancia( this, ee );
			if (ee instanceof ColoniaAbejas) { 
				if (dist < 500) factorCrecimiento = factorCrecimiento / dist * 500;
			} else if (ee instanceof Agua) { 
				if (dist < 500) factorCrecimiento = factorCrecimiento / dist * 500;
			}
		}
		cantidad = (long) (cantidad * factorCrecimiento * dias);
		if (cantidad > 500000) cantidad = 500000;
		lCantidad.setText( "" + cantidad);
	}
	
	@Override
	public String toString(){
		return titulo + ": " + cantidad + " flores, situado en " + posicion.x + ", " + posicion.y + " y con un tamaño de " + dimension.width + " x " + dimension.height;
	}

	@Override
	public JPanel getPanel() {
		if (miPanel == null) {
			miPanel = new JPanel();
			miPanel.setLayout( new BorderLayout() );
			miPanel.add( lTitulo, BorderLayout.NORTH );
			miPanel.add( lCantidad, BorderLayout.CENTER );
			miPanel.add( new JLabel("Flores", JLabel.CENTER), BorderLayout.SOUTH );
			lCantidad.setText( ""+cantidad );
			lTitulo.setText( titulo );
			miPanel.setLocation( posicion );
			miPanel.setSize( dimension );
			miPanel.setBackground(Color.green);
		}
		return miPanel;
	}
}
