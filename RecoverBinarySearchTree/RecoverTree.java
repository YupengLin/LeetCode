package RecoverBinarySearchTree;

public class RecoverTree {
	TreeNode firstElement;
	TreeNode secondElement;
	TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
		traverse(root);
		if(firstElement != null && secondElement != null) {
			int temp = firstElement.val;
			firstElement.val = secondElement.val;
			secondElement.val = temp;
		}
		
		
	}
	
	public void traverse(TreeNode root) {
		if(root == null) {
			return;
		}
		traverse(root.left);
		
		if(firstElement == null && prevElement.val > root.val) {
			firstElement = root;
		}
		if(firstElement != null && prevElement.val > root.val) {
			secondElement = root;
		}
		prevElement = root;
		
		traverse(root.right);
	}
}
