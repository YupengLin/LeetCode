package TreeTraversal;
import java.util.*;
public class PostOrder {
	 public List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> record=new ArrayList<Integer>();
	        if(root==null){
	            return record;
	        }
	        post(record,root);
	        return record;
	        
	        
	    }
	    private void post(List<Integer> record, TreeNode root){
	        if(root==null){
	            return;
	        }
	        post(record,root.left);
	        post(record,root.right);
	        record.add(root.val);
	    }

}
