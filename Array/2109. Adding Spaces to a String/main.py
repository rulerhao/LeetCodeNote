class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        # res = ""
        # spacesIdx = 0
        # for i in range(len(s)):
        #     ch = s[i]
        #     if spacesIdx < len(spaces) and i == spaces[spacesIdx]:
        #         res = res + " "
        #         spacesIdx += 1
        #     res = res + s[i]

        # return res

        res = [" "] * (len(s) + len(spaces))
        spacesIdx = 0
        for i in range(len(s)):
            ch = s[i]
            if spacesIdx < len(spaces) and i == spaces[spacesIdx]:
                res[i + spacesIdx] = " "
                spacesIdx += 1
            res[i + spacesIdx] = ch
            
        return "".join(res)
