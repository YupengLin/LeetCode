package CompareVersionNumber;

public class CompareVersion {
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0, j = 0;
		for( ;i < v1.length && j < v2.length; i++, j++) {
			int stage1 = Integer.parseInt(v1[i]);
			int stage2 = Integer.parseInt(v2[j]);
			
			if(stage1 > stage2) {
				return 1;
			}
			if(stage1 < stage2) {
				return -1;
			}	
		}
		
		if(i == v1.length && j == v2.length) {
			return 0;
		} else if(i == v1.length && j < v2.length) {
			while(j < v2.length) {
				    int stage = Integer.parseInt(v2[j]);
					if(stage != 0)  return -1;
					j++;
			}
				return 0;
			
		} else {
			while(i < v1.length) {
				int stage = Integer.parseInt(v1[i]);
				if(stage != 0) return 1;
				i++;
				}
			return 0;
		}
	
	}
	
	public static void main(String[] args) {
		System.out.println(compareVersion("1.0.1", "1"));
	}
}
