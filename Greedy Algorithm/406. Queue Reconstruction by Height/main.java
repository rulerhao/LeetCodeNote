class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 將 people 依據身高排序，身高高的排前面，當身高一樣的時候將站在前面的人數多的([1])排後面
        Arrays.sort(
            people, (p1, p2) -> {
                if (p1[0] == p2[0]) { 
                    return p1[1] - p2[1]; 
                } else {
                    return p2[0] - p1[0];
                }
            }
        );
        
        LinkedList<int[]> que = new LinkedList<>(); // 用 LinkedList 可以讓 插入只需要 O(1)

        for (int[] person : people) {
            que.add(person[1], person);
        }

        return que.toArray(new int[people.length][]);
    }
}
