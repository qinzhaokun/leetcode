/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean [][] dp = new boolean [n][n];
        for(int i = 0 ;i < n;i++){
            dp[i][i] = true;
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j + i < n;j++){
                if(s.charAt(j) == s.charAt(j+i) && ((i > 1 && dp[j+1][j+i-1]) || i == 1)){
                    dp[j][i+j] = true;
                }
            }
        }
        List re = new ArrayList();
        dfs(s,dp,0,re,new ArrayList());
        return re;
    }
    
    void dfs(String s, boolean [][] dp, int i, List re, List tmp){
        if(i == dp.length){
            re.add(new ArrayList(tmp));
        }
        else{
            for(int j = i;j < dp.length;j++){
                if(dp[i][j]){
                    tmp.add(s.substring(i,j+1));
                    dfs(s,dp,j+1,re,tmp);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}
