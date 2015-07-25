package BinaryTree;

public class BalancedTree {
	private int height(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftHeight=0;
		int rightHeight=0;
		if(root.left!=null){
			 leftHeight=height(root.left);
		}
		if(root.right!=null){
			rightHeight=height(root.right);
		}
		return 1+Math.max(leftHeight, rightHeight);
	}
	
	public boolean isBalanced(TreeNode root){
		if(root==null){
			return true;
		}
	    int leftHeight=0;
	    int rightHeight=0;
	    if(root.left!=null){
	    	leftHeight=height(root.left);
	    }
	    if(root.right!=null){
	    	rightHeight=height(root.right);
	    }
	    int diff=Math.abs(leftHeight-rightHeight);
	    return isBalanced(root.left) && isBalanced(root.right) && (diff<=1);
	}
	
	public static void main(String[] args){
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		t1.left=t2;
		t1.right=t3;
		t3.right=t4;
		t4.right=t5;
		
		BalancedTree bt1=new BalancedTree();
		System.out.println(bt1.height(t1));
		System.out.println(false==bt1.isBalanced(t1));
	}

}
