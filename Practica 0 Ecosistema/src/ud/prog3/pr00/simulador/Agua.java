package ud.prog3.pr00.simulador;

import java.awt.Dimension;
import java.awt.Point;

public class Agua extends ElementoEcosistema {
	protected long cantidad;  	
	
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

}
