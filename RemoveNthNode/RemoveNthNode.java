package RemoveNthNode;

public class RemoveNthNode {
  public ListNode removeNthFromEnd(ListNode head, int n){
	  ListNode reOrder=reverse(head);
	  if(reOrder.next==null && n==1){
		  return null;
	  }
	  
	  ListNode prev=reOrder;
	  ListNode curr=reOrder.next;
	  System.out.println("curr="+curr.val+";prev="+prev.val);
	  if(n==1){
		  ListNode finalList=reverse(curr);
		  return finalList;
	  }
	  printList(reOrder);
	  int i=2;
	  while(i!=n){
		  ListNode next=curr.next;
		  prev=curr;
		  curr=next;
		  System.out.println("curr="+curr.val+";prev="+prev.val);
		  i++;
	  }
	  System.out.println("curr="+curr.val+";prev="+prev.val);
	  if(curr.next!=null){
	  prev.next=curr.next;
	  }else{
		  prev.next=null;
	  }
	  
	  ListNode finalList=reverse(reOrder);
	  
	  return finalList;
  }
  
  private ListNode reverse(ListNode head){
	  if(head.next==null){
		  return head;
	  }
	  ListNode prev=head;
	 
	  ListNode curr=head.next;
	  prev.next=null;
	  while(curr!=null){
		  ListNode next=curr.next;
		  curr.next=prev;
		  prev=curr;
		  curr=next;
	  }
	  return prev;
  }
  
  public void printList(ListNode head){
	  while(head!=null){
		  System.out.print(head.val+", ");
		  head=head.next;
	  }
	  System.out.println("");
  }
  
  public static void main(String[] args){
	  RemoveNthNode rm=new RemoveNthNode();
	  ListNode l1=new ListNode(1);
	  ListNode l2=new ListNode(2);
	  ListNode l3=new ListNode(3);
	  ListNode l4=new ListNode(4);
	  ListNode l5=new ListNode(5);
	  l1.next=l2;
	  l2.next=l3;
	  l3.next=l4;
	  l4.next=l5;
	  
	  ListNode de=rm.removeNthFromEnd(l1, 5);
	  rm.printList(de);
	  
	 
	  
  }
}
