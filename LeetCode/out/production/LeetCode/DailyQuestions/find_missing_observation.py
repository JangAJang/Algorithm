class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        sum_rolls = sum(rolls)
        sum_rolls = mean * (len(rolls) + n) - sum_rolls

        if(sum_rolls < n): 
            return []
        
        if(sum / n > 6): 
            return []
        
        answer = [int(sum_rolls / n) for i in range (0, n)]

        left = sum_rolls % n

        index = 0

        while(left > 0):
            adder = min(6 - answer[index], left)
            answer[index] += adder
            left -= adder
            index+=1
        return answer
