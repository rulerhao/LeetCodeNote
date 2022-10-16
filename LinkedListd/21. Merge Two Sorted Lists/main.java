/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return list1;
        ListNode curList1 = list1;
        ListNode curList2 = list2;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (curList1 != null || curList2 != null) {
            if (curList1 != null && curList2 != null) {
                if (curList1.val > curList2.val) {
                    head.next = new ListNode(curList2.val);
                    curList2 = curList2.next;
                } else {
                    head.next = new ListNode(curList1.val);
                    curList1 = curList1.next;
                }
            } else if (curList1 != null) {
                head.next = new ListNode(curList1.val);
                curList1 = curList1.next;
            } else if (curList2 != null) {
                head.next = new ListNode(curList2.val);
                curList2 = curList2.next;
            }
            head = head.next;
        }
        
        return res.next;
    }
}
