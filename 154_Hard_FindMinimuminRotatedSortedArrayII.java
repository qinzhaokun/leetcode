/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

public class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            if(nums[i] < nums[j]) return nums[i];
            int mid = i + (j-i)/2;
            if(nums[i] == nums[j]){
                if(nums[mid] > nums[i]) i = mid+1;
                else if(nums[mid] < nums[j]) j = mid;
                else if(nums[mid] == nums[i]) i++;
            }
            else{
                if(nums[mid] >= nums[i]) i = mid+1;
                else if(nums[mid] <= nums[j]) j = mid;
            }
        }
        return nums[i];
    }
}
