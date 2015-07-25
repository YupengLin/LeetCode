package InsertionSortList;

public class InsertSort {
	public ListNode insertionSortList(ListNode head){
		if(head==null){
			return null;
		}
		if(head.next==null){
			return head;
		}
		//ListNode prev=head;
		ListNode curr=head.next;
		ListNode newList=new ListNode(head.val);
	    ListNode newHead=newList;
	    boolean emptyTail=false;
		while(curr!=null){
			
				ListNode ListPointer=newHead;
				ListNode prev=null;
			if(curr.val<ListPointer.val){
				ListNode firstNode=new ListNode(curr.val);
				firstNode.next=newHead;
				newHead=firstNode;
				curr=curr.next;
			    continue;
			}
			
			while(curr.val>=ListPointer.val){
				if(ListPointer.next!=null){
					prev=ListPointer;
					ListPointer=ListPointer.next;
					
				}else{
					emptyTail=true;
					break;
				}
				  
			}
			if(emptyTail){
				ListNode tail=new ListNode(curr.val);
				ListPointer.next=tail;
				curr=curr.next;
				//continue;
			}else{
				ListNode toAdd=new ListNode(curr.val);
				prev.next=toAdd;
				toAdd.next=ListPointer;
				curr=curr.next;
			}
				
				
			}
		
		return newHead;
		}
	}


