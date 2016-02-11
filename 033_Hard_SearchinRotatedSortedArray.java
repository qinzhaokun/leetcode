/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Subscribe to see which companies asked this question
*/

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[l] < nums[r]){
                if(nums[mid] < target){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            else{
                if(nums[mid] < nums[r]){
                    if(target > nums[mid] && target <= nums[r]){
                        l = mid+1;
                    }
                    else{
                        r = mid-1;
                    }
                }
                else{
                    if(target >= nums[l] && target < nums[mid]){
                        r = mid-1;
                    }
                    else{
                        l = mid+1;
                    }
                }
            }
        }
        if(nums[l] == target){
            return l;
        }
        else{
            return -1;
        }
    }
}
