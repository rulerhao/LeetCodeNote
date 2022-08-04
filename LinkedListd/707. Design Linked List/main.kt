class ListNode {
    
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
    
}

class MyLinkedList {
    
    int size;
    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        // add the dummyNode as the default value
        head = new ListNode(0);
    }
    
    // O(n)
    public int get(int index) {
        // check index is legal
        if (index < 0) {
            return -1;
        }
        // if index is invalid
        if (index >= size) {
            return -1;
        }
        ListNode dummyNode = head;
        ListNode cur = dummyNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    // O(1)
    public void addAtHead(int val) {
        // dummyNode -> newHeadNode -> head
        ListNode dummyNode = new ListNode(0);
        ListNode newHeadNode = new ListNode(val);
        newHeadNode.next = head.next; // add head without dummyNode to newHeadNode
        dummyNode.next = newHeadNode; // add dummy node for newHeadNode
        head = dummyNode;
        size++;
    }

    // O(n)
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    // O(n)
    public void addAtIndex(int index, int val) {
        // check index is legal
        if (index < 0) {
            return;
        }
        // if index is invalid
        if (size < index) {
            return;
        }
        // 1: Listnode before index
        // 2: ListNode after index
        // 3: ListNode of new one
        // 1 -> 3 -> 2
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        if (index >= size) {
            return;
        }
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
        size--;
    }
}
