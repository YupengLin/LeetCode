package BinarySearchTreeIterator;

import java.util.Stack;

/**
 * Created by linyupeng on 9/20/15.
 */
public class BSTIterator {
    /**
     * Precondition: the top of the stack is current smallest node (t)
     *               whose value will be returned
     *
     * Postcondition: the top of the stack is the next smallest node.
     *
     * if the t has right node, the next smallest node will be the left
     * most of the right node; otherwise, the next smallest node is t's parent node,
     * which has already been pushed on the stack just before the t.
     * */
    Stack<TreeNode> nodeStack = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode curr = root;
        while(curr != null) {
            nodeStack.push(curr);
            curr = curr.left;
        }
    }

    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    public int next() {
        if(hasNext()) {
            TreeNode curr = nodeStack.pop();
            int returnVal = curr.val;
            if (curr.right != null) {
                curr = curr.right;

                while (curr != null) {
                    nodeStack.push(curr);
                    curr = curr.left;
                }
            }
            return returnVal;
        } else {
            return -1;
        }
    }
}
