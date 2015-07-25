package BSTfromPreIn;

public class BSTfromPreIn {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart=0;
        int preEnd=preorder.length-1;
        int inStart=0;
        int inEnd=inorder.length-1;
        return buildTree(preorder,preStart,preEnd,inorder,inStart,inEnd);
    }
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int k=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[preStart]){
                k=i;
                break;
            }
        }
        int len=k-inStart;
        root.left=buildTree(preorder,preStart+1,preStart+len,inorder,inStart,k-1);
        root.right=buildTree(preorder,preStart+len+1,preEnd,inorder,k+1,inEnd);
        return root;
    }
}
