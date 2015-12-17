/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] re = new int [nums.length];
        int pro = 1;
        for(int i = 0;i < nums.length;i++){
            re[i] = pro;
            pro *= nums[i];
        }
        pro = 1;
        for(int i = nums.length-1;i >= 0;i--){
            re[i] *= pro;
            pro *= nums[i];
        }
        return re;
    }
}
