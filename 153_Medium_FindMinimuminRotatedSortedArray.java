/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            if(nums[i] < nums[j]) return nums[i];
            int mid = i + (j-i)/2;
            if(nums[mid] >= nums[i]) i = mid+1;
            else if(nums[mid] < nums[j]) j = mid;
        }
        return nums[i];
    }
}
