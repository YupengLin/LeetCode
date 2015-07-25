package PathSum;
import java.util.*;
public class PathSum {
	  public boolean hasPathSum(TreeNode root, int sum) {
	        if (root==null){
	            return false;
	        }
	        
	        ArrayList<TreeNode> nodes=new ArrayList<TreeNode>();
	        ArrayList<Integer> values=new ArrayList<Integer>();
	        nodes.add(root);
	        values.add(root.val);
	        while(nodes.size()!=0){
	            TreeNode curr=nodes.get(0);
	            int sumVal=values.get(0);
	            nodes.remove(0);
	            values.remove(0);
	            if(curr.left==null && curr.right==null && sumVal==sum){
	                return true;
	            }
	            if(curr.left!=null){
	                nodes.add(curr.left);
	                values.add(sumVal+curr.left.val);
	            }
	            if(curr.right!=null){
	                nodes.add(curr.right);
	                values.add(sumVal+curr.right.val);
	            }
	        }
	        return false;
	    }
	  
	  public boolean hasPathSum2(TreeNode root,int sum){
		  if(root==null){
			  return false;
		  }
		  if(root.val==sum && root.left==null && root.right==null){
			  return true;
		  }
		  return hasPathSum2(root.left,sum-root.val) || hasPathSum2(root.right,sum-root.val);
	  }
}
