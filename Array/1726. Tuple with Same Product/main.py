class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        # Hashmap
        # Time Complexity: O(n^2)
        # Space Complexity: O(n^2) which is from hashmap.

        # Get counts of product.
        hashmap = {}
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                prod = nums[i] * nums[j]
                if not prod in hashmap:
                    hashmap[prod] = 0
                hashmap[prod] += 1

        res = 0

        # Each count contains (count choose 2) * 8 methods -- 8 if from each 2 pair of product contains 8 in the set.
        for key in hashmap:
            count = hashmap[key]
            if count > 1:
                res += count * (count - 1) // 2 * 8
        
        return res
