package StrobogrammaticNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber2 {
	public List<String> findStrobogramatic(int n) {
		List<String> strobos = new ArrayList<>();
		String[] singlestroboNums = {"0", "1", "8"};
		Pair p1 = new Pair(1,1);
		Pair p6 = new Pair(6,9);
		Pair p8 = new Pair(8,8);
		Pair p9 = new Pair(9,6);
		Pair[] pairs = {p1, p6, p8, p9};
		if(n == 1) {
			
			for(String num : singlestroboNums) {
				strobos.add(num);
			}
			return strobos;
			
		}
		if( n % 2 != 0) {
			StringBuilder number = new StringBuilder();
			for(String num : singlestroboNums) {
				number = new StringBuilder();
				number.append(num);
				dfs(strobos, number, n, pairs);
			}
			return strobos;
		} else {
			dfs(strobos, new StringBuilder(), n, pairs);
			return strobos;
		}	
	}
	
	private void dfs(List<String> strobos, StringBuilder number, int n, Pair[] pairs) {
		if(number.length() == n) {
			strobos.add(new StringBuilder(number).toString());
			return;
		}
		
		if(number.length() < n - 2) {
			number.insert(0,"0");
			number.append("0");
			dfs(strobos, number, n, pairs);
			number.deleteCharAt(0);
			number.deleteCharAt(number.length() - 1);
		}
		
		for(Pair singleNumber : pairs) {
			number.insert(0, singleNumber.start);
			number.append(singleNumber.end);
			dfs(strobos, number, n, pairs);
			number.deleteCharAt(0);
			number.deleteCharAt(number.length() - 1);
		}
		
	}
	
	public class Pair{
		int start;
		int end;
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) {
		StrobogrammaticNumber2 sg = new StrobogrammaticNumber2();
		//StringBuilder sb = new StringBuilder();
		
		List<String> strobos = sg.findStrobogramatic(3);
		for(String num : strobos) {
			System.out.println(num);
		}
	}
}
