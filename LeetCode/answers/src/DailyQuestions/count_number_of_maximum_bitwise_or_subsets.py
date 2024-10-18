class Solution:

    def countMaxOrSubsets(self, nums: List[int]) -> int:
        max_value = 0
        count = 0

        for num in nums : 
            max_value |= num
        
        count_max(nums, 0, -1, max_value, 0)

        return count
        
    
    def count_max(nums: List[int], current: int, start: int, max_value: int, count: int) :
        for i in range(start+1, len(nums)):
            value = current | nums[i]
            if value == max_value : count +=1
            count_max(nums, value, i, max_value, count)

