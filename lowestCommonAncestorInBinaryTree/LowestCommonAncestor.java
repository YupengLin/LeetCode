package lowestCommonAncestorInBinaryTree;

/**
 * Created by linyupeng on 9/20/15.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(covers(root.left, p) && covers(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(covers(root.right, p) && covers(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public boolean covers(TreeNode root, TreeNode target) {
        if(root == null) {
            return false;
        }
        if(root == target) {
            return true;
        }
        return covers(root.left, target) || covers(root.right, target);
    }
}
