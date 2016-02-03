package WallsAndGates;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	 public static List<String> generatePossibleNextMoves(String s) {
		 List<String> nextStates= new ArrayList<>();
		 for(int i = 1; i < s.length(); i++) {
			 if(s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
				 StringBuilder next = new StringBuilder(s);
				 next.setCharAt(i - 1, '-');
				 next.setCharAt(i, '-');
				 nextStates.add(next.toString());
			 }
		 }
		 return nextStates;
	  }
	 
	 public static void main(String[] args) {
		 System.out.println(generatePossibleNextMoves("++++"));
	 }
}
