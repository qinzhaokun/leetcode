/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution {
//dynamic programming twice
    public int minCut(String s) {
        int n = s.length();
        boolean [][] pa = new boolean [n][n];
        for(int i = 0;i < n-1;i++){
            pa[i][i] = true;
            if(s.charAt(i) == s.charAt(i+1)){
                pa[i][i+1] = true;
            }
        }
        pa[n-1][n-1] = true;
        for(int i = 2;i < n;i++){
            for(int j = 0;j < n;j++){
                if(j+i >= n){
                    break;
                }
                pa[j][j+i] = (pa[j+1][j+i-1] && s.charAt(j) == s.charAt(j+i));
            }
        }
        
        int [] mincut = new int [n+1];
        mincut[0] = 0;
        for(int i = 1;i <= n;i++){
            mincut[i]= mincut[i-1]+1;
            for(int j = i-1; j >=0 ;j--){
                if(pa[j][i-1]){
                  mincut[i] = Math.min(mincut[i],mincut[j]+1);  
                }
                
            }
        }
        
        return mincut[n]-1;
    }
}
