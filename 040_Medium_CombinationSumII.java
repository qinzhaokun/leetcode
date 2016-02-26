/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
Subscribe to see which companies asked this question
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(0,candidates,target,tmp,re);
        return re;
    }
    
    void dfs(int i, int [] c, int target, List tmp, List re){
        if(target == 0){
            re.add(new ArrayList<>(tmp));
        }
        else if (target < 0){
            return;
        }
        else{
            for(int j = i;j < c.length;j++){
                if(target - c[j] < 0){
                    break;
                }
                if(j != i && c[j] == c[j-1]){
                    continue;
                }
                else{
                    tmp.add(c[j]);
                    dfs(j+1,c,target-c[j],tmp,re);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}
