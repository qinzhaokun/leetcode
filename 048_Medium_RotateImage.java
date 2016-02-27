/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/


//my solution
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i < n/2;i++){
            for(int j = i;j < n-i;j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
            for(int j = i+1;j < n-1-i;j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = tmp;
            }
            int tmp1 = matrix[n-1-i][i];
            matrix[n-1-i][i] = matrix[n-1-i][n-1-i];
            matrix[n-1-i][n-1-i] = tmp1;
            for(int j = i+1;j < n-1-i;j++){
                int tmp = matrix[n-1-i][j];
                matrix[n-1-i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}

//standard solution
public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
