package TwoSum;

import java.util.HashMap;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		
			int[] index=new int[2];
			HashMap<Integer,Integer> num=new HashMap<Integer,Integer>();
			for(int i=0; i<numbers.length;i++){

				int remain=target-numbers[i];
				if(num.containsKey(remain)){
					int j=num.get(remain);
					index[0]=j;
					index[1]=i+1;
				}
				num.put(numbers[i],i+1);

			
			}
		return index;
	}
		
	
	public static void main(String[] args){
		Solution s=new Solution();
		int[] numbers={2,7,11,15};
		int [] index=s.twoSum(numbers, 17);
		System.out.println(index[0]);
		System.out.println(index[1]);
	}

}
