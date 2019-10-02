package coche;

public class Coche {
	private double miVelocidad;  
	protected double miDireccionActual;  
	protected double posX;  
	protected double posY;  
	private String piloto;  
	
	public Coche() {
		miVelocidad = 0;
		miDireccionActual = 0;
		posX = 0;
		posY = 0;
	}
	
	public Coche(int x, int y, String z) {
		miVelocidad = 0;
		miDireccionActual = 0;
		posX = x;
		posY = y;
		piloto = z;
	}
	
	public double getMiVelocidad() {
		return miVelocidad;
	}

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}

	public double getMiDireccionActual() {
		return miDireccionActual;
	}

	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
	}
	
	public void setPosX( double posX ) {
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
		this.posY = posY; 
	}
	
	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}


	@Override
	public String toString() {
		return "Nombre del piloto: " + piloto + " (" + posX + "," + posY + ") - " +
			   "Velocidad: " + miVelocidad + " Dirección: " + miDireccionActual; 
	}
	
	public void acelera( double x ) {
		miVelocidad = miVelocidad + x;
	}

	public void gira( double x ) {
		setMiDireccionActual( miDireccionActual + x );
	}
	
	public void mueve( double x ) {
		setPosX( posX + miVelocidad * Math.cos(miDireccionActual/180.0*Math.PI) * x );//Formula dada en el enunciado
		setPosY( posY + miVelocidad * -Math.sin(miDireccionActual/180.0*Math.PI) * x );
	}
	
}
