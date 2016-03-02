/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int rl = 0;
        int rr = n-1;
        int cl = 0;
        int cr = n-1;
        int i = 1;
        int [][] matrix = new int [n][n];
        while(i <= n*n){
            for(int j = cl;j <= cr;j++){
                matrix[rl][j] = i++;
            }
            for(int j = rl+1;j <= rr;j++){
                matrix[j][cr] = i++;
            }
            for(int j = cr-1;j >= cl;j--){
                matrix[rr][j] = i++;
            }
            for(int j = rr-1;j >= rl+1;j--){
                matrix[j][cl] = i++;
            }
            cl++;
            rl++;
            cr--;
            rr--;
        }
        return matrix;
    }
}
