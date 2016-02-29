/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
    int total;
    public int totalNQueens(int n) {
        total = 0;
        if(n == 0){
            return 0;
        }
        boolean [][] m = new boolean [n][n];
        backtrack(0,m);
        return total;
    }
    
     void backtrack(int i, boolean [][] m){
        if(i == m.length){
            total++;
        }
        else{
            for(int j = 0;j < m.length;j++){
                if(isValid(i,j,m)){
                    m[i][j] = true;
                    backtrack(i+1,m);
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
