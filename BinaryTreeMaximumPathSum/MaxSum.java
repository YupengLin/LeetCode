package BinaryTreeMaximumPathSum;

public class MaxSum {
	int maxValue = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		calculatePathSum(root);
		return maxValue;
	}
	
	private int calculatePathSum(TreeNode root) {
		if(root == null) { return 0;}
		int left = Math.max(0, calculatePathSum(root.left));
		int right = Math.max(0, calculatePathSum(root.right));
		maxValue = Math.max(maxValue, left + right + root.val);
		return Math.max(left, right) + root.val;
	}

}
