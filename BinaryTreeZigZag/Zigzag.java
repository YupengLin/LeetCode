package BinaryTreeZigZag;
import java.util.*;
public class Zigzag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> zigzag=new ArrayList<List<Integer>>();
	   	List<TreeNode> level=new ArrayList<TreeNode>();
	   	if(root==null){
	   		return zigzag;
	   	}
	   	level.add(root);
	   	boolean reverse=false;
	   	while(!level.isEmpty()){
	   		List<Integer> currLevel=new ArrayList<Integer>();
	   		List<TreeNode> nextLevel=new ArrayList<TreeNode>();
	        
	        for(TreeNode currNode:level){
	        	if(currNode.left!=null){
	        		nextLevel.add(currNode.left);
	        	}
	        	if(currNode.right!=null){
	        		nextLevel.add(currNode.right);
	        	}
	        	currLevel.add(currNode.val);
	        }

	        if(reverse){
	        	Collections.reverse(currLevel);
	        }
	        	zigzag.add(currLevel);
	        	level=nextLevel;
	       
	            reverse=!reverse;

	   	}
	   	return zigzag;
	   }
}
