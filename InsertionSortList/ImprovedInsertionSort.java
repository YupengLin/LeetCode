package InsertionSortList;

public class ImprovedInsertionSort {
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode sortList = new ListNode(head.val);
		//ListNode iter = sortList;
		ListNode curr = head.next;
		
		while(curr != null) {
			ListNode iter = sortList;
			//System.out.println(curr.val);
			while(iter.next != null && iter.next.val < curr.val) {
				iter = iter.next;
			}
			if(curr.val > iter.val) {
				ListNode tail = iter.next;
				iter.next = new ListNode(curr.val);
				iter.next.next = tail;
			} else {
				ListNode begin = new ListNode(curr.val);
				begin.next = iter;
				sortList = begin;
			}
			curr = curr.next;
		}
		
		
		return sortList;
	}
	public static void print(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ,");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode sort = insertionSortList(n1);
		print(sort);
	}
}
