package IntersectionTwoLinkedList;

public class IntersectionTwoLinkedList {
	
	public static ListNode reverseLinkedList(ListNode list) {
		if(list == null) {
			return list;
		}
		if(list.next == null) {
			return list;
		}
		ListNode prev = list;
		ListNode curr = list.next;
		prev.next = null;
		
		while(curr != null) {
			ListNode afterCurr = curr.next;
			curr.next = prev;
			prev = curr;
			curr = afterCurr;
		}
		
		return prev;
		
	}
	
	public static void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.val+"; ");
			head = head.next;
		}
		System.out.println("");
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode tailA = reverseLinkedList(headA);
		//ListNode copyHeadA = (ListNode) headB.clone();
		ListNode tailB = reverseLinkedList(headB);
		
		printList(tailA);
		printList(tailB);
		if(tailA != tailB) {
			return null;
		}
		
		while(tailA.next == tailB.next) {
			tailA = tailA.next;
			tailB = tailB.next;
		}
		return tailA;
    }
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode b1 = new ListNode(3);
		ListNode c1 = new ListNode(Integer.MAX_VALUE);
		ListNode c2 = new ListNode(4);
		
		a1.next = a2;
		a2.next = c1;
		c1.next = c2;
		b1.next = c1;
		printList(a1);
		printList(b1);
		System.out.println("=======");
		
		ListNode intersection = getIntersectionNode(a1, b1);
		//System.out.println(intersection.val);
		
	}
	
}
