package ExpressionAddOperation;

import java.util.ArrayList;
import java.util.List;

public class NativeSolution {
	public List<String> addOperator(String num, int target) {
		List<String> equations = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		dfs(equations, num, sb,  0, 0, target, 0);
		return equations;
		
	}
	
	private void dfs(List<String> equations, String num, StringBuilder sb, long prevResult, int end, int target, long multi) {

		if(end == num.length()) {
			if(prevResult == target) {
				
				equations.add(sb.toString());
			}
		}
		
		for(int i = 1; end + i <= num.length(); i++) {
			if(i > 1 && num.charAt(end) == '0') {System.out.println("jump");break;}
			long  currNum = Long.parseLong(num.substring(end, end + i));
			if(currNum == 0) {
				System.out.println("0");
				System.out.println(sb.toString());
			}
			int prevLength = sb.length();
			if(end == 0) {
				sb.append(currNum);
				dfs(equations, num, sb, currNum,  end + i, target, currNum);
				sb.setLength(prevLength);
			} else {
				sb.append("+").append(currNum);
				dfs(equations, num, sb, prevResult + currNum,  end + i, target, currNum);
				sb.setLength(prevLength);
				
				sb.append("-").append(currNum);
				dfs(equations, num, sb, prevResult - currNum,  end + i, target, -currNum);
				sb.setLength(prevLength);
				
				sb.append("*").append(currNum);
				dfs(equations, num, sb, prevResult - multi + multi * currNum,  end + i, target, multi * currNum);
				sb.setLength(prevLength);		
			}
		}	
	}
	
	public static void main(String[] args) {
		NativeSolution add = new NativeSolution();
		System.out.println(add.addOperator("000", 0));
	}
}
