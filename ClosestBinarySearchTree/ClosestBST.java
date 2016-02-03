package ClosestBinarySearchTree;

public class ClosestBST {
	 int posDiff;
	 int negDiff;
	 boolean smaller = true;
	 public int closestValue(TreeNode root, double target) {
		 if(root.left == null && root.right == null) {
			 return root.val;
		 }
		 int res = -1;
		 if((root.val == target) ||
			(root.val > target && root.left == null) ||
			(root.val < target && root.right == null)) {
			 return root.val;
		 } else if(root.val > target){
			 res = closestValue(root.left, target);
		 } else {
			 res = closestValue(root.right, target);
		 }
		 
		 return Math.abs(target - root.val) > Math.abs(target - res) ? res: root.val; 
	 }
	 
	 public static void main(String[] args) {
		 TreeNode node = new TreeNode(3);
		 TreeNode n2 = new TreeNode(-1);
		 ClosestBST cb = new ClosestBST();
		 node.left = n2;
		 System.out.println(cb.closestValue(node, -2));
	 }
}
