/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/

//recursive
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n != m){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        int [] tmp = new int [129];
        for(int i = 0;i < s1.length();i++){
            tmp[s1.charAt(i)-' ']++;
        }
        for(int i = 0;i < s2.length();i++){
            tmp[s2.charAt(i)-' ']--;
            if(tmp[s2.charAt(i)-' '] < 0){
                return false;
            }
        }
        for(int i = 1;i < n;i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i,n),s2.substring(i,n))){
                return true;
            }
            if(isScramble(s1.substring(0,i),s2.substring(n-i,n)) && isScramble(s1.substring(i,n),s2.substring(0,n-i))){
                return true;
            }
        }
        
        return false;
    }
}

//dp
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n != m){
            return false;
        }
        int [] tmp = new int [129];
        for(int i = 0;i < s1.length();i++){
            tmp[s1.charAt(i)-' ']++;
        }
        for(int i = 0;i < s2.length();i++){
            tmp[s2.charAt(i)-' ']--;
            if(tmp[s2.charAt(i)-' '] < 0){
                return false;
            }
        }
        boolean [][][] is = new boolean [n][n][n+1];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    is[i][j][1] = true;
                }
            }
        }
        
        for(int k = 2;k <= n;k++){
            for(int i = 0;i+k <= n;i++){
                for(int j = 0;j+k <= n;j++){
                    for(int t = 1;t < k;t++){
                        if((is[i][j][t] && is[i+t][j+t][k-t]) || (is[i][j+k-t][t] && is[i+t][j][k-t])){
                            is[i][j][k] = true;
                            break;
                        }
                    }
                }
                
            }
        }
        return is[0][0][n];
    }
}
