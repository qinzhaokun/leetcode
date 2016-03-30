/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
*/

public class Solution {
    //自己的解法有些复杂，网上基于数组三次反转的，思路很好
    //先将5以前的数据翻转得到的数组是[4,3,2,1,5,6,7]
    //再将5及以后的数据翻转得到的数组是[4,3,2,1,7,6,5]
    //再将整个数组翻转即得到[5,6,7,1,2,3,4]. （即为所求）
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        if(k == 0){
            return;
        }
        int i = 0;
        int j = len-k-1;
        while(i< j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        i = len-k;
        j = len-1;
        while(i< j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        i = 0;
        j = len-1;
        while(i< j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
