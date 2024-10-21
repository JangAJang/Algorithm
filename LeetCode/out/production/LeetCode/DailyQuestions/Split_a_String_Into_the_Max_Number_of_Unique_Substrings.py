import copy


class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        return self.count_substring(self, s, [], 0)

    def count_substring(self, s:str, arr:[str], start:int) -> int:
        value = len(arr)

        for i in range(start+1, value+1):
            split = s[start:i]
            copy_array = copy.deepcopy(arr)
            if split not in copy_array : copy_array.append(split)
            value = max(value, self.count_substring(s, copy_array, i))

        return value



