package ud.prog3.pr00.simulador;

import java.awt.Dimension;
import java.awt.Point;

public class PlantacionFlores extends ElementoEcosistema implements Evolucionable {
	protected long cantidad; 
	
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
		if (cantidad > 5000) cantidad = 5000;
	}
	
	@Override
	public String toString(){
		return titulo + ": " + cantidad + " flores, situado en " + posicion.x + ", " + posicion.y + " y con un tamaño de " + dimension.width + " x " + dimension.height;
	}

}
