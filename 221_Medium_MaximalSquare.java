/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/

//base on DP, O(N^2)
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int [][] dp = new int [m][n];
        int max = 0;
        for(int i = 0;i < m;i++)
            if(matrix[i][0] == '1') {dp[i][0] = 1;max = 1;}
        for(int j = 0;j < n;j++)
            if(matrix[0][j] == '1') {dp[0][j] = 1;max = 1;}
            
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][j] == '1'){
                    int min = dp[i][j-1];
                    if(dp[i-1][j] < min) min = dp[i-1][j];
                    if(dp[i-1][j-1] < min) min = dp[i-1][j-1];
                    dp[i][j] = min+1;
                    if(max < min+1) max = min+1;
                }
            }
        }
        return max*max;
    }
}

//other solution
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int [] arr = new int [n];
        int max = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == '0') arr[j] = 0;
                else arr[j]++;
            }
            for(int j = 0;j < n;j++){
                int local = arr[j];
                for(int k = j; k < j+ arr[j] && k < n;k++){
                    if(local > arr[k]) local = arr[k];
                    if(k-j+1 <= local && max < k-j+1) max = k-j+1;
                }
            }
        }
        return max*max;
    }
}
