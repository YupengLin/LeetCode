package LowestCommonAncestor;

public class LowestCommonAncestor {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val <= root.val && q.val >= root.val) {
			return root;
		}
		if(p.val >= root.val && q.val <= root.val) {
			return root;
		}
		if(p.val <= root.val && q.val <= root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if(p.val >= root.val && q.val >= root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return null;
	}
	public static void main(String[] args) {
		
	}
}
