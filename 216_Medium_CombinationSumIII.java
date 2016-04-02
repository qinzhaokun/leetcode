/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/


public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List re = new ArrayList();
        List tmp = new ArrayList();
        dfs(1,re,tmp,k,n);
        return re;
        
    }
    
    void dfs(int i, List re, List tmp, int k, int n){
        if(n >= 0 && k >= 0){
            if(n == 0 && k == 0) re.add(new ArrayList(tmp));
            else{
                for(int j = i;j < 10;j++){
                    tmp.add(j);
                    dfs(j+1,re,tmp,k-1,n-j);
                    tmp.remove(tmp.size()-1);
                }
            }
            
        }
    }
}
