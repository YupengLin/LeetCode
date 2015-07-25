package RemoveDuplicated;
import java.util.*;

public class Problem1 {
	 public ListNode deleteDuplicates(ListNode head) {
	        if(head==null || head.next==null){
	   		return head;
	   	}
	   	HashSet<Integer> repeat =new HashSet<Integer>();
	   	ListNode curr=head;
	   	ListNode newList=new ListNode(curr.val);
	   	ListNode tail=newList;
	   	repeat.add(curr.val);
	    while(curr!=null){
	        if(!repeat.contains(curr.val)){
	        	repeat.add(curr.val);
	        	tail.next=new ListNode(curr.val);
	        	tail=tail.next;
	        }
	        curr=curr.next;
	        
	    }
	   return newList;
	   }

}
