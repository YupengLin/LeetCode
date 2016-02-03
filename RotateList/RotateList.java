package RotateList;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		int listLength = length(head);
		if( k == 0 || k % listLength == 0) {
			return head;
		}
		k = k % listLength;
		ListNode slow = head;
		ListNode fast = head;
		
		for(int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;
		return newHead;
	}
	
	private int length(ListNode head) {
		int len = 0;
		while(head != null) {
			head = head.next;
			len++;
		}
		return len;
	}
	
	private void print(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ,");
			head = head.next;
			
		}
	}
	
	public static void main(String[] args) {
		RotateList r = new RotateList();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 =  new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		r.print(r.rotateRight(a1, 2));
		
		
	}
}
