package FindPeakElement;

public class findPeakElement {
	public int findPeakElement(int[] nums) {
			int start = 0;
			int end = nums.length - 1;
			int mid =  (start + end) / 2;
			while(start <= end) {
				mid =  (start + end) / 2;
				System.out.println("start" + start + "end " + end + "mid "+ mid);
				if(mid > 0 && nums[mid] < nums[mid - 1]) {
					end = mid - 1;
				} else if(mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
					start = mid + 1;
				} else {
					return mid;
				}
			}
				return mid;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2};
		System.out.println(new findPeakElement().findPeakElement(nums));
	}
}
