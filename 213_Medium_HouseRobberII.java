/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/


public class Solution {
    public int rob(int[] nums) {
        int n = nums.length-1;
        if(n < 0) return 0;
        if(n == 0) return nums[0];
        int one = helper(nums,0,n-1);
        int two = helper(nums,1,n);
        return one > two ? one : two;
    }
    
    int helper(int [] nums, int l ,int r){
        int a = nums[l];
        int b = 0;
        for(int i = l+1;i <= r;i++){
            int tmp = a;
            a = nums[i] + b;
            if(b < tmp) b = tmp;
        }
        return a > b ? a : b;
    }
}
