package RepeatedDNA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNA {
	 public static List<String> findRepeatedDnaSequences(String s) {
	     List<String> dna = new ArrayList<>();
	     HashSet<String> DnaCollection = new HashSet<>();
	     
	     
		 if(s.length() <= 10) {
			 return dna;
		 }
		 for(int i = 0; i <= s.length() - 10; i++) {
			 String fragment = s.substring(i, i + 10);
			 if(DnaCollection.contains(fragment) && !dna.contains(fragment)) {
				 dna.add(fragment);
			 } else {
				 DnaCollection.add(fragment);
			 }
		 }
		 return dna;
	    }
	 public static void main(String[] args) {
		 String s ="AAAAAAAAAAAAAAAC";
		 System.out.println(findRepeatedDnaSequences(s).toString());
	 }
}
