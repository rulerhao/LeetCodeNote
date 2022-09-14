class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort points according left x index.
        Arrays.sort(
            points, (p1, p2) -> {
                return p1[0] - p2[0];
            }
        );
        
        int count = 0;
        
        for (int i = 0; i < points.length; i++) {
            if (i + 1 < points.length) {
                // Left larger or equal to previous left 
                // but left can't larger than previous right.
                if (points[i][0] <= points[i + 1][0] && 
                    points[i][1] >= points[i + 1][0]) {
                    int rightestIndex = points[i][1];
                    i++;
                    if (rightestIndex > points[i][1]) {
                        rightestIndex = points[i][1];
                    }
                    
                    if (i + 1 < points.length) {
                        int nextBalloonIndex = i + 1;
                        while (points[i + 1][0] <= rightestIndex) {
                            i++;
                            if (i + 1 >= points.length) {
                                break;
                            } else {
                                if (rightestIndex > points[i][1]) {
                                    rightestIndex = points[i][1];
                                }
                            }
                        }
                    }
                }
            }
            count++;
        }
        return count;
    }
}
