package IntersectionTwoMergedList;

public class IntersectionTwoMergedList {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = getListLength(headA);
		int lengthB = getListLength(headB);
		ListNode alternative = null;
		if(lengthA > lengthB) {
			int offset = lengthA - lengthB;
			while( offset != 0) {
				headA = headA.next;
				offset--;
			}
		} else {
			int offset = lengthB - lengthA;
			while(offset != 0) {
				headB = headB.next;
				offset--;
			}
		}
		
		while(headA != null) {
			if(headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		
		return null;
	}
	
	public static int getListLength(ListNode list) {
		int length = 0;
		ListNode curr = list;
		while(curr != null) {
			curr = curr.next;
			length++;
		}
		return length;
	}
	
	public static void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ;");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode b1 = new ListNode(4);
		ListNode b2 = new ListNode(5);
		ListNode c1 = new ListNode(Integer.MAX_VALUE);
		ListNode c2 = new ListNode(6);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = c1;
		c1.next = c2;
		b1.next = b2;
		b2.next = c1;
		System.out.println(getIntersectionNode(a1,b1).val);
	}
}
