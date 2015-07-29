package PalindromeLinkedList;

public class PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
        	return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
       // printList(head);
       // printList(fast);
        ListNode prev = slow;
        ListNode curr = slow.next;
        prev.next = null;
        
        while(curr != null) {
        	ListNode after = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = after;
        }
        /*1->2->3->4
         * 1->2<-2<-1
         * 
         * 1->2->3
         * 1->2<-3
         * 
         */
        
        
      
        while(head != null ) {
        	
        	if(prev.val != head.val) {
        		return false;
        	}
        	head = head.next;
        	prev = prev.next;
        }
        return true;
    }
	public static void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		System.out.println("answer should be false" + isPalindrome(l1));
		
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(1);
		ListNode t4 = new ListNode(1);
		
		t1.next = t2;
		t2.next = t3;
		//t3.next = t4;
		System.out.println("answer should be true" + isPalindrome(t1));
		
		
	}

}
