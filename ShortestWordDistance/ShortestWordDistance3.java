package ShortestWordDistance;

public class ShortestWordDistance3 {
	public static int shortestWordDistance(String[] words, String word1, String word2) {
		if(word1.equals(word2)) {
			return sameWordShortestDistance(words, word1, word2);
		}
		int last1 = -1;
		int last2 = -1;
		int minDistance = Integer.MAX_VALUE;
		int begin = 0; // 0 not find; 1 begin with 1; 2 begin with 2
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				
				if(last2 != -1) {
					minDistance = Math.min(minDistance, i - last2);
				}
//				if(last1 != -1) {
//					minDistance = Math.min(minDistance, i - last1);
//				}
				last1 = i;
			} else if(words[i].equals(word2)) {
				
				if(last1 != -1) {
					minDistance = Math.min(minDistance, i - last1);
				}
//				if(last2 != -1) {
//					minDistance = Math.min(minDistance, i - last2);
//				}
				last2 = i;
			}
		}
		return minDistance;
    }
	
	public static int sameWordShortestDistance(String[] words, String word1, String word2) {
		int lastIdx = -1;
		int minDist = Integer.MAX_VALUE;
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				if(lastIdx != -1) {
					minDist = Math.min(minDist, i - lastIdx);
				}
				lastIdx = i;
			}
		}
		return minDist;
	}
	
	public static void main(String[] args) {
		String[] words = {"a","b", "c", "d", "d"};
		System.out.println(shortestWordDistance(words, "d", "d"));
	}
}
