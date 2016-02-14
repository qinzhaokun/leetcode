/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

Subscribe to see which companies asked this question
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1){
            return n;
        }
        int j = 1;
        for(int i = 1;i < n;i++){
            if(nums[i] != nums[j-1]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
