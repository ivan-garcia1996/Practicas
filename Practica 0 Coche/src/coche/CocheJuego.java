package coche;

public class CocheJuego extends Coche {
	private JLabelCoche miGrafico; 
	
	public CocheJuego() {
		miGrafico = new JLabelCoche();
	}
	
	public JLabelCoche getGrafico() {
		return miGrafico;
	}

	@Override
	public void setPosX(double x) {
		super.setPosX(x);
		miGrafico.setLocation( (int)x, (int)posY );
	}

	@Override
	public void setPosY(double y) {
		super.setPosY(y);
		miGrafico.setLocation( (int)posX, (int)y );
	}

	@Override
	public void setMiDireccionActual( double x ) {
		super.setMiDireccionActual(x);
		miGrafico.setGiro( miDireccionActual );
		miGrafico.repaint();  
	}

}
