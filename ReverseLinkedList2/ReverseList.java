package ReverseLinkedList2;

public class ReverseList {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = dummy.next;
        
        for(int i = 0; i < m - 1; i++) {
        	pre = pre.next;
        }
        curr = pre.next;
        System.out.println("curr = " + curr.val);
        for(int i = 0;i < n - m; i++) {
        	ListNode then = curr.next;
        	ListNode toConnect = pre.next;
        	curr.next = then.next;
        	then.next = toConnect;
        	pre.next = then;
        }
        
        return dummy.next;
    }

	public void print(ListNode head) {
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
		ReverseList reverse = new ReverseList();
		reverse.print(reverse.reverseBetween(n1, 1, 5));
		
	}
}
