package ReorderList;

public class CycleList {
   public boolean hasCycle(ListNode head) {
	   ListNode fast=head;
	   ListNode slow=head;
	   
	   while(fast.next!=null && fast.next.next!=null && slow.next!=null){
		   fast=fast.next.next;
		   slow=slow.next;
		   
		   if(fast==slow){
			   return true;
		   }
	   }
	   return false;
        
    }
   
   public ListNode detectCycle(ListNode head){
	   ListNode fast=head;
	   ListNode slow=head;
	   boolean hasCycle=false;
	   while(fast.next!=null && fast.next.next!=null && slow.next!=null){
		   fast=fast.next.next;
		   slow=slow.next;
		   
		   if(fast==slow){
			  hasCycle=true;
			  break;
		   }
	   }
	   if(!hasCycle){
		   return null;
	   }else{
		   //fast will remain position and slow moves to head
		   //use the same speed they will collide in beginning node
		   slow=head;
		   while(slow!=fast){
			   slow=slow.next;
			   fast=fast.next;
		   }
		   return fast;
	   }
	     
    
   }
   
   
   public static void main(String[] args){
	   CycleList test1 =new CycleList();
	   
	   ListNode l1=new ListNode(1);
	   ListNode l2=new ListNode(2);
	   ListNode l3=new ListNode(3);
	   ListNode l4=new ListNode(4);
	   ListNode l5=new ListNode(5);
	   
	   l1.next=l2;
	   l2.next=l3;
	   l3.next=l4;
	   l4.next=l5;
	   l5.next=l1;
	   
	   System.out.println(test1.hasCycle(l1));
	   System.out.println(test1.detectCycle(l1).val);
   }
}
