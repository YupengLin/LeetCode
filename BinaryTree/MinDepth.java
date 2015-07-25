package BinaryTree;

public class MinDepth {
public int minDepth(TreeNode root) {
        if(root==null){
        	return 0;
        }
        
        if(root.left==null && root.right==null){
        	return 1;
        }
        
        
        
        int leftHeight=Integer.MAX_VALUE;
        int rightHeight=Integer.MAX_VALUE;
        
        if(root.left!=null){
        	 leftHeight=minDepth(root.left);
        }
        if(root.right!=null){
        	rightHeight= minDepth(root.right);
        }
        return 1+Math.min(leftHeight, rightHeight);
    }
}
