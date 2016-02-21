/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [] vaild = new int[9];
        for(int i =0;i<9;i++){
            for(int w = 0;w<9;w++){
            vaild[w]= 0;
            }
            for(int j =0;j<9;j++){
                if(board[i][j]!='.'){
                    int k = board[i][j]-'1';
                    if(vaild[k]>0){
                        return false;
                    }
                    else{
                        vaild[k]=1;
                    }
                }
            }
        }
        
        for(int i = 0;i<9;i++){
            vaild[i]= 0;
        }
        for(int i =0;i<9;i++){
            for(int w = 0;w<9;w++){
                vaild[w]= 0;
            }
            for(int j =0;j<9;j++){
                if(board[j][i]!='.'){
                    int k = board[j][i]-'1';
                    if(vaild[k]>0){
                        return false;
                    }
                    else{
                        vaild[k]=1;
                    }
                }
            }
        }
        
        for(int i =0;i<9;i+=3){
            for(int j =0;j<9;j+=3){
                for(int w = 0;w<9;w++){
                    vaild[w]= 0;
                }
                for(int k1=i;k1<i+3;k1++){
                    for(int k2=j;k2<j+3;k2++){
                        if(board[k1][k2]!='.'){
                            int k = board[k1][k2]-'1';
                            if(vaild[k]>0){
                                return false;
                            }
                            else{
                                vaild[k]=1;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
