package AddTwoNumber;



public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		ListNode head = dummy;
		int carry = 0;
		while(l1!= null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			int first = sum % 10;
			carry = sum / 10;
			head.next = new ListNode(first);
			head = head.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null) {
			int sum = l1.val + carry;
			int first = sum % 10;
			carry = sum / 10;
			head.next = new ListNode(first);
			head = head.next;
			l1 = l1.next;
		}
		
		while(l2 != null) {
			int sum = l2.val + carry;
			int first = sum % 10;
			carry = sum / 10;
			head.next = new ListNode(first);
			head = head.next;
			l2 = l2.next;
		}
		
		if(carry != 0) {
			head.next = new ListNode(carry);
			head = head.next;
		}
		
		return dummy.next;
	}
	
	
	private void print(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ,");
			head = head.next;
			
		}
	}
	public static void main(String[] args) {
		AddTwoNumber ad = new AddTwoNumber();
		ListNode a1 = new ListNode(9);
		ListNode a2 = new ListNode(9);
		ListNode a3 = new ListNode(9);
		a1.next = a2;
		a2.next = a3;
		
		ListNode b1 = new ListNode(1);
		//ListNode b2 = new ListNode(6);
		//ListNode b3 = new ListNode(4);
		//b1.next = b2;
		//b2.next = b3;
		
		ad.print(ad.addTwoNumbers(a1, b1));
	}
}
