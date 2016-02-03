package TwoSumDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSun {
	private List<Integer> numbers = new ArrayList<Integer>();
	private HashMap<Integer, Integer> count = new HashMap<>();
	public void add(int number) {
		numbers.add(number);
		if(count.containsKey(number)) {
			count.put(number, count.get(number) + 1);
		} else {
			count.put(number, 1);
		}
	}
	
	public boolean find(int value) {
		for(int num : numbers) {
			int num2 = value - num;
			if(num == num2) {
				if (count.containsKey(num) && count.get(num) >= 2) {
					return true;
				}
			} else {
				if (count.containsKey(num) && count.containsKey(num2)) {
					return true;
				}
			}
		}
		return false;
	}
}
