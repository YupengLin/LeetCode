package CompareVersionNumber;

public class CompareVersionNumber {
	public static int compareVersion(String version1, String version2){
		
		
		return -1;
	}
	
	
	public static int compareVersion1(String version1, String version2){
		float v1=convert(version1);
		float v2=convert(version2);
		if(v1>v2){
			return 1;
		}else if(v1<v2){
			return -1;
		}else{
			return 0;
		}
	}
	private static float convert(String version){
		float versionNumber=0;
		int devide=version.length();
		for(int i=0;i<version.length();i++){
			if(version.charAt(i)=='.'){
				devide=i;
				break;
			}
		}
		
		for(int expo=0,j=devide-1;j>=0;j--,expo++){
			versionNumber=(float) (versionNumber+(version.charAt(j)-'0')*Math.pow(10, expo));
			System.out.println("expo=="+expo+" ;j="+j+" ;version="+versionNumber);
		}
		for(int expo=-1,j=devide+1;j<version.length();j++,expo--){
			versionNumber=(float)(versionNumber+(version.charAt(j)-'0')*Math.pow(10, expo));
			System.out.println("expo=="+expo+" ;j="+j+" ;version="+versionNumber);

		}
		return versionNumber;
	}
	public static void main(String[] args){
		System.out.println(convert("1"));
		System.out.println(convert("0"));
		System.out.println(convert("12"));
		System.out.println(convert("1337"));
		
	}
}
