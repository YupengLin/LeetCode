package ReverseString2;

public class ReverseString2 {
	public void reverseWords(char[] s) {
		int start = 0;
		for(int i = 0; i < s.length; i++) {
			if(s[i] == ' ') {
				
				reverseSingleWord(s, start, i - 1);
				start = i + 1;
			}
			if(i == s.length - 1) {
				reverseSingleWord(s, start, i);
			}
		}
		for(char c : s) {
			System.out.print(c);
		}
		System.out.println("");
		reverseSingleWord(s, 0, s.length - 1);
	}
	
	private void reverseSingleWord(char[] word, int start, int end) {
		while(start <= end) {
			char temp = word[start];
			word[start] = word[end];
			word[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		String example = "the sky is blue";
		ReverseString2 rs = new ReverseString2();
		char[] toReverse = example.toCharArray();
		rs.reverseWords(toReverse);
		for(int i = 0; i < toReverse.length; i++) {
			System.out.print(toReverse[i]);
		}
	}
}
