/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/


public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = nums[0];
        int count = 1;
        for(int i = 1;i < n;i++){
            if(count == 0) {majority = nums[i];count = 1;}
            else if(nums[i] == majority) count++;
            else {count--;}
        }
        return majority;
    }
}
