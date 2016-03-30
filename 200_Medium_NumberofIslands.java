/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/


public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        boolean [][]isV = new boolean [m][n];
        int count = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == '1' && !isV[i][j]) {dfs(grid,i,j,isV);count++;}
            }
        }
        return count;
    }
    
    void dfs(char[][] grid, int i, int j, boolean [][] isV){
        int [][] d = {{1,0},{-1,0},{0,1},{0,-1}};
        isV[i][j] = true;
        for(int k = 0;k < 4;k++){
            int newI = i + d[k][0];
            int newJ = j + d[k][1];
            if(newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && !isV[newI][newJ] && grid[newI][newJ] == '1'){
                dfs(grid,newI,newJ,isV);
            }
        }
    }
}
