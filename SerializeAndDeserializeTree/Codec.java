package SerializeAndDeserializeTree;

import java.util.ArrayList;
import java.util.List;

public class Codec {
	
	public String serialize(TreeNode root) {
		/*StringBuilder buffer = new StringBuilder();
		serializeHelper(root, buffer);
		return buffer.toString();
		*/
		StringBuilder sb = new StringBuilder();    
	    helperS(root, sb);
	    return sb.toString();
	}
	
	private void helperS(TreeNode node, StringBuilder sb){
	    if(node == null){
	        sb.append("null").append(",");
	        return;
	    }

	    sb.append(node.val).append(",");

	    helperS(node.left, sb);
	    helperS(node.right, sb);
	}
	
	private void serializeHelper(TreeNode root, StringBuilder buffer) {
		if(root == null) {
			buffer.append("null,");
			System.out.println("null");
			return;
		} else {
			buffer.append(root.val + ",");
			System.out.println(root.val);
			serializeHelper(root.left, buffer);
			serializeHelper(root.right, buffer);
		}
	}
	
	public String bfs(TreeNode root) {
		String buffer = "";
		if(root == null) {
			return buffer;
		}
		List<TreeNode> layers = new ArrayList<TreeNode>();
		buffer += root.val;
		layers.add(root);
		while(layers.size() != 0) {
			List<TreeNode> nextLayer = new ArrayList<TreeNode>();
			for(TreeNode node : layers) {
				if(node.left == null) {
					buffer += "null,";
				} else {
					buffer += node.left.val;
					nextLayer.add(node.left);
				}
				
				if(node.right == null) {
					buffer += "null";
				} else {
					buffer += node.right.val;
					nextLayer.add(node.right);
				}
			}
			layers = nextLayer;
		}
		return buffer;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		Codec codec = new Codec();
		System.out.println(codec.serialize(node1));
		
	}

}
