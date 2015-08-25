package MergeTwoSortList;

public class MergeTwoList {
	public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		ListNode pointer1 = l1;
		ListNode pointer2 = l2;
		ListNode MergedList = new ListNode(Integer.MAX_VALUE); /*dummy variable*/
		ListNode tail = MergedList;
		while(pointer1 != null && pointer2!= null){
			if(pointer1.val < pointer2.val){
				ListNode nextNode = new ListNode(pointer1.val);
				tail.next= nextNode;
				tail = tail.next;
				pointer1 = pointer1.next;
			} else {
				ListNode nextNode = new ListNode(pointer2.val);
				tail.next = nextNode;
				tail = tail.next;
				pointer2 = pointer2.next;
			}
		}
		if(pointer1 == null) {
			tail.next = pointer2;
		}
		if(pointer2 == null) {
			tail.next = pointer1;
		}
		
		return MergedList.next;
	}
	
	public static void printList(ListNode l){
		while(l != null){
			System.out.print(l.val);
			l = l.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(5);
		ListNode a4 = new ListNode(15);
		
		a3.next = a4;
		a2.next = a3;
		a1.next = a2;
		
		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(5);
		ListNode b4 = new ListNode(7);
		ListNode b5 = new ListNode(8);
		
		b4.next = b5;
		b3.next = b4;
		b2.next = b3;
		b1.next = b2;
		
		printList(a1);
		printList(b1);
		 
		ListNode mergedList = mergeTwoList(a1, b1);
		printList(mergedList);
		
	}
}
