package BullAndCow;

public class NativeSolution {
	public static String getHint(String secret, String guess) {
		int[] secretChar = new int[10];
		int[] guessChar = new int[10];
		
		for(int i = 0; i < secret.length(); i++) {
			int indexSecret = secret.charAt(i) - '0';
			int indexGuess = guess.charAt(i) - '0';
			
			secretChar[indexSecret]++;
			guessChar[indexGuess]++;
		}
		int overlap = 0;
		for(int i = 0; i < 10; i++) {
			if(secretChar[i] != 0 && guessChar[i] != 0) {
				overlap += Math.min(secretChar[i], guessChar[i]);
			}
		}
		int bulls = 0;
		int cows = 0;
		for(int i = 0; i < secret.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			}
		}
		cows = overlap - bulls;
		String hint = bulls + "A" + cows + "B"  ;
		return hint;
	}
	
	public static void main(String[] args) {
		System.out.println(getHint("1123", "0111"));
	}

}
