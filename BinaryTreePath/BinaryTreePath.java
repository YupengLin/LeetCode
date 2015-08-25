package BinaryTreePath;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> allPath = new LinkedList<String>();
		if(root == null) {
			return allPath;
		}
		String path = "";
		dfs(allPath, path, root);
		return allPath;
	}
	
	public void dfs(List<String> allPath, String singlePath,TreeNode root){
		if(singlePath.length() == 0) {
			singlePath = singlePath + root.val;
		} else {
			singlePath = singlePath + "->" + root.val;
		}
		if(root.left == null && root.right == null) {
			allPath.add(singlePath);
			return;
		}
		if(root.left != null) {
			dfs(allPath, singlePath, root.left);
		}
		if(root.right != null) {
			dfs(allPath, singlePath, root.right);
		}
	}

}
