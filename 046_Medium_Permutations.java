/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        perm(0,nums,re);
        return re;
    }
    
    void perm(int i,int[] nums,List re){
        if(i == nums.length){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0;j < nums.length;j++){
                tmp.add(nums[j]);
            }
            re.add(tmp);
        }
        else{
            int tmp = nums[i];
            for(int j = i;j < nums.length;j++){
                nums[i] = nums[j];
                nums[j] = tmp;
                perm(i+1,nums,re);
                nums[j] = nums[i];
            }
            nums[i] = tmp;
        }
    }
}
