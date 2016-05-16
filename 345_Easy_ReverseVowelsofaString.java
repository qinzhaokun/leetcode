/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
*/

public class Solution {
    public String reverseVowels(String s) {
        char [] arrs = s.toCharArray();
        
        int i = 0;int j = arrs.length-1;
        while(i < j){
            while(i < j && !isVowel(arrs[i])) i++;
            while(i < j && !isVowel(arrs[j])) j--;
            if(i < j){
                char tmp = arrs[i];
                arrs[i] = arrs[j];
                arrs[j] = tmp;
                i++;
                j--;
            }
        }
        
        return new String(arrs);
    }
    
    boolean isVowel(char a){
        if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') return true;
        else if(a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') return true;
        else return false;
    }
}
