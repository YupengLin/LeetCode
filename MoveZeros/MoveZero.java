package MoveZeros;

public class MoveZero {
	public void moveZeros(int[] nums) {
		int tail = 0;
		for(int i = 0; i < nums.length; i ++) {
			if(nums[i] != 0) {
				nums[tail] = nums[i];
				tail++;
			}
		}
		while(tail < nums.length) {
			nums[tail] = 0;
			tail++;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		
	}

}
