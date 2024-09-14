package DailyQuestions;

import java.util.*;


public class LongestSubarrayOfBitwiseAnd {

    public int longestSubarray(int[] nums) {
        int length = 0;
        int max = 0;
        
        for(int i=0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        
        int count=0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==max){
                count++;
                length = Math.max(length,count);
            }else{
                count = 0;
            }
        }
        return length;
    }
}