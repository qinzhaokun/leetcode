/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
Subscribe to see which companies asked this question
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        for (int i = 0;i < nums.length;i++) {
            for (int j = i+1;j < nums.length;j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        
        List re = new ArrayList();
        for (int i = 0;i < nums.length;i++) {
            if (i>=1&&nums[i]==nums[i-1]) {
                continue;
            }
            for (int j = i+1;j < nums.length;j++) {
                if (j!=i+1&&nums[j]==nums[j-1]) {
                    continue;
                }
                int k = j+1;
                int l = nums.length-1;
                while (k < l) {
                    if (nums[i]+nums[j]+nums[k]+nums[l] < target) {
                        k++;
                    }
                    else if (nums[i]+nums[j]+nums[k]+nums[l] > target) {
                        l--;
                    }
                    else {
                        if (k==j+1 || l == nums.length-1 || (k>j+1&&nums[k]!=nums[k-1]&&l<nums.length-1&&nums[l]!=nums[l+1])) {
                            List tt = new ArrayList();
                            tt.add(nums[i]);
                            tt.add(nums[j]);
                            tt.add(nums[k]);
                            tt.add(nums[l]);
                            re.add(tt);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        
        return re;
    }
}
