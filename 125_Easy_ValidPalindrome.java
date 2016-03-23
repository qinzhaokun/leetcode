
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/


public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            while(i < s.length()&&isValid(s.charAt(i)) == -1){
                i++;
            }
            while(j >= 0&&isValid(s.charAt(j)) == -1){
                j--;
            }
            if(i < j){
               int ia = s.charAt(i)-'a';
               int iA = s.charAt(i)-'A';
               int ja = s.charAt(j)-'a';
               int jA = s.charAt(j)-'A';
               if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                   i++;
                   j--;
               }
               else{
                   return false;
               }
            }
        }
        return true;
    }
    
    int isValid(char t){
        if(t - 'a' >= 0 && t-'a'<=25){
            return 1;
        }
        else if(t - 'A' >= 0 && t-'A'<=25){
            return 2;
        }
        else if(t - '0' >=0 && t-'0' <= 9){
            return 3;
        }
        else{
            return -1;
        }
    }
}
