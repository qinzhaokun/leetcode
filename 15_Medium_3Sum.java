/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = 0-nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[k]+nums[j] == target){
                    if(!((j != i+1 && nums[j] == nums[j-1]) ||(k != nums.length-1 && nums[k] == nums[k+1]))){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        re.add(tmp);
                    }
                    j++;
                    k--;
                }
                else if(nums[k] + nums[j] > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return re;
    }
}
