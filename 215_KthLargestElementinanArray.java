/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
    //quicksort
    public int findKthLargest(int[] nums, int k) {
        return findK(nums,0,nums.length-1,k);
    }
    
    public int findK(int [] nums, int start, int end, int k){
        if(nums.length < 2){
            return nums[start];
        }
        int le = start+1;
        for(int i = start+1;i <= end;i++){
            if(nums[i] <= nums[start]){
                if(le != i){
                    int tmp = nums[i];
                    nums[i] = nums[le];
                    nums[le] = tmp;
                }
                le++;
            }
        }
        if(end-le+1 == k-1){
            return nums[start];
        }
        else if(end-le+1 > k-1){
            return findK(nums,le,end,k);
        }
        else{
            return findK(nums,start+1,le-1,k+le-end-2);
        }
    }
}
