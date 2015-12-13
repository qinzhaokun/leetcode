/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
Do you have a better hint? Suggest it!
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> re = new ArrayList<>();
        if(nums.length < 1){
            return re;
        }
        int num1 = nums[0];
        int count1 = 1;
        int num2 = 0;
        int count2 = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == num1 || count1 == 0){
                num1 = nums[i];
                count1++;
            }
            else if(nums[i] == num2 || count2 == 0){
                num2 = nums[i];
                count2++;
            }
            //同时丢掉三个不相同的元素，新的数组的结果和原数组结果相同
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == num1){
                count1++;
            }
            else if(nums[i] == num2){
                count2++;
            }
        }
        if(count1 > nums.length/3){
            re.add(num1);
        }
        if(count2 > nums.length/3){
            re.add(num2);
        }
        return re;
    }
}
