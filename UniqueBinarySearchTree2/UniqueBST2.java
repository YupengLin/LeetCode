package UniqueBinarySearchTree2;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.TreeNode;
public class UniqueBST2 {
	public List<TreeNode> generateTree(int n) {
		return genHelper(1, n);
	}
	
	public List<TreeNode> genHelper(int start, int end) {
		if(start > end) {
			List<TreeNode> result = new ArrayList<>();
			result.add(null);
			return result;
		}
		if(start == end) {
			List<TreeNode> result = new ArrayList<>();
			result.add(new TreeNode(start));
			return result;
		}
		List<TreeNode> result = new ArrayList<TreeNode>();
		List<TreeNode> left, right;
		for(int i = start; i <= end; i++) {
			left = genHelper(start, i - 1);
			right = genHelper(i + 1, end);
			for(TreeNode lNode : left) {
				for(TreeNode rNode : right) {
					TreeNode root = new TreeNode(i);
					root.left = lNode;
					root.right = rNode;
					result.add(root);
				}
			}
		}
		return result;
	}
}
