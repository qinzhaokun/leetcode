/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int j = 0;int min = nums.length+1;
        int local = 0;
        for(int i = 0; i < nums.length;i++){
            local += nums[i];
            if(local >= s){
                if(min > i-j+1) min = i-j+1;
                while(local >= s && j <= i){
                    local -= nums[j];
                    j++;
                    if(local >= s &&min > i-j+1) min = i-j+1;
                }
            }
        }
        return min == nums.length+1 ? 0 : min;
    }
}
