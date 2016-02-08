/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Subscribe to see which companies asked this question
*/


public class Solution {
    public boolean isValid(String s) {
        Stack a = new Stack();
        for (int i = 0;i < s.length();i++) {
            if(!a.empty()&&isvaild(a.peek().toString().charAt(0),s.charAt(i))) {
                a.pop();
            }
            else {
                a.push(s.charAt(i));
            }
        }
        if(a.empty()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    boolean isvaild(char l,char r) {
        if((l=='{'&&r=='}')||(l=='('&&r==')')||(l=='['&&r==']')) {
            return true;
        }
        else {
            return false;
        }
    }
}
