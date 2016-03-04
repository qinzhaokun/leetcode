/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
          return 0;  
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int [m][n];
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        dp[0][0] = 1;
        for(int i = 1;i < n;i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            else{
                dp[0][i] = 1;
            }
        }
        
        for(int j = 1;j < m;j++){
            if(obstacleGrid[j][0] == 1){
                break;
            }
            else{
                dp[j][0] = 1;
            }
        }
        
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
