package SymmetricTree;

public class SymmetricTree {
	public static void main(String[] args){
	
	}
	public static boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
	
		return isSymmetricHelper(root.left, root.right);
	}
	
	public static boolean isSymmetricHelper(TreeNode left,TreeNode right){
		if(left == null && right == null){
			return true;
		}
		if(left == null || right == null){
			return false;
		}
		if(left.val != right.val){
			return false;
		}
		return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left); 
		
	}
	
	
}
