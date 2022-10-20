// Time Complexity = O(n) (Because the heap and queue's size is are <= 26)
// Space Complexity = O(1) (Because the heap and queue's size is are <= 26)
class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
        int[] sizeArr = new int[26];
        for (char task: tasks) sizeArr[task - 'A']++;
        
        PriorityQueue<Integer> sizeHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int size: sizeArr)
            if (size > 0) sizeHeap.add(size);
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        
        int time = 0;
        while (!sizeHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!sizeHeap.isEmpty()) {
                int size = sizeHeap.poll() - 1;
                if (size > 0) queue.offer(new Pair(size, time + n));
            }
            
            if (!queue.isEmpty() && queue.peek().getValue() == time) {
                int size = queue.poll().getKey();
                sizeHeap.offer(size);
            }
        }
        
        return time;
    }
}
