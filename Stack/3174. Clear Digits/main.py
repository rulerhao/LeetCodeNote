class Solution:
    def clearDigits(self, s: str) -> str:
        def isDigit(s):
            for i in range(10):
                if s == str(i):
                    print(s, str(i))
                    return True
            return False

        st = []
        for i in range(len(s)):
            now = s[i]
            if st:
                top = st.pop()
                if isDigit(now) and not isDigit(top):
                    continue
                st.append(top)
            st.append(now)

        return ''.join(list(st))
