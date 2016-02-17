/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Subscribe to see which companies asked this question
*/

public class Solution {
    public int singleNumber(int[] nums) {
        int re = 0;
        for(int i = 0;i < nums.length;i++){
            re ^= nums[i];
        }
        return re;
    }
}
