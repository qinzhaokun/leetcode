/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        perm(0,nums,re);
        return re;
    }
    
    void perm(int i, int [] nums, List re){
        if(i == nums.length){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0;j < nums.length;j++){
                tmp.add(nums[j]);
            }
            re.add(tmp);
        }
        else{
            perm(i+1,nums,re);
            int tmp = nums[i];
            Map<Integer,Integer> map = new HashMap<>();
            map.put(tmp,1);
            for(int j = i+1;j < nums.length;j++){
                if(!map.containsKey(nums[j])){
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    perm(i+1,nums,re);
                    nums[j] = nums[i];
                    map.put(nums[j],1);
                }
            }
            nums[i] = tmp;
        }
    }
}
