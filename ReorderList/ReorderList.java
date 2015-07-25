package ReorderList;

public class ReorderList {
	
	
	
	/**
	 * 
	 * @param head
	 * @return reoder list
	 * first seperate two list
	 */
	public ListNode reorderList(ListNode head){
		ListNode fast=head;
		ListNode slow=head;
		
		while(fast!=null && fast.next!=null  && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			
		}
		
		ListNode second=slow.next;
		slow.next=null;
		printList(head);
		printList(second);
		// right now we have two list head and second
		
		second=reverseOrder(second);
		
		ListNode orderList=mergeTwoList(head,second);
		
		
		return orderList;
	}
	
	private ListNode reverseOrder(ListNode head){
		
		if(head == null || head.next == null){
			return head;
		}
		ListNode pre=head;
		ListNode curr=head.next;
		while(curr!=null){
			ListNode nextNode=curr.next;
			curr.next=pre;
			pre=curr;
			curr=nextNode;
		}
		head.next=null;
		return pre;
		
	}
	private ListNode mergeTwoList(ListNode first,ListNode second){
		
	    ListNode p1=first;
	    ListNode p2=second;
	    
	    while(p1!=null || p2 !=null){
	    	if(p1.next!=null && p2.next !=null){
	    		ListNode p3=p1.next;
	    		ListNode p4=p2.next;
	    		
	    		p1.next=p2;
	    		p2.next=p3;
	    		
	    		p1=p3;
	    		p2=p4;
	    		continue;
	    	}
	    	else if(p1.next==null && p2.next!=null){
	    		ListNode p4=p2.next;
	    		p1.next=p2;
	    		p2.next=p4;
	    		break;
	    	}
	    	else {
	    		//(p1.next!=null && p2.next==null)
	    		ListNode p3=p1.next;
	    		p1.next=p2;
	    		p2.next=p3;
	    		break;
	    	}
	    	
	    }
	    
		return first;
	}
	private void printList(ListNode head){
		while(head!=null){
			System.out.print(head.val+", ");
			head=head.next;
		}
		System.out.println("\n");
	}
	public void passTest(ListNode head){
		head.val=55;
		
	}
	public static void main(String[] args){
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(2);
		ListNode p3=new ListNode(3);
	    ListNode p4=new ListNode(4);
	    ListNode p5=new ListNode(5);
	    ListNode p6=new ListNode(6);
	    ListNode p7=new ListNode(7);
	    
	     System.out.println(p1.val);
	     
	    
	     ReorderList test1=new ReorderList();
	     test1.passTest(p1);
	     System.out.println(p1.val);
	    
	    /*
	    p1.next=p2;
	    p2.next=p3;
	    p3.next=p4;
	  //  p4.next=null;
	    
	    p4.next=p5;
	    p5.next=p6;
	    p6.next=p7;
	   
	 	     test1.printList(p1);
		 test1.printList(p5);
	   // ListNode concat=test1.mergeTwoList(p1,p5);
		 ListNode concat=test1.reorderList(p1);
	   // test1.printList(p1);
	   // test1.printList(p2);
	    test1.printList(concat);
	    
	    */
	    
	    
	    
	}
	
	
}
