/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re = new ArrayList<>();
        dfs(0,nums,new ArrayList<Integer>(), re);
        return re;
    }
    
    void dfs(int i, int [] nums, List tmp, List re){
            re.add(new ArrayList(tmp));
            int j = i;
            while (j < nums.length) {
                tmp.add(nums[j]);
                dfs(j+1,nums,tmp,re);
                tmp.remove(tmp.size() - 1);
                j++;
                while (j < nums.length && nums[j] == nums[j-1]) {j++;}
           
        }
    }
}
