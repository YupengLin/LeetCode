package SwapNodesInPairs;



public class NativeSolution {
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = prev.next;
		while(curr != null && curr.next != null) {
			ListNode tail = curr.next.next;
			ListNode toSwap = curr.next;
			prev.next = toSwap;
			prev.next.next = curr;
			curr.next = tail;
			
			prev = curr;
			curr = tail;
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
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		
		a1.next = a2;
		//a2.next = a3;
		//a3.next = a4;
		//a4.next = a5;
		//a5.next = a6;
		NativeSolution swapNode = new NativeSolution();
		swapNode.print(swapNode.swapPairs(a1));
	}
	
}
