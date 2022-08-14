class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);
        
        while (nodesQueue.size() != 0) {
            int size = nodesQueue.size();

            Node cur = nodesQueue.poll();
            while (size > 0) {
                if (cur.left != null) nodesQueue.offer(cur.left);
                if (cur.right != null) nodesQueue.offer(cur.right);
                if (size == 1) {
                    cur.next = null; // next is null
                } else {
                    Node next = nodesQueue.poll();
                    cur.next = next;
                    cur = next;
                }
                size--;
            }
        }
        
        return root;
    }
}
