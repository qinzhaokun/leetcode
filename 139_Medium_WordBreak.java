/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean [][] dp = new boolean [n][n];
        
        for(int i = 1;i <= n;i++){
            for(int j = 0; j + i <= n;j++){
                if(wordDict.contains(s.substring(j,j+i))) {dp[j][j+i-1] = true;continue;}
                for(int k = j;k < j+i-1;k++){
                    if(dp[j][k] && dp[k+1][j+i-1]) {dp[j][j+i-1] = true;break;}
                }
            }
        }
        
        return dp[0][n-1];
    }
}


public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean [] dp = new boolean [n+1];
        dp[0] = true;
        for(int i = 1;i <= n;i++){
            for(int j = 0;j < i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))) {dp[i] = true;break;}
            }
        }
        return dp[n];
    }
}
