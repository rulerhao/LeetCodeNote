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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode postNode = new ListNode(-1);
        postNode.next = head;
        
        preNode = preNode.next;
        postNode = postNode.next;
        
        while (n > 0) {
            postNode = postNode.next;
            n--;
        }
        
        if (postNode == null) {
            return head.next;
        }
        while (postNode.next != null) {
            preNode = preNode.next;
            postNode = postNode.next;
        }
        
        preNode.next = preNode.next.next;
        
        return head;
    }
}
