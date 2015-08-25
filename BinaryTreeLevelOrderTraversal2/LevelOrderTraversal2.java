package BinaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal2 {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		 List<List<Integer>> result = new ArrayList<>();
		 List<TreeNode> level = new ArrayList<>();
		 if(root == null) {
			 return result;
		 }
		 level.add(root);
		 while(true) {
			 if(level.isEmpty() || level.get(0) == null) {
				 break;
			 }
			 List<Integer> currLevel = new ArrayList<>();
			 List<TreeNode> nextLevel = new ArrayList<>();
			 
			 for(TreeNode currNode : level) {
				 if(currNode.left != null) {
					 nextLevel.add(currNode.left);
				 }
				 if(currNode.right != null) {
					 nextLevel.add(currNode.right);
				 }
				 currLevel.add(currNode.val);
			 }
			 result.add(0,currLevel);
			 level = nextLevel;
		 }
	    
		 return result;
	    }

}
