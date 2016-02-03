package FindMinimumInRotatedSortedArray;

public class FindMinRotateArray {
	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int mid = start + (end - start) / 2;
		while(start <= end) {
			mid = start + (end - start) / 2;
			if(nums[start] > nums[end]) {
				if(nums[start] <= nums[mid]) {start = mid + 1;}
				else if(mid >= 1 && nums[mid - 1] > nums[mid]) { return nums[mid];}
				else{
					end = mid - 1;
				}
			} else {
				return nums[start];
			}
		}
		return nums[0];
	}
	
	//public
	
	public static void main(String[] args) {
		int[] array = {3,1,2};
		System.out.println(findMin(array));
	}

}
