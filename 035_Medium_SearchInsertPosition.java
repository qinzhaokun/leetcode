/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
     int i = 0;
     int j = nums.length-1;
     if(target > nums[j]){
         return j+1;
     }
     while(i < j){
         int mid = i + (j-i)/2;
         if(target <= nums[mid]){
             j = mid;
         }
         else{
             i = mid + 1;
         }
     }
     return i;
    }
}
