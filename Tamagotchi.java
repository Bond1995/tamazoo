/**
 * Questa classe definisce il prototipo degli oggetti Tamagotchi
 * 
 * @author Gruppo B
 *
 */
public class Tamagotchi {
	
	protected String nome;
	protected double affetto;
	protected double cibo;
	protected int contatoreCarezze = 0;
	protected String specie = "Tamagotchi";
	
	protected static final int MIN = 0; // Valore minimo di affetto e cibo
	protected static final int MAX = 100; // Valore massimo di affetto e cibo
	protected static final int MIN_AFFETTO = 0; // Valore minimo di affetto sotto il quale il tamagotchi muore
	protected static final int MIN_CIBO = 30; // Valore minimo di cibo sotto il quale il tamagotchi muore
	protected static final int MAX_CIBO = 90; // Valore massimo di cibo sopra il quale il tamagotchi muore
	protected static final double COST_CAREZZE = 0.5; // Costante per la diminuzione di cibo date le carezze
	protected static final double COST_CORREZIONE_CAREZZE = 20; // Costante per la diminuzione di carezze rispetto al contatore
	protected static final double COST_BISCOTTI_1 = 0.1;  // Costante per l'aumento di cibo dati i biscotti
	protected static final double COST_BISCOTTI_2 = 0.25; // Costante per la diminuzione di affetto dati i biscotti
	protected static final String TEXT_INFO = "Il tuo %s %s ha %.1f di affetto e %.1f di cibo.\n";
	protected static final String TEXT_MORTO = "Purtroppo il tuo tamagotchi è morto. :((\n";
	protected static final String TEXT_VIVO = "Il tuo tamagotchi è vivo!\n";
	protected static final String TEXT_TRISTE = "Purtroppo il tuo tamagotchi è triste :(\n";
	protected static final String TEXT_FELICE = "Il tuo tamagotchi è felice!\n";
	protected static final String ERRORE_AFFETTO_CIBO_NEGATIVI = "Attenzione: i valori di cibo e/o affetto non possono essere negativi!";
	protected static final String SENZA_NOME = "Senza nome";
	
	/**
	 * Costruttore della classe Tamagotchi
	 * 
	 * @param nome Rappresenta il nome del tamagotchi
	 * @param affetto Rappresenta il valore iniziale di affetto del tamagotchi
	 * @param cibo Rappresenta il valore iniziale di cibo del tamagotchi
	 */
	public Tamagotchi (String nome, double affetto, double cibo) throws IllegalArgumentException {
		
		if (affetto < 0 || cibo < 0)
			throw new IllegalArgumentException(ERRORE_AFFETTO_CIBO_NEGATIVI);
		else {
			
			this.nome = nome;
			this.affetto = affetto;
			this.cibo = cibo;
		
		}
		
	}
	
	public Tamagotchi (double affetto, double cibo) throws IllegalArgumentException {
		
		if (affetto < 0 || cibo < 0)
			throw new IllegalArgumentException(ERRORE_AFFETTO_CIBO_NEGATIVI);
		else {
			
			this.nome = SENZA_NOME;
			this.affetto = affetto;
			this.cibo = cibo;
		
		}
		
	}
	
	/**
	 * Metodo utilizzato per dare carezze al tamagotchi
	 * 
	 * @param carezze Rappresenta la quantità di carezze da dare al tamagotchi
	 */
	public void receiveCaresses (int carezze){
		
		this.affetto += (COST_CORREZIONE_CAREZZE/(this.contatoreCarezze + COST_CORREZIONE_CAREZZE))*carezze;
		this.cibo -= COST_CAREZZE*carezze;
		this.contatoreCarezze += carezze;
		
		controllaValori();
		
	}
	
	/**
	 * Metodo utilizzato per dare biscotti al tamagotchi
	 * 
	 * @param biscotti Rappresenta la quantità di biscotti da dare al tamagotchi
	 */
	public void receiveCookies (int biscotti) {
		
		int i=0;
		
		for (i=0; i<biscotti; i++) {
			
			this.cibo += COST_BISCOTTI_1*(this.cibo);
			
		}
		
		this.affetto -= COST_BISCOTTI_2*biscotti;
		
		controllaValori();
		
	}
	
	/**
	 * Metodo per determinare se il tamagotchi sia morto
	 * 
	 * @return Valore booleano che indica se il tamagotchi è morto (true) oppure è ancora vivo (false)
	 */
	public boolean isAlive() {
		
		if (this.affetto <= MIN || this.cibo >= MAX || this.cibo <= MIN) return false;
		return true;
		
	}
	
	/**
	 * Metodo per determinare se il tamagotchi sia infelice
	 * 
	 * @return Valore booleano che indica se il tamagotchi è triste (true) oppure è felice (false)
	 */
	public boolean isHappy() {
		
		if (this.affetto < MIN_AFFETTO || this.cibo > MAX_CIBO || this.cibo < MIN_CIBO) return false; 
		return true;
		
	}
	
	/**
	 * Metodo per verificare che i valori di affetto è cibo rientrino nell'intervallo stabilito
	 */
	protected void controllaValori() {
		
		if (this.affetto > MAX) this.affetto = MAX;
		else if (this.affetto < MIN) this.affetto = MIN;
		
		if (this.cibo > MAX) this.cibo = MAX;
		else if (this.cibo < MIN) this.cibo = MIN;
		
	}
	
	/**
	 * Metodo che ritorna una stringa con le informazioni sullo stato attuale del tamagotchi
	 * 
	 * @return Stringa contenente le informazioni sullo stato attuale del tamagotchi
	 */
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(String.format(TEXT_INFO, this.specie, this.nome, this.affetto, this.cibo));
		
		if (!this.isAlive()) builder.append(TEXT_MORTO);
		else {
			
			builder.append(TEXT_VIVO);
			
			if (this.isHappy()) builder.append(TEXT_FELICE);
			else builder.append(TEXT_TRISTE);
		
		}
		
		return builder.toString();
		
	}
	
}
