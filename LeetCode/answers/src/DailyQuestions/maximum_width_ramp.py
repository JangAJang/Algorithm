class Solution:

    def possible(self, nums: List[int], width: int) -> bool:
        i=0
        j=width
        min_value = nums[i]
        while j < len(nums):
            if nums[j] >= min: 
                return True
            j += 1
            i += 1
            min_value = min(min_value, nums[i])
        return False
    
    def maxWidthRamp(self, nums: List[int]) -> int:
        low = 1
        high = len(nums)-1
        res = 0
        while low <= high : 
            mid = low + int((low + high) / 2)
            if possible(nums, mid): 
                res = mid
                low = mid + 1
                continue
            high = mid - 1
        return res
        


# public int maxWidthRamp(int[] nums) {
#         int low = 1, high = nums.length-1, res = 0;

#         while(low <= high) {
#             int mid = low + (high - low)/2;
#             if(possible(nums, mid)) {
#                 res = mid;
#                 low = mid + 1;
#                 continue;
#             }
#             high = mid - 1;
#         }
#         return res;
#     }

#     private boolean possible(int[] nums, int width) {
#         int i=0,j=width;
#         int min = nums[i];
#         while(j < nums.length) {
#             if(nums[j] >= min) return true;
#             j++;
#             min = Math.min(min, nums[++i]);
#         }
#         return false;
#     }