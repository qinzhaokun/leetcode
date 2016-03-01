/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Subscribe to see which companies asked this 
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            if(max < i){
                return false;
            }
            else{
                if(max < i+nums[i]){
                    max = i+nums[i];
                }
            }
            if(max >= nums.length-1){
                return true;
            }
        }
        return true;
    }
}
