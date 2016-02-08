/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int re = Integer.MAX_VALUE;
        int close = 0;
        for(int i = 0;i < nums.length;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                if(Math.abs(nums[i]+nums[j]+nums[k]-target) < re){
                    re = Math.abs(nums[i]+nums[j]+nums[k]-target);
                    close = nums[i]+nums[j]+nums[k];
                }
                if(nums[i]+nums[j]+nums[k] == target){
                    return target;
                }
                else if(nums[i]+nums[j]+nums[k] > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return close;
    }
}
