import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class No21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode n = new ListNode(-1);
        ListNode guard = n;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                guard.next = l1;
                l1 = l1.next;
            }
            else {
                guard.next = l2;
                l2 = l2.next;
            }
            guard = guard.next;
        }
        if(l1 == null){
            guard.next = l2;
        }
        else {
            guard.next = l1;
        }
        return n;

    }


}
