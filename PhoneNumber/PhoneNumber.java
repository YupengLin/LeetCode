package PhoneNumber;
import java.util.*;
public class PhoneNumber {
public List<String> letterCombinations(String digits){
		
		List<String> set=new ArrayList<String>();
        int[] num=new int[digits.length()];
        for(int i=0;i<digits.length();i++){
        	num[i]=digits.charAt(i)-'0';
        	System.out.print(num[i]);
        }
        HashMap<Integer,String[]> map=new HashMap<Integer,String[]>();
        String[] one={};
        String[] two={"a","b","c"};
        String[] three={"d","e","f"};
        String[] four={"g","h","i"};
        String[] five={"j","k","l"};
        String[] six={"m","n","o"};
        String[] seven={"p","q","r","s"};
        String[] eight={"t","u","v"};
        String[] nine={"w","x","y","z"};

        map.put(1,one);
        map.put(2,two);
        map.put(3,three);
        map.put(4,four);
        map.put(5,five);
        map.put(6,six);
        map.put(7,seven);
        map.put(8,eight);
        map.put(9,nine);
        
        List<String> combo=new ArrayList<String>();
        if(digits.length()==0){
            combo.add("");
            return combo;
        }
        String line="";
        dfs(num,0,map,line,combo);
        return combo;




	}

	private void dfs(int[] num, int index,HashMap<Integer,String[]> map,String line,List<String> combo){
		if(index>num.length-1){
			String newLine=new String(line);
			combo.add(newLine);
			return;
		}
		int token=num[index];
		String[] bottom=map.get(token);
		for(String letter: bottom){
			line=line+letter;
			dfs(num,index+1,map,line,combo);
			line=line.substring(0,line.length()-1);
		}
               
	}
	
	public static void main(String[] args){
		PhoneNumber pn=new PhoneNumber();
		String p="23";
		List<String> ans=pn.letterCombinations(p);
		for(String le:ans){
			System.out.println(le);
		}
	}
}
