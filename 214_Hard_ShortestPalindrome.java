/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int n = s.length();
        int start = n/2 - (n%2==0?1:0);
        for(int i = start;i >= 0;i--){
        	int j = i;
            int k = i+1;
            while(j >=0 && k < n && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }
            if(j < 0){
                return new StringBuilder(s.substring(k)).reverse() + s;
            }
            j = 1;
            while(i-j >= 0 && i+j < n && s.charAt(i-j) == s.charAt(i+j)){
                j++;
            }
            if(i - j < 0){
                return new StringBuilder(s.substring(i+j)).reverse() + s;
            }
            
        }
        return new StringBuilder(s.substring(1)).reverse() + s;
    }
}


public class Solution {
    public String shortestPalindrome(String s) {
         int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == s.charAt(j)) { j += 1; }
    }
    if (j == s.length()) { return s; }
    String suffix = s.substring(j);
    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}
