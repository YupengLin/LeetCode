package InvertBinaryTree;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> treeLevel = new Stack<TreeNode>();
        //treeLevel.push(root);
        treeLevel.push(root.left);
        treeLevel.push(root.right);
        while(!treeLevel.isEmpty()) {
            TreeNode right = treeLevel.pop();
            TreeNode left = treeLevel.pop();
           
            if(right == null && left == null) continue;
            if(left == null) {
                left = right;
                right = null;
                treeLevel.push(left.left);
                treeLevel.push(left.right);
            }
            else if(right == null) {
                right = left;
                left = null;
                System.out.println(root.left == right);
                treeLevel.push(right.left);
                treeLevel.push(right.right);
            }
            else {
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
                treeLevel.push(left.right);
                treeLevel.push(right.left);
                treeLevel.push(left.left);
                treeLevel.push(right.right);
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode b1 = new TreeNode(2);
		
		a1.left = b1;
		
		
		System.out.println(a1.left.val);
		System.out.println(a1.right);
		
		Solution invertTree = new Solution();
		invertTree.invertTree(a1);
		//a1.left = null;
		
		System.out.println(a1.left);
		System.out.println(a1.right.val);
	}
}