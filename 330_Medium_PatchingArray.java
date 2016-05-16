/*
Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.
*/

//standard solution
public class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int add = 0;
        int i = 0;
        while(miss <= n){
            if(i < nums.length && nums[i] <= miss){
                miss += nums[i++];
            }
            else{
                miss += miss;
                add++;
            }
        }
        return add;
    }
}

//my sloution
public int minPatches(int[] nums, int n) {
        boolean [] isReach = new boolean [n+1];
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = 1;j <= n-nums[i];j++){
                if(isReach[j]) isReach[j+nums[i]] = true;
            }
            isReach[nums[i]] = true;
        }
        for(int i = 1;i <= n;i++){
           if(!isReach[i]) {
               count++; 
               isReach[i] = true;
             for(int j = 1;j <= n-i;j++){
               if(!isReach[j+i] && j != i) isReach[i+j] = true;
            }  
           }
           
        } 
        return count;
    }
