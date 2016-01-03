/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

//Solution1:
public class Solution {
    public int missingNumber(int[] nums) {
        int max = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != i){
                if(nums[i] == nums.length){
                    max = nums[i];
                }
                else{
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                    i--;
                }
            }
        }
        for(int i = 0;i < nums.length;i++){
            if(i != nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}

//Solution2:
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int max =0, min= nums[0], sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int correctSum = (max + 0) * (max - 0 + 1) / 2;
        return correctSum - sum;
    }
}

//Solution3:
public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i <= nums.length; i++){
            res ^= i == nums.length ? i : i ^ nums[i];
        }
        return res;
    }
}
