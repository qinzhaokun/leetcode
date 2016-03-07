/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i <= j){
            int mid = i + (j-i)/2;
            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] > nums[i]){
                if(target < nums[mid] && target >= nums[i]){
                    j = mid-1;
                }
                else {
                    i = mid+1;
                }
            }
            else if(nums[mid] < nums[i]){
                if(target > nums[mid] && target <= nums[j]){
                    i = mid+1;
                }
                else {
                    j = mid-1;
                }
            }
            else {
                i++;
            }
        }
        return false;
    }
}
