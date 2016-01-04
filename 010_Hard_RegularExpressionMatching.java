/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int slen=s.length();
        int plen=p.length();
        boolean [][] a = new boolean [slen+1][plen+1]; //a[i][j] represent s[0..i-1] and p[0..j-1] are match?
        a[0][0] = true; //two empty string are matching.
        // if p is empty, any s except empty will not match.
        for(int i = 1;i < slen+1;i++){
            a[i][0] = false;
        }
        // if s is empty, if p[0,j-1] matchs empty, iff p.charAt(j-1) == '*' and p[0..j-3] matchs. 
        for(int j = 2;j < plen+1;j++){
            a[0][j] = (p.charAt(j-1) == '*'&& a[0][j-2]);
        }
        
        /**
         * a[i+1][j+1]: if s[0..i] matches p[0..j]
         * if p[j] != '*'
         *      a[i+1][j+1] = f[i][j] && (s[i] == p[j] || p[j] == '.')
         * if p[j] == '*', denote p[j - 1] with x
         *      f[i+1][j+1] is true iff any of the following is true
         *      1) "x*" repeats 0 time and matches empty: f[i+1][j - 1]
         *      2) "x*" repeats >= 1 times and matches "x*x": s[i] == x && f[i][j+1]
         * '.' matches any single character
         */
        for(int i = 0;i < slen;i++){
            for(int j = 0;j < plen;j++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    a[i+1][j+1] = a[i][j];
                }
                else if(p.charAt(j) == '*'){
                    a[i+1][j+1] = a[i+1][j-1] || (a[i][j+1] && (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'));
                }
            }
        }
        return a[slen][plen];
    }
}
