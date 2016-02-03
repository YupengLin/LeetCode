package CountCompleteTree;

import java.util.ArrayList;
import java.util.List;

public class NativeSolution {
	public static int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		List<TreeNode> level = new ArrayList<TreeNode>();
		level.add(root);
		int number = 1;
		//level
		while(!level.isEmpty()) {
			List<TreeNode> nextLevel = new ArrayList<TreeNode>();
			for(TreeNode node : level) {
				if(node.left != null ) {
					number++;
					nextLevel.add(node.left);
				}
				if(node.right != null ) {
					number++;
					nextLevel.add(node.right);
				}
			}
			level = nextLevel;
		}
		
	return number;	
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		root.left = a2;
		root.right = a3;
		System.out.println(countNodes(root));
	}

}
