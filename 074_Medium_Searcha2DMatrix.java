/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        else{
            return find(matrix,0,m-1,0,matrix[0].length-1,target);
        }
    }
    
    boolean find(int [][]m, int rowl,int rowr,int coll,int colr,int target){
        if(rowl == rowr && coll == colr){
            return target == m[rowl][coll];
        }
        else if(rowl > rowr || coll > colr){
            return false;
        }
        else {
            int midRow = rowl + (rowr-rowl)/2;
            int midCol = coll + (colr-coll)/2;
            if(m[midRow][midCol] == target){
                return true;
            }
            else if(m[midRow][midCol] < target){
                return (find(m,midRow,rowr,midCol+1,colr,target) || find(m,midRow+1,rowr,coll,midCol,target));
            }
            else{
                return (find(m,rowl,midRow,coll,midCol-1,target) || find(m,rowl,midRow-1,midCol,colr,target));
            }
        }
    }
}
