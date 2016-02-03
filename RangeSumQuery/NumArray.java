package RangeSumQuery;

public class NumArray {
	int[] numRecord;
    public NumArray(int[] nums) {
        numRecord = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	numRecord[i] = nums[i];
        }
    }

    void update(int i, int val) {
        numRecord[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
    	for(int k = i; k <= j; k++) {
        	sum += numRecord[k];
        }
    	return sum;
    }
}
