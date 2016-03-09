/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int [] dp = new int [n];
        dp[0] = 1;
        if(n >= 2){
            dp[1] = 1;
            if(s.charAt(1) == '0'){
                if(s.charAt(0) - '0' > 2){
                    return 0;
                }
            }
            else if(s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) - '0' < 7)){
                dp[1]++;
            }
        }
        for(int i = 2;i < n;i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) - '0' > 2 || s.charAt(i-1) == '0'){
                    return 0;
                }
                dp[i] = dp[i-2];
                continue;
            }
            dp[i] = dp[i-1];
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) - '0' < 7)){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n-1];
    }
}
