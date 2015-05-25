
public class TamaTriste extends Tamagotchi {
	
	private String nome;
	private  final static double AFFETTO = 0;
	private double cibo;
	
	public TamaTriste ( String nome, double cibo){
		
		super(nome, AFFETTO, cibo);

	}
	
	
	public boolean isAlive(){
		
		if(cibo<=MAX || cibo>=MIN){
			return false;
		}
		
		return true;
	}
	
	public boolean isHappy(){
		
		return false;
	}
	
	
	
}
