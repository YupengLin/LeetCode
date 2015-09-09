package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	 public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> rightSide = new ArrayList<>();
	        List<TreeNode> currentLevel = new ArrayList<>();
	        if(root == null) {
	        	return rightSide;
	        }
	        currentLevel.add(root);
	        while(true) {
	        	if(currentLevel.size() == 0) {
	        		break;
	        	}
	        	List<TreeNode> nextLevel = new ArrayList<>();
	        	
	        	for(int i = 0; i < currentLevel.size(); i++) {
	        		TreeNode node = currentLevel.get(i);
	        		if(node.left != null) {
	        			nextLevel.add(node.left);
	        		}
	        		if(node.right != null) {
	        			nextLevel.add(node.right);
	        		}
	        		if(i == currentLevel.size() - 1) {
	        			rightSide.add(new Integer(node.val));
	        		}
	        	}
	        	currentLevel = nextLevel;
	        }
	        return rightSide;
	    }
}
