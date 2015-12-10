/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        boolean hasE = false;
        boolean hasDot = false;
        boolean hasNumber = false;
        
        for (int i = 0; i < s.length(); i++) {
            // e cannot be the first character
            if (i == 0 && s.charAt(i) == 'e') return false;
            if (s.charAt(i) == 'e') {
                // e cannot be replicated nor placed before number
                if (hasE == true || hasNumber == false) {
                    return false;
                } else {
                	hasE = true;
                }
            } 
            
            if (s.charAt(i) == '.') {
                // '.' cannot be replicated nor placed after 'e'
            	if (hasDot == true || hasE == true) {
                	return false;
                } else {
                	hasDot = true;
                }
            }
            // the sign can be placed at the beginning or after 'e'
            if (i != 0 && s.charAt(i - 1) != 'e' && (s.charAt(i) == '+' || s.charAt(i) == '-')) return false;
            
            // no other chacraters except '+', '-', '.', and 'e'
            if ((s.charAt(i) > '9' || s.charAt(i) < '0') && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '.' && s.charAt(i) != 'e')
            return false;  
            
            // check whether numbers are included.
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                hasNumber = true;
            }
        }
        // '+', '-', and 'e' cannot be the last character
        if (s.charAt(s.length() - 1) == '-' || s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == 'e') return false;

        return hasNumber;
    }
}
