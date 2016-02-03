package RangeSumQuery;

public class SegmentTree {
	
	int[] segTree;
	int size;
	int[] source;
	
	public SegmentTree(int[] nums) {
		int len = nums.length;
		int height =(int) Math.ceil(Math.log(len) / Math.log(2));
		if(len != 0) {
		size = 2 * len - 1;
		segTree = new int[size];
		size = nums.length;
		source = nums;
		constructTree(nums, 0, len - 1, 0);
		} else {
			segTree = new int[0];
		}
	}
	
	public int mid(int start, int end) {
		return  (start + end) / 2;
	}
	
	public int constructTree(int[] nums, int start, int end, int treeIndex) {
		if(start == end) {
			segTree[treeIndex] = nums[start];
		} else {
			int mid = mid(start, end);
			segTree[treeIndex] = constructTree(nums, start, mid, 2 * treeIndex + 1) +
								 constructTree(nums, mid + 1, end, 2* treeIndex + 2);
		}
		
		return segTree[treeIndex];
	}
	
	public int sumRange(int i, int j) {
		if(source.length == 0) {
			return 0;
		}
		return sumRangeHelper(0, size - 1, i, j, 0);
	}
	
	public int sumRangeHelper(int start, int end, int queryStart, int queryEnd, int treeIndex) {
		if(queryStart <= start && queryEnd >= end) {
			return segTree[treeIndex];
		}
		if(end < queryStart|| start > queryEnd) {
			return 0;
		}
		int mid = mid(start, end);
		
		int right = sumRangeHelper(mid + 1, end, queryStart, queryEnd, 2 * treeIndex + 2);
		int left =  sumRangeHelper(start, mid, queryStart, queryEnd, 2 * treeIndex + 1);
		return left + right;
	}
	
	public void update(int i, int val) {
		int diff = val - source[i];
		source[i] = val;
		updateHelper(0, size - 1, i, 0, diff);
	}
	
	public void updateHelper(int start, int end, int i, int treeIndex, int diff) {
		if(i < start || i > end) {
			return;
		}
		
		segTree[treeIndex] = segTree[treeIndex] + diff;
		int mid = mid(start, end);
		if(start < end) {
			updateHelper(start, mid, i, 2 * treeIndex + 1, diff);
			updateHelper(mid + 1, end, i, 2 * treeIndex + 2, diff);
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		int[] nums = { -1,2,-3,4};
		SegmentTree segmentTree = new SegmentTree(nums);
		//System.out.println("finish");
		System.out.println(segmentTree.sumRange(1,3));
		segmentTree.update(0, 2);
		System.out.println(segmentTree.sumRange(1,3));
		
	}

}
