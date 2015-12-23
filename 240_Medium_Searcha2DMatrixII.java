/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

//Solution one
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0){
            return false;
        }
        int m = matrix[0].length;
        return find(matrix,target,0,n-1,0,m-1);
    }
    
    boolean find(int [][] m, int target, int startI, int endI, int startJ,int endJ){
        if(startI > endI || startJ > endJ){
            return false;
        }
        int midI = (startI+endI)/2;
        int midJ = (startJ+endJ)/2;
        if(m[midI][midJ] == target){
            return true;
        }
        if(startI == endI && startJ == endJ){
            return false;
        }
        else if(m[midI][midJ] > target){
            return find(m,target,startI,midI-1,startJ,midJ-1) || find(m,target,midI,endI,startJ,midJ-1) || find(m,target,startI,midI-1,midJ,endJ);
        }
        else{
            return find(m,target,midI+1,endI,midJ+1,endJ) || find(m,target,midI+1,endI,startJ,midJ) || find(m,target,startI,midI,midJ+1,endJ);
        }
    }
}

//Solution two
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = 0;int j = matrix[0].length-1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
