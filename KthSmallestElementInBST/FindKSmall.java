package KthSmallestElementInBST;

public class FindKSmall {
	public int kthSmallest(TreeNode root, int k) {
		int[] ans = new int[1];
		ans[0] = 0;
		countNode(root, k, ans);
		return ans[0];
    }
	
	public int countNode(TreeNode root, int k, int[] ans){
		if(root == null) {
			return 0;
		}
		int leftTreeNode = countNode(root.left, k, ans);
		int rightTreeNode = countNode(root.right, k - leftTreeNode - 1, ans);
		if(k == leftTreeNode + 1) {
			ans[0] = root.val;
		}
		return leftTreeNode + rightTreeNode + 1;
	}

}
