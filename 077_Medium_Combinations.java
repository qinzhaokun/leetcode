/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int [] a = new int [n];
        List<List<Integer>> re = new ArrayList<>();
        dfs(n,0,k,new ArrayList<Integer>(),re);
        return re;
    }

    void dfs(int n, int i, int k, List tmp, List re){
        if(k == 0){
            List<Integer> tmp1 = new ArrayList<>();
            for(int j = 0;j < tmp.size();j++){
                tmp1.add((int)tmp.get(j));
            }
            re.add(tmp1);
        }
        else{
            if(n-i >= k){
                    dfs(n,i+1,k,tmp,re);
                    tmp.add(i+1);
                    dfs(n,i+1,k-1,tmp,re);
                    tmp.remove(tmp.size()-1);

            }
        }
    }
}
