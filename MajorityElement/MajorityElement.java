package MajorityElement;

import java.util.Hashtable;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		Hashtable<Integer, Integer> elementSummary = new Hashtable<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			int frequent = 0;
			if(!elementSummary.containsKey(nums[i])) {
				frequent = 1;
				elementSummary.put(nums[i], 1);
			}else{
				frequent = elementSummary.get(nums[i]);
				frequent++;
				elementSummary.put(nums[i], frequent);
			}
			
		}
		int max_value = 0;
		int major = Integer.MAX_VALUE;
		for ( int key : elementSummary.keySet()){
			int frequency = elementSummary.get(key);
			if(frequency>max_value){
				major = key;
				max_value = frequency;
			}
		}
		return major;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,22,22,4,22,22};
		System.out.println(majorityElement(nums));
	}
}
