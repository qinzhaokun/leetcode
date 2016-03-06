/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<Integer>(), re);
        return re;
    }
    
    void dfs(int [] nums, int i, List tmp, List re){
        if(nums.length == i){
            List<Integer> tmp1 = new ArrayList<>();
            for(int j = 0;j < tmp.size();j++){
                tmp1.add((int)tmp.get(j));
            }
            re.add(tmp1);
        }
        else{
            dfs(nums,i+1,tmp,re);
            tmp.add(nums[i]);
            dfs(nums,i+1,tmp,re);
            tmp.remove(tmp.size()-1);
        }
    }
}
