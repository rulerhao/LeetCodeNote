## 解法
### 解法1
暴力解

用兩個 For 迴圈搜尋是否有這個字串

時間複雜度 O(m*n) // m 為 Txt 的長度, n 為 pattern 的長度
### 解法2
用 KMP 算法解

可以想成紀錄過去走過的路程，讓走過的路不要完全重新開始走

時間複雜度 O(m+n) // m 為 Txt 的長度, n 為 pattern 的長度
