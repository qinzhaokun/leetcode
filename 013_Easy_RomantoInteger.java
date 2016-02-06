/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Subscribe to see which companies asked this question
*/

public class Solution {
    public int romanToInt(String s) {
        int re = 0;
        for (int i = 0;i < s.length();i++) {
            char t = s.charAt(i);
            if(t=='M') {
                re += 1000;
            }
            else if(t == 'D') {
                re += 500;
            }
            else if (t == 'C') {
                if (i+1 < s.length() && (s.charAt(i+1)== 'D' || s.charAt(i+1) == 'M')) {
                    re -= 100;
                } 
                else {
                    re += 100;
                }
            }
            else if (t == 'L') {
                re += 50;
            }
            else if (t == 'X') {
                if (i+1 < s.length() && (s.charAt(i+1)== 'L' || s.charAt(i+1) == 'C')) {
                    re -= 10;
                } 
                else {
                    re += 10;
                }
            }
            else if (t == 'V') {
                re += 5;
            }
            else if (t == 'I') {
                if (i+1 < s.length() && (s.charAt(i+1)== 'V' || s.charAt(i+1) == 'X')) {
                    re -= 1;
                } 
                else {
                    re += 1;
                }
            }
        }
        return re;
    }
}
