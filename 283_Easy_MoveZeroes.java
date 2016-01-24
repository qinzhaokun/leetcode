/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        int pos = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                if(pos == -1){
                    pos = i;
                }
            }
            else{
                if(pos != -1){
                    nums[pos] = nums[i];
                    nums[i] = 0;
                    pos++;
                }
            }
        }
    }
}

public class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                queue.offer(i);
            }
            else{
             if(!queue.isEmpty()){
                 int pos = (int)queue.poll();
                 nums[pos] = nums[i];
                 nums[i] = 0;
                 queue.offer(i);
             }   
            }
        }
    }
}
