/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int j = 1;
        for(int i = 2;i < nums.length;i++){
            if(nums[i] == nums[j] && nums[i] == nums[j-1]){
                count++;
            }
            else{
                if(j+1 != i){
                    int tmp = nums[i];
                    nums[i] = nums[j+1];
                    nums[j+1] = tmp;
                }
                j++;
            }
        }
        return nums.length-count;
    }
}
