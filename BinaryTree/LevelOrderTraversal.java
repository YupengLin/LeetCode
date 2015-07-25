package BinaryTree;

import java.util.*;

public class LevelOrderTraversal {
	
      public List<List<Integer>> levelOrder(TreeNode root){
    	  List<List<Integer>> result=new ArrayList<List<Integer>>();
    	  List<TreeNode> level=new ArrayList<TreeNode>();
    	  
    	  if(root== null){
    		  return result;
    	  }
    	  
    	  level.add(root);
    	  
    	  while(true){
    		  if(level.isEmpty() || level.get(0)==null){
    			  break;
    		  }
    		  List<Integer> CurrentLevel=new ArrayList<Integer>();
    		  List<TreeNode> NextLevel=new ArrayList<TreeNode>();
    		  
    		  for(TreeNode n:level){
    			  CurrentLevel.add(n.val);
    			  if(n.left!=null){
    				  NextLevel.add(n.left);
    			  }
    			  if(n.right!=null){
    				  NextLevel.add(n.right);
    			  }
    		  }
    		  
    		  result.add(CurrentLevel);
    		  level=NextLevel;
    		  
    	  }
    	  return result;
      }
}
