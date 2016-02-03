package UniqueWordAbbreviation;

import java.util.Hashtable;

public class ValidWordAbbr {
    Hashtable<String, String> abbvs = new Hashtable<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String word : dictionary) {
            StringBuilder abv = new StringBuilder();
            int length = word.length() - 2;
            if(length <= 0) {
                abv.append(word);
                abbvs.put(abv.toString(), word);
                continue;
                
            } else {
                abv.append(word.charAt(0)).append(length).append(word.charAt(word.length() - 1));
            }
            if(abbvs.containsKey(abv.toString())) {
                abbvs.put(abv.toString(), "");
            } else {
                abbvs.put(abv.toString(), word);
            }
        }
    }

    public boolean isUnique(String word) {
         StringBuilder abv = new StringBuilder();
            int length = word.length() - 2;
            if(length <= 0) {
                abv.append(word);
            } else {
                abv.append(word.charAt(0)).append(length).append(word.charAt(word.length() - 1));
            }
          return abbvs.containsKey(abv.toString()) && abbvs.get(abv.toString()).equals(word);
            
    }
    
    public static void main(String[] args) {
    	String[] dict = { "dog", "dug", "a", "card"};
    	ValidWordAbbr vw = new ValidWordAbbr(dict);
    	System.out.println(vw.isUnique("oa"));
    }
}
