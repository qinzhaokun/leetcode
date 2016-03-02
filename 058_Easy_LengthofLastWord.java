/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        while(i >= 0 && s.charAt(i)==' '){
            i--;
        }
        int sum = 0;
        if(i >= 0){
            while(i >= 0 && s.charAt(i)!=' '){
                i--;
                sum++;
            }
            return sum;
        }
        else{
            return 0;
        }
    }
}
