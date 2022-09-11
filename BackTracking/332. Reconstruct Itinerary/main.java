class Solution {
    private LinkedList<String> res;
    private Stack<String> path = new Stack<>();
    private boolean[] used;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        used = new boolean[tickets.size()];
        path.push("JFK");
        backTracking((ArrayList) tickets);
        return res;
    }

    public boolean backTracking(ArrayList<List<String>> tickets) {
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(path.peek())) {
                path.push(tickets.get(i).get(1));
                used[i] = true;
                if (backTracking(tickets)) return true;
                used[i] = false;
                path.pop();
            }
        }
        return false;
    }
}
