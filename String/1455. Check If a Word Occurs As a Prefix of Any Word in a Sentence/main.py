class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        sIdx = 0
        wIdx = 0
        for i in range(len(sentence)):
            char = sentence[i]
            # First word
            if i == 0 or sentence[i - 1] == ' ':
                sIdx += 1
                if char == searchWord[wIdx]:
                    wIdx += 1
                    if wIdx == len(searchWord):
                        return sIdx
                    continue
                else:
                    wIdx = 0
            # Following word
            else:
                if wIdx == 0:
                    continue
                if char == searchWord[wIdx]:
                    wIdx += 1
                    if wIdx == len(searchWord):
                        return sIdx
                    continue
                else:
                    wIdx = 0

        return -1
