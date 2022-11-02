class Solution {
    public int minMutation(String start, String end, String[] bank) {
        recurse(start, end, bank, 0, new HashSet<String>());
        return count == Integer.MAX_VALUE ? -1 : count;
    }
    int count = Integer.MAX_VALUE;
    
    private void recurse(String start, String end, String[] bank, int soFar, Set<String> visited) {
        if (start.intern() == end.intern()) {
            count = Math.min(count, soFar);
        }

        for (String e : bank) {
            int diff = 0;
            for (int i = 0; i < e.length(); i++) {
                if(start.charAt(i) != e.charAt(i)) {
                    diff++;
                    if(diff > 1) break;
                }
            }
            if (diff == 1 && !visited.contains(e)) {
                visited.add(e);
                recurse(e, end, bank, soFar+1, visited);
                visited.remove(e);
            }
        }
    }
}
