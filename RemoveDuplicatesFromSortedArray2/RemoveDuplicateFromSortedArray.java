package RemoveDuplicatesFromSortedArray2;

public class RemoveDuplicateFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		int i = 1;
		int j = 1;
		int count = 1;
		int total = 2;
		while(j < nums.length) {
			if(nums[j] != nums[j - 1]) {
				count = 1;
				nums[i] = nums[j];
				i++;
			} else {
				if(count < 2) {
					nums[i] = nums[j];
					i++; 
					count++;
				}
			}
			j++;
		}
		return i++;
	}
	
	public static void main(String[] args) {
		int[] dup = {1,1,1,2,2,3};
		System.out.print(removeDuplicates(dup));
	}

}
