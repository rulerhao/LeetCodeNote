class LRUCache {

    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        if (map.size() > capacity) {
            Node lru = head.next;
            map.remove(lru.key);
            remove(lru);
        }
    }
    
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void insert(Node node) {
        Node prev = tail.prev;
        Node next = tail;
        
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }
    
    class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;
        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
