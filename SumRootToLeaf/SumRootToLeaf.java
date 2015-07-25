package SumRootToLeaf;

public class SumRootToLeaf {
	   public int sumNumbers(TreeNode root) {
	       if(root==null){
	           return 0;
	       } 
	       int[] num=new int [1];
	       int currentNum=0;
	       sumFromRoot(root,currentNum,num);
	       return num[0];
	       
	    }
	    
	    private void sumFromRoot(TreeNode root,int curr,int[] num){
	        if(root==null){
	            return;
	        }
	        curr=curr*10+root.val;
	        if(root.left==null && root.right==null){
	            num[0]=num[0]+curr;
	        }
	        if(root.left!=null){
	            sumFromRoot(root.left,curr,num);
	        }
	        if(root.right!=null){
	            sumFromRoot(root.right,curr,num);
	        }
	    }
}
