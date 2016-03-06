/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        boolean [][] isvisit = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    isvisit[i][j] = true;
                    if(dfs(board,i,j,word.substring(1),isvisit)){
                        isvisit[i][j] = false;
                        return true;
                    }
                     isvisit[i][j] = false;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char [][] b, int i, int j, String w, boolean [][]is){
        if(w.length() == 0){
            return true;
        }
        else{
            int [][] d = {{-1,0},{1,0},{0,1},{0,-1}};
            for(int k = 0;k < d.length;k++){
                int newI = i + d[k][0];
                int newJ = j + d[k][1];
                if(newI>=0 && newI<b.length && newJ>=0 && newJ< b[0].length && !is[newI][newJ] && b[newI][newJ] == w.charAt(0)){
                    is[newI][newJ] = true;
                    if(dfs(b,newI,newJ,w.substring(1),is)){
                        is[newI][newJ] = false;
                        return true;
                    }
                    is[newI][newJ] = false;
                }
            }
            return false;
        }
    }
}
