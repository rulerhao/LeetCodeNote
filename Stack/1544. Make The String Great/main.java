class Solution {
    public String makeGood(String s) {
        Deque<Character> dq = new LinkedList<>();

        for (char c: s.toCharArray()) {
            if (!dq.isEmpty() && (dq.peekLast() - 'a' == c - 'A' || dq.peekLast() - 'A' == c - 'a')) {
                dq.pollLast();
                continue;
            }
            dq.addLast(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }

        return sb.toString();
    }
}
