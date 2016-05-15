/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class Solution {
    
    static int re = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        
        int [][] dp = new int [m][n];
        re = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(dp[i][j] == 0) dfs(matrix,dp,i,j);
            }
        }
        return re;
    }
    
    public void dfs(int [][] matrix, int [][] dp, int i, int j){
        int [][] d = {{0,-1},{0,1},{1,0},{-1,0}};
        
        int max = 0;
        for(int k = 0;k < 4;k++){
            int newI = i + d[k][0];
            int newJ = j + d[k][1];
            if(newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length && matrix[newI][newJ] > matrix[i][j]){
                if(dp[newI][newJ] == 0) dfs(matrix,dp,newI,newJ);
                if(dp[newI][newJ] > max) max = dp[newI][newJ];
            }
        }
        
        dp[i][j] = 1 + max;
        if(re < dp[i][j]) re = dp[i][j];
    }
}
