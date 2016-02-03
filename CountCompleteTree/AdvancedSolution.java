package CountCompleteTree;

public class AdvancedSolution {
	public static int  height(TreeNode root) {
		return root == null ? 0 : 1 + height(root.left);
	}
	
	public static int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		TreeNode left = root;
		int leftHeight = 0;
		while(left != null) {
			left = left.left;
			leftHeight++;
		}
		TreeNode right = root;
		int rightHeight = 0;
		while(right != null) {
			right = right.right;
			rightHeight++;
		}
		System.out.println(leftHeight);
		System.out.println(rightHeight);
		if(leftHeight == rightHeight) {
			return (1 << leftHeight) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}
	
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		
		a1.left = a2;
		a1.right = a3;
		System.out.println(countNodes(a1));
	}
}
