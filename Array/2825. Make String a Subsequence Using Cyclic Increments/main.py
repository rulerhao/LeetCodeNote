class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        str2Idx = 0
        for i in range(len(str1)):
            if ord(str1[i]) == ord(str2[str2Idx]) or ord(str1[i]) + 1 == ord(str2[str2Idx]) or ord(str1[i]) - 25 == ord(str2[str2Idx]):
                str2Idx += 1
                if str2Idx >= len(str2):
                    return True
            
        return str2Idx >= len(str2)
