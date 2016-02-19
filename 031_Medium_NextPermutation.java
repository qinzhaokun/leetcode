/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i != -1){
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        int k = i+1;
        int j = n-1;
        while(k < j){
            int tmp = nums[k];
            nums[k] = nums[j];
            nums[j] = tmp;
            k++;
            j--;
        }
    }
}
