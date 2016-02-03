package ShortestWordDistance;

public class ShortestWordDistance {
	public  static int shortestDistance(String[] words, String word1, String word2) {
		int last1 = -1;
		int last2 = -1;
		int minDistance = Integer.MAX_VALUE;
		int begin = 0; // 0 not find; 1 begin with 1; 2 begin with 2
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				last1 = i;
				if(last2 != -1) {
					minDistance = Math.min(minDistance, i - last2);
				}
			} else if(words[i].equals(word2)) {
				last2 = i;
				if(last1 != -1) {
					minDistance = Math.min(minDistance, i - last1);
				}
			}
		}
		return minDistance;
	}
	
	public static void main(String[] args) {
		String[] words = {"a","a", "b", "a"};
		System.out.println(shortestDistance(words, "a", "b"));
	}
}
