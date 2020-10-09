package lab01;

public class CoinFlipExperiment {
	public static void main(String[] args) {
		int amount = coinFlipExperiment();
		System.out.println("Win/loss amount: " + "$" + amount);
	}
	static public int coinFlipExperiment() {
		
		int amount = 0;
		for(int i = 0; i<100; i++) {	
		double flip = Math.random();
		  if (flip < 0.505) {
		    System.out.println ("Heads");
		    --amount;
		  }
		  else {
		    System.out.println ("Tails");
		    ++amount;
		  }
		  
		} 
		return (amount);
	}
}

