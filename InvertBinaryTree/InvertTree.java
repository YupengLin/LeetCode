package InvertBinaryTree;

public class InvertTree {

	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root; 
		}
		helper(root);
		return root;
	}
	
	public void helper(TreeNode root){
		if(root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		helper(root.left);
		helper(root.right);
	}
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode b1 = new TreeNode(2);
		a1.left = b1;
		System.out.println(a1.left.val);
		System.out.println(a1.right);
		
		TreeNode left = a1.left;
		TreeNode right = a1.right;
		
		a1.right = left;
		a1.left = null;
		System.out.println(a1.left);
		System.out.println(a1.right.val);
	}
}

