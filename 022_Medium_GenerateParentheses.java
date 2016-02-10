/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Subscribe to see which companies asked this question
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> re = new ArrayList<>();
        dfs(0,0,n,"",re);
        return re;
    }
    
    void dfs(int l, int r, int n, String tmp, List re){
        if(l == n){
            for(int i = tmp.length();i < 2*n;i++){
                tmp += ")";
            }
            re.add(tmp);
            return;
        }
        else if(l > r){
            dfs(l,r+1,n,tmp+")",re);    
        }
        dfs(l+1,r,n,tmp+"(",re);
    }
}
