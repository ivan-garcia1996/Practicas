package ud.prog3.pr00.simulador;

import java.util.ArrayList;
import java.util.List;

public class Ecosistema {
	
	private List<ElementoEcosistema> listaEEs;
	private static Ecosistema ecoSistema = new Ecosistema();
	
	
	private Ecosistema() {
		listaEEs = new ArrayList<>();
	}
	
	public List<ElementoEcosistema> getElementos() {
		return listaEEs;
	}
	
	public static Ecosistema getMundo() {
		return ecoSistema;
	}
	
	public static int distancia(ElementoEcosistema x, ElementoEcosistema y) {// Tiene que ser int por la función de evolución dada
		return (int)Math.sqrt(Math.pow( x.getPosicion().getX() - y.getPosicion().getX(), 2) + 
				                 Math.pow( x.getPosicion().getY() - y.getPosicion().getY(), 2));
	}
}
