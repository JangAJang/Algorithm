class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        subarray = self.get_subarray(arr)
        answer = []
        for query in queries :
            answer.append(subarray[query[0]] ^ subarray[query[1]] ^ arr[query[0]])
        return answer
        
    def get_subarray(self, arr: List[int]):
        subarray = []
        for i in arr: 
            if len(subarray) == 0 :
                subarray.append(i)
                continue
            subarray.append(subarray[-1] ^ i)
        return subarray