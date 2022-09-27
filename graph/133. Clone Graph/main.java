/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] visited = new Node[101];
    
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Arrays.fill(visited, null);
        
        Node copy = new Node(node.val);
        travel(node, copy);
        
        return copy;
    }
    
    private void travel(Node node, Node copy) {
        visited[copy.val] = copy;
        
        for (Node n: node.neighbors) {
            if (visited[n.val] == null) {
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);
                travel(n, newNode);
            } else {
                copy.neighbors.add(visited[n.val]);
            }
        }
    }
}
