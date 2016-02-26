/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/


//version one fast
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List re = new ArrayList();
        List temp = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates,0,temp,re,0,target);
        return re;
    }
    
    void dfs(int []candidates, int j, List temp,List re, int now,int target){
        if(now == target){
            List tt = new ArrayList(temp);
            re.add(tt);
            return;
        }
        if(now > target){
            return;
        }
        for(int i = j;i < candidates.length;i++){
            if(now+candidates[i] <= target){
                temp.add(candidates[i]);
                dfs(candidates,i,temp,re,now+candidates[i],target);
                temp.remove(temp.size()-1);
            }
        }
        
    }
}

//version two slow
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(0,candidates,target,re,tmp);
        return re;
    }
    
    void dfs(int i, int [] c, int target, List re, List tmp){
        if(target == 0){
            List<Integer> k = new ArrayList<>(tmp);
            re.add(k);
        }
        else if(target < 0 || i == c.length){
            return;
        }
        else{
                int k = target;
                while(k >= 0){
                    dfs(i+1,c,k,re,tmp);
                    tmp.add(c[i]);
                    k-=c[i];
                }
                k = target;
                while(k >= 0){
                    tmp.remove(tmp.size()-1);
                    k-=c[i];
                }
        }
    }
}
