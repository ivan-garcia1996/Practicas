package ud.prog3.pr00.simulador;

public class PruebaEcosistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColoniaAbejas abejas = new ColoniaAbejas( "Colmena Alfa", 400, 300, 200, 70 );
		Agua agua = new Agua( "Pantano de Vitoria", 250, 150, 350, 90 );
		PlantacionFlores flores = new PlantacionFlores( "Margaritas", 100, 400, 200, 150 );
		Ecosistema.getMundo().getElementos().add( agua );
		Ecosistema.getMundo().getElementos().add( abejas );
		Ecosistema.getMundo().getElementos().add( flores );
		int dia=0;
		while (true) {
			System.out.println("Día " + dia);
			for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos()) {
				System.out.println( "  " + ee );
			}
			for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos()) {
				if (ee instanceof Evolucionable) ((Evolucionable) ee).evoluciona(1);
			}
			dia++;
			try {Thread.sleep(1000); } catch (Exception e) {}
		}

	}
}