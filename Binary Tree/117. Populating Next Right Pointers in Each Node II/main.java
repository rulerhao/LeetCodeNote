class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);
        
        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            
            Node cur = nodesQueue.poll();
            while (size > 0) {
                if (cur.left != null) nodesQueue.offer(cur.left);
                if (cur.right != null) nodesQueue.offer(cur.right);
                if (size != 1) {
                    Node next = nodesQueue.poll();
                    cur.next = next;
                    cur = next;
                } else {
                    cur.next = null;
                }
                size--;
            }
        }
        
        return root;
    }
}
