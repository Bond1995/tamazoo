package ing.unibs.esercitazioni.tamazoo;

public class Tamagordo extends Tamagotchi {
	private final static double AFFETTO_TAMAGORDO = 100;
	private final static String SPECIE = "Tamagordo";

	public Tamagordo(String nome, double affetto, double cibo)
			throws IllegalArgumentException {
		super(nome, AFFETTO_TAMAGORDO, cibo);
		this.specie = SPECIE;
	}

	public Tamagordo(double affetto, double cibo)
			throws IllegalArgumentException {
		super(AFFETTO_TAMAGORDO, cibo);
		this.specie = SPECIE;
	}

	@Override
	public void receiveCaresses(int carezze) {
		this.cibo -= (2 * COST_CAREZZE) * carezze;
		controllaValori();
	}

	@Override
	public void receiveCookies(int biscotti) {

		int i = 0;

		for (i = 0; i < biscotti; i++) {

			this.cibo += COST_BISCOTTI_1 * (this.cibo);
		}

		controllaValori();

	}

	@Override
	public boolean isAlive() {
		
		if (this.cibo <= MIN)
			return false;
		return true;
		
	}

	@Override
	public boolean isHappy() {
		
		if (this.cibo < MIN_CIBO)
			return false;
		return true;
		
	}
	
}
