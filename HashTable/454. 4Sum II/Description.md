## 題目

尋找四個 Int array 的總和為零的組合

## 範例

### Example 1:

Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]

Output: 2

Explanation:

The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

### Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]

Output: 1

## 解法
###
將兩個兩個的總和結果放進 Map 內，在另一個找尋前兩個的 Map 補值(0 - val)

### 時間複雜度
O(n^2)
