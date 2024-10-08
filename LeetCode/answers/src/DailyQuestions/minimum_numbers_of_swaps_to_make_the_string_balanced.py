class Solution:
    def minSwaps(self, s: str) -> int:
        size = 0

        for each in s :
            if each == '[':
                size += 1
                continue
            if size > 0 : 
                size -= 1
        return int((size + 1) / 2)