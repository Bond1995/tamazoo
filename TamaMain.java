import ing.unibs.esercitazioni.mylib.MyMenu;
import ing.unibs.esercitazioni.mylib.MyUtil;

public class TamaMain {

	private static final String SALUTO = "Ciao e benvenuto nel tuo TamaZoo!";
	private static final String ARRIVEDERCI = "Grazie per aver giocato! Alla prossima!";
	private static final String TITOLO = "Elenco opzioni:\n";
	private static final String ERRORE_SCELTA = "Attenzione: e' stata scelta un'opzione inesistente!";
	private static final String MESS_NUMERO_TAMA = "Quanti tamagotchi vuoi creare?";
	private static final String MESS_INSERISCI_NOME = "Che nome vuoi dare al tuo tamagotchi #";
	private static final int MIN_CAREZZE = 0;
	private static final int MAX_CAREZZE = 10;
	private static final int MIN_BISCOTTI = 0;
	private static final int MAX_BISCOTTI = 10;
	private static final int MIN_AFFETTO = 40;
	private static final int MAX_AFFETTO = 60;
	private static final int MIN_CIBO = 40;
	private static final int MAX_CIBO = 60;
	
	private static final String[] VOCI = {"Esci", "Dai carezze", "Dai biscotti"};
	
	public static void main(String[] args) {
		
		System.out.println(SALUTO);
		TamaZoo mioZoo = new TamaZoo();
		setUp(mioZoo);
		MyMenu menu = new MyMenu(TITOLO, VOCI);
		
		int scelta = 0;
		
		do {
			
			scelta = menu.scegliVoce();
			if (scelta != 0) {
				
				eseguiScelta(scelta, mioZoo);
				mioZoo.controllaTama();
				System.out.println(mioZoo.toString());
				
			}
			
		} while (scelta != 0);
		
		System.out.println(ARRIVEDERCI);

	}
	
	private static void setUp(TamaZoo mioZoo) {
		
		System.out.println(MESS_NUMERO_TAMA);
		int totale = MyUtil.leggiIntPositivo();
		
		for (int i = 1; i <= totale; i++){
			
			mioZoo.aggiungiTama(creaTama(i));
			
		}
		
	}
	
	private static void eseguiScelta(int scelta, TamaZoo mioZoo) {
		
		switch (scelta) {
		
		case 1: mioZoo.daiCarezze(MyUtil.randomInt(MIN_CAREZZE, MAX_CAREZZE)); break;
		
		case 2: mioZoo.daiBiscotti(MyUtil.randomInt(MIN_BISCOTTI, MAX_BISCOTTI)); break;
		
		default: System.out.println(ERRORE_SCELTA);
		
		}
		
	}
	
	private static Tamagotchi creaTama(int i) {
		
		System.out.println(MESS_INSERISCI_NOME + i + "?");
		String nome = MyUtil.leggiStringaConSpazi();
		int affetto = MyUtil.randomInt(MIN_AFFETTO, MAX_AFFETTO);
		int cibo = MyUtil.randomInt(MIN_CIBO, MAX_CIBO);
		
		int specie = MyUtil.randomInt(0, 2);
		switch (specie) {
		
		case 0: return new Tamagotchi(nome, affetto, cibo); break;
		
		case 1: return new Tamatriste(nome, affetto, cibo); break;
		
		case 2: return new Tamagordo(nome, affetto, cibo); break;
		
		default: return new Tamagotchi(nome, affetto, cibo); break;
		
		}
		
	}
	
}
