class Solution {
    // public boolean stoneGame(int[] piles) {
    //     int left = 0;
    //     int right = piles.length - 1;
    //     int aliceProfit = 0;
    //     int bobProfit = 0;
    //     for (int i = 0; i < piles.length; i++) {
    //         if (piles.length - i < 2) {
    //             System.out.println(left + ", " + right);
    //             System.out.println(aliceProfit + ", " + bobProfit);
    //             if (piles[left] > piles[right]) {
    //                 aliceProfit += piles[left];
    //                 bobProfit += piles[right];
    //             } else {
    //                 aliceProfit += piles[right];
    //                 bobProfit += piles[left];
    //             }
    //         } else {
    //             System.out.println(left + ", " + right);
    //             System.out.println(aliceProfit + ", " + bobProfit);
    //             // choose left
    //             int leftProfit = Math.min(piles[left] - piles[left + 1], piles[left] - piles[right]);
    //             // choose right
    //             int rightProfit = Math.min(piles[right] - piles[right - 1], piles[right] - piles[left]);
    //             if (leftProfit > rightProfit) {
    //                 if (i % 2 == 0) aliceProfit += piles[left];
    //                 else bobProfit += piles[left];
    //                 left++;
    //             } else {
    //                 if (i % 2 == 0) aliceProfit += piles[right];
    //                 else bobProfit += piles[right];
    //                 right--;
    //             }
    //         }
    //     }

    //     System.out.println(aliceProfit + ", " + bobProfit);
    //     return aliceProfit > bobProfit;
    // }

    public boolean stoneGame(int[] p) {
        int[] dp = Arrays.copyOf(p, p.length);;
        for (int d = 1; d < p.length; d++)
            for (int i = 0; i < p.length - d; i++)
                dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
                
        return dp[0] > 0;
    }
}   
