/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int re = nums[0];
        for(int i = 1;i < nums.length;i++){
            re = re ^ nums[i];
        }
        int [] result = new int [2];
        re = (re & (~(re-1)));//取re最后一位非0位，re一定是非0的
        for(int i = 0;i < nums.length;i++){
            if((re & nums[i]) == 0){
                result[0] ^= nums[i];
            }
            else{
                result[1] ^= nums[i];
            }
        }
        
        return result;//如此精妙，竟无言以对。
    }
}
