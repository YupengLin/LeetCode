package PartitionList;

public class PartitionList {
	public ListNode partition(ListNode head, int x){
		if(head==null){
        	return null;
        }

		ListNode small=null;
        ListNode sp=small;
        ListNode large=null;
        ListNode lp=large;

        ListNode curr=head;
        while(curr!=null){
           if(curr.val<x){

             if(small==null){
             	small=new ListNode(curr.val);
             	sp=small;
             	curr=curr.next;
             }else{

           	sp.next=new ListNode(curr.val);
           	sp=sp.next;
           	curr=curr.next;
            }
           }else{

            if(large==null){
            	large=new ListNode(curr.val);
            	lp=large;
            	curr=curr.next;
            }else{

           	lp.next=new ListNode(curr.val);
           	lp=lp.next;
           	curr=curr.next;
           }
           }

        }
       System.out.println("small");
        printList(small);
       System.out.println("large");
        printList(large);
      System.out.println("end large");
      if(sp!=null){
      sp.next=large;
      return small;
      }else{
          return large;
      }
	}
	
	public static void printList(ListNode head){
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
	public static void main(String[] args){
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		l1.next=l2;
		PartitionList pl=new PartitionList();
		ListNode ans=pl.partition(l1, 10);
		
		printList(ans);
	}

}
