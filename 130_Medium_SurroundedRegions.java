/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if(n == 0){
            return;
        }
        int m = board[0].length;
        for(int i = 0;i < m;i++){
            if(board[0][i] == 'O'){
                board[0][i] = 'E';
                bfs(board,0,i,n,m);
            }
        }
        for(int i = 1;i < n;i++){
            if(board[i][m-1] == 'O'){
                board[i][m-1] = 'E';
                bfs(board,i,m-1,n,m);
            }
        }
        for(int i = m-2;i >=0;i--){
            if(board[n-1][i] == 'O'){
                board[n-1][i] = 'E';
                bfs(board,n-1,i,n,m);
            }
        }
        for(int i = n-1;i >=1;i--){
            if(board[i][0] == 'O'){
                board[i][0] = 'E';
                bfs(board,i,0,n,m);
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'E'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    void bfs(char [][] board, int x, int y,int n,int m){
        int [][]a = {{-1,0},{0,-1},{1,0},{0,1}};
        LinkedList queue = new LinkedList();
        for(int i = 0;i < 4;i++){
            int x1 = x + a[i][0];
            int y1 = y + a[i][1];
            if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m){
                continue;
            }
            if(board[x1][y1] == 'O'){
                board[x1][y1] = 'E';
                queue.add(x1*m+y1);
            }
        }
        while(!queue.isEmpty()){
            int now = (int)queue.poll();
            int x2 = now/m;
            int y2 = now%m;
            for(int i = 0;i < 4;i++){
                int x1 = x2 + a[i][0];
                int y1 = y2 + a[i][1];
                if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m){
                    continue;
                }
                if(board[x1][y1] == 'O'){
                    board[x1][y1] = 'E';
                    queue.add(x1*m+y1);
                }
            }
        }
    }
}
