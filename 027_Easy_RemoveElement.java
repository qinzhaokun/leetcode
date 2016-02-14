/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Subscribe to see which companies asked this question
*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n < 1){
            return n;
        }
        int j = 0;
        for(int i = 0;i < n;i++){
            if(nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
