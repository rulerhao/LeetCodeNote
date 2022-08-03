class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Null Check
        if (head == null)
            return head;
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        ListNode cur = dummyNode.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
