package ud.prog3.pr00.simulador;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class ElementoEcosistema {
	protected String titulo;
	protected Point posicion;
	protected Dimension dimension;
	protected JPanel miPanel = null;  
	protected JLabel lTitulo = new JLabel("", JLabel.CENTER);
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public abstract JPanel getPanel();
	  
}
