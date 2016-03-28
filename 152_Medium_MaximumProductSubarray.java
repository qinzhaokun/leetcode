/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int max = nums[0];
        int local_max = nums[0];
        int local_min = nums[0];
        for(int i = 1;i < n;i++){
            int tmp = local_max;
            local_max = Math.max(nums[i],Math.max(local_max*nums[i],local_min*nums[i]));
            local_min = Math.min(nums[i],Math.min(local_min*nums[i],tmp*nums[i]));
            if(local_max > max) max = local_max;
        }
        return max;
    }
}
