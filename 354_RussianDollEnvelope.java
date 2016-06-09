/*
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
*/

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        
        if(n <= 1) return n;
        
        int [] dp = new int [n];
        
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        for(int i = 0;i < n;i++){
            for(int j = i-1;j >=0;j--) if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && dp[i] < dp[j]+1) dp[i] = dp[j] + 1;
        }
        
        int ret = dp[0];
        for(int i = 1;i < n;i++) if(ret < dp[i]) ret = dp[i];
        
        return ret+1;
    }
}
