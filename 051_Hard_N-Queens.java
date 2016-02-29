/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> re = new ArrayList<>();
        if(n == 0){
            return re;
        }
        boolean [][] m = new boolean [n][n];
        backtrack(0,m,re);
        return re;
    }
    
    void backtrack(int i, boolean [][] m,List re){
        if(i == m.length){
            List<String> tmp1 = new ArrayList<>();
            for(int j = 0;j < m.length;j++){
                StringBuilder tmp = new StringBuilder();
                for(int k = 0;k < m[0].length;k++){
                    if(m[j][k]) tmp.append("Q");
                    else tmp.append(".");
                }
                tmp1.add(tmp.toString());
            }
            re.add(tmp1);
        }
        else{
           for(int j = 0;j < m.length;j++){
            if(isValid(i,j,m)){
                m[i][j] = true;
                backtrack(i+1,m,re);
                m[i][j] = false;
            }
           } 
        }
    }
    
    boolean isValid(int i, int j, boolean [][] m){
        for(int k = i-1;k >= 0;k--){
            if(m[k][j]){
                return false;
            }
        }
        int k = i-1;int t = j-1;
        while(k >= 0 && t >= 0){
            if(m[k][t]){
                return false;
            }
            k--;
            t--;
        }
        k = i-1;t=j+1;
        while(k >= 0 && t < m[0].length){
            if(m[k][t]){
                return false;
            }
            k--;
            t++;
        }
        return true;
    }
}
