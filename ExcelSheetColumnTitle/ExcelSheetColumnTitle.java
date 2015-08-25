package ExcelSheetColumnTitle;

public class ExcelSheetColumnTitle {

	public static void main(String[] args){
		System.out.println(convertToTitle(676));
	}
	
	public static String convertToTitle(int n){
		StringBuilder title = new StringBuilder();
		
		if(n <= 0){
			return null;
		}
		
		while(n != 0){
			char character = (char)(((n-1) % 26) +  65);
			
			System. out.println("character at :"+character);
			System. out.println("number at :"+ (n % 26));
			title.append(character);
			n = (n-1) / 26;
		}
		
		return title.reverse().toString();
	}
}
