public class Tamatriste extends Tamagotchi {
	
	private final static double AFFETTO_TAMATRISTE = 0;
	private final static String SPECIE = "TamaTriste";
	
	public Tamatriste (String nome, double affetto, double cibo) throws IllegalArgumentException {
		
		super(nome, AFFETTO_TAMATRISTE, cibo);
		this.specie = SPECIE;

	}
	
	public Tamatriste (String nome, double cibo) throws IllegalArgumentException {
		
		super(nome, AFFETTO_TAMATRISTE, cibo);
		this.specie = SPECIE;

	}

	public Tamatriste (double cibo) throws IllegalArgumentException {
		
		super(AFFETTO_TAMATRISTE, cibo);
		this.specie = SPECIE;

	}
	
	@Override
	public void receiveCaresses (int carezze){
		
		this.cibo -= COST_CAREZZE*carezze;
		
		controllaValori();
		
	}
	
	@Override
	public void receiveCookies (int biscotti) {
		
		int i=0;
		
		for (i=0; i<biscotti; i++) {
			
			this.cibo += COST_BISCOTTI_1*(this.cibo);
			
		}
		
		controllaValori();
		
	}
	
	@Override
	public boolean isAlive (){
		
		if (this.cibo <= MAX || this.cibo >= MIN) return false;
		return true;
		
	}
	
	@Override
	public boolean isHappy (){
		
		return false;
		
	}
	
}
