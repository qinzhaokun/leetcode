/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] isPa = new boolean [n][n];
        int start = 0;
        int end = 0;
        for(int i = 0;i < n;i++){
            isPa[i][i] = true;
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j+i < n;j++){
                if(s.charAt(j) == s.charAt(j+i) && (j+1>=j+i-1 || isPa[j+1][j+i-1])){
                    isPa[j][j+i] = true;
                    if(i > end-start){
                        start = j;
                        end = j+i;
                    }
                }
            }
        }
        return s.substring(start,end+1);
