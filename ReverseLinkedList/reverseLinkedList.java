package ReverseLinkedList;



public class reverseLinkedList {
	 public static ListNode reverseList(ListNode head) {
	        if(head == null || head.next == null) {
	        	return head;
	        }
	        ListNode prev = head;
	        ListNode curr = head.next;
	        prev.next = null;
	        while(curr != null) {
	        	ListNode next = curr.next;
	        	curr.next = prev;
	        	prev = curr;
	        	curr = next;
	        	print(head);
	        }
	        
	        return prev;
	    }
	 public static void print(ListNode head) {
			while(head != null) {
				System.out.print(head.val + " ,");
				head = head.next;
			}
			System.out.println("");
		}
	 
	 public static void main(String[] args) {
		 	ListNode n1 = new ListNode(1);
			ListNode n2 = new ListNode(2);
			ListNode n3 = new ListNode(3);
			ListNode n4 = new ListNode(4);
			ListNode n5 = new ListNode(5);
			n1.next = n2;
			n2.next = n3;
			n3.next = n4;
			n4.next = n5;
			
			reverseList(n1);
	 }
}
