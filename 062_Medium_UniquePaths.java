/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

//fomula
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        double total = 1;
        for(int i = 0;i < m-1;i++){
            total *= (double)(n+i)/(double)(i+1);
        }
        return (int) Math.round(total);
    }
}

//dp
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        int [][] nums = new int [m][n];
        for(int i = 0;i < n;i++){
            nums[0][i] = 1;
        }
        for(int j = 0;j < m;j++){
            nums[j][0] = 1;
        }
        
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                nums[i][j] = nums[i-1][j] + nums[i][j-1];
            }
        }
        return nums[m-1][n-1];
    }
}
