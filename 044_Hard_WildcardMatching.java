/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

*/


//dynamic programming solution
public class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean [][] isM = new boolean [n+1][m+1];
        if(m == 0){
            return n == 0;
        }
        if(n == 0){
            for(int i = 0;i < m;i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        
        isM[0][0] = true;
        for(int j = 1;j <= m;j++){
            if(p.charAt(j-1) == '*'){
                isM[0][j] = true;
            }
            else{
                break;
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(p.charAt(j) == '?'){
                    isM[i+1][j+1] = isM[i][j];
                }
                else if(p.charAt(j) == '*'){
                //isM[i+1][j] --- * represent empty
                //isM[i][j+1] --- * represent one or more
                    isM[i+1][j+1] = (isM[i+1][j] || isM[i][j+1]);
                }
                else{
                    isM[i+1][j+1] = (isM[i][j] && p.charAt(j) == s.charAt(i));
                }
            }
        }
        return isM[n][m];
    }
}


//greddy solution
﻿﻿﻿boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
}
