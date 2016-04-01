/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
*/


public class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        List<String> re = new ArrayList<>();
        for(int i = 0;i < words.length;i++){
            String tmp = words[i];
            Trie cur = root;
            for(int j = 0;j < tmp.length();j++){
                int index = tmp.charAt(j)-'a';
                if(cur.arr[index] == null) cur.arr[index] = new Trie();
                cur = cur.arr[index];
            }
            cur.edge = true;
        }
        boolean [][] isV = new boolean [board.length][board[0].length];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(root.arr[board[i][j]-'a'] != null){
                    StringBuilder tmp = new StringBuilder();
                    tmp.append(board[i][j]);
                    if(root.arr[board[i][j]-'a'].edge){
                        if(!re.contains(tmp.toString())) re.add(tmp.toString());
                    }
                    dfs(board,i,j,re,tmp,root.arr[board[i][j]-'a'], isV);
                }
            }
        }
        return re;
    }
    
    void dfs(char [][] board, int i, int j, List re, StringBuilder tmp, Trie root,boolean [][]isV){
        int d[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        isV[i][j] = true;
        for(int k = 0;k < 4;k++){
            int I = i+d[k][0];
            int J = j+d[k][1];
            if(I >= 0 && I < board.length && J >= 0 && J < board[0].length && !isV[I][J]){
                if(root.arr[board[I][J]-'a'] != null){
                    tmp.append(board[I][J]);
                    if(root.arr[board[I][J]-'a'].edge){
                        if(!re.contains(tmp.toString())) re.add(tmp.toString());
                    }
                    dfs(board,I,J,re,tmp,root.arr[board[I][J]-'a'], isV);
                    tmp.deleteCharAt(tmp.length()-1);
                }
            }
        }
        isV[i][j] = false;
    }
}


class Trie{
        Trie [] arr;
        boolean edge;
        
        Trie(){
            arr = new Trie[26];
            edge = false;
        }
    }
