package ud.prog3.pr00.simulador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Agua extends ElementoEcosistema {
	protected long cantidad;  
	private JLabel lCantidad = new JLabel("", JLabel.CENTER); 
	
	public Agua( String z, int x, int y, int a, int b) {
		this.titulo = z;
		cantidad = a * b; //Ya que no pone nada supongo que el area del rectangula van a ser los litros
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
	public String toString(){
		return titulo + ": " + cantidad + " litros, situado en " + posicion.x + ", " + posicion.y + " y con un tamaño de " + dimension.width + " x " + dimension.height;
	}

	@Override
	public JPanel getPanel() {
		if (miPanel == null) {
			miPanel = new JPanel();
			miPanel.setLayout( new BorderLayout() );
			miPanel.add(lTitulo, BorderLayout.NORTH);
			miPanel.add(lCantidad, BorderLayout.CENTER);
			miPanel.add(new JLabel("Litros", JLabel.CENTER), BorderLayout.SOUTH);
			lCantidad.setText( ""+cantidad);
			lTitulo.setText(titulo);
			miPanel.setLocation(posicion);
			miPanel.setSize(dimension);
			miPanel.setBackground(Color.blue);
		}
		return miPanel;
	}

}
