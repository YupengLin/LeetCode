package BinaryTree;

public class ConvertArrayToBST {
	public TreeNode sortedArrayToBST(int[] num){
		if(num.length==0){
			return null;
		}
		return sortedArrayToBST(num,0,num.length-1);
	}
	private TreeNode sortedArrayToBST(int[] num, int start, int end){
		if(start>end){
			return null;
		}
		int mid=(start+end)/2;
		TreeNode root=new TreeNode(num[mid]);
		root.left=sortedArrayToBST(num,start,mid-1);
		root.right=sortedArrayToBST(num,mid+1,end);
		return root;
	}
	public void inOrderPrinter(TreeNode root){
	
		if(root==null){
			return;
		}
		
		inOrderPrinter(root.left);
		System.out.println(root.val+", ");
		inOrderPrinter(root.right);
	}
	
	public static void main(String[] args){
		int[] num={1,2,3,4,5,6,7,8,9,10};
		ConvertArrayToBST bt1=new ConvertArrayToBST();
		TreeNode genNode=bt1.sortedArrayToBST(num);
		bt1.inOrderPrinter(genNode);
		
	}
	
	
}
