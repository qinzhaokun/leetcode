/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
*/

public class NumArray {

    int [] sums;
    public NumArray(int[] nums) {
        sums = new int [nums.length];
        if(nums.length > 0){
            sums[0] = nums[0];
        }
        for(int i = 1;i < nums.length;i++){
            sums[i] = sums[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return sums[j];
        }
        else{
            return sums[j]-sums[i-1];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
