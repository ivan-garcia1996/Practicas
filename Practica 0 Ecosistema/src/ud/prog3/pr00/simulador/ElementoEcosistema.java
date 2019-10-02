package ud.prog3.pr00.simulador;

import java.awt.Dimension;
import java.awt.Point;

public abstract class ElementoEcosistema {
	protected String titulo;
	protected Point posicion;
	protected Dimension dimension;
	
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
	
}
