package RemoveDupFromSortList2;

import java.util.HashSet;

/**
 * Created by linyupeng on 9/19/15.
 */
public class RemoveDup2 {


    public static ListNode deleteDuplicatesFalse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        HashSet<Integer>  intCollection = new HashSet<>();
        intCollection.add(head.val);
       ListNode curr = head.next;

        ListNode prev = head;
       // ListNode start = head;
        int i = 0;
        while(curr != null) {
            if(!intCollection.contains(curr.val)) {
                intCollection.add(curr.val);
                System.out.println(curr.val + "; i= " + i);
                //curr.val += 100;
                prev = curr;
                curr = curr.next;

                i++;

            } else {
               prev.next = curr.next;
               curr = curr.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode noDup = new ListNode(0);
        ListNode noDupHead = noDup;
        ListNode curr = head;
        ListNode prev = head;

        if(curr.val != curr.next.val) {
            noDupHead.next = new ListNode(curr.val);
            noDupHead = noDupHead.next;
        }
        curr = curr.next;
        while(curr != null) {
            if(curr.val != prev.val) {
                if(curr.next == null || curr.val != curr.next.val) {
                    noDupHead.next = new ListNode(curr.val);
                    noDupHead = noDupHead.next;
                }
            }
            prev = prev.next;
            curr = curr.next;
        }

        return noDup.next;
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;

        n3.next =n4;
        n4.next = n5;
        n5.next = n6;
        printList(deleteDuplicates(n1));

    }

}
