package ReverseStringWordByWorld;

public class NativeSolution {
	public String reverseWords(String s) {
		//s.replace("^\\s", " ");
		s = s.trim();
		String[] tokens =s.split("\\s+");
		System.out.println(tokens.length);
		int i = 0;
		int j = tokens.length - 1;
		while(i <= j) {
			String temp = tokens[i];
			tokens[i] = tokens[j];
			tokens[j] = temp;
			i++;
			j--;
		}
		StringBuilder result = new StringBuilder();
		for(int k = 0; k < tokens.length; k++) {
			if(k == tokens.length - 1) {
				result.append(tokens[k]);
			} else {
				result.append(tokens[k] + " ");
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		NativeSolution reverse = new NativeSolution();
		reverse.reverseWords(" 1");
	}
}
