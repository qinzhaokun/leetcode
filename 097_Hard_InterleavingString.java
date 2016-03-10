/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int len = s3.length();
        if(len != m+n){
            return false;
        }
        int [] a = new int [128];
        int i = 0;
        for(;i < s1.length()&&i < s2.length();i++){
            a[s1.charAt(i)-' ']++;
            a[s2.charAt(i)-' ']++;
        }
        while(i < s1.length()){
            a[s1.charAt(i)-' ']++;
            i++;
        }
        while(i < s2.length()){
            a[s2.charAt(i)-' ']++;
            i++;
        }
        for(i = 0;i < s3.length();i++){
            a[s3.charAt(i) - ' ']--;
            if(a[s3.charAt(i) - ' '] < 0){
                return false;
            }
        }
        
        boolean [][] dp = new boolean [m+1][n+1];
        dp[0][0] = true;
        for(i = 1;i <= m;i++){
            if(s1.charAt(i-1) == s3.charAt(i-1)){
                dp[i][0] = true;
            }
            else{
                break;
            }
        }
        for(int j = 1;j <= n;j++){
            if(s2.charAt(j-1) == s3.charAt(j-1)){
                dp[0][j] = true;
            }
            else{
                break;
            }
        }
        
        for(i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                dp[i][j] = ((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }
        return dp[m][n];
    }
}
