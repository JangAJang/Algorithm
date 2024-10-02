import copy

class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        b=sorted(set(arr))
        c={ele:rank+1 for rank,ele in enumerate(b)}
        ranked_arr=[c[ele] for ele in arr]
        return ranked_arr