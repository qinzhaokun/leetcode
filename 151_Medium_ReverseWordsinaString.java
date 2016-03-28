/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/


public class Solution {
    public String reverseWords(String s) {
        if(s == null) return s;
        s = s.trim();
        
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        while(i >= 0){
            int j = i;
            while(j >= 0 && s.charAt(j) != ' ') j--;
            if(j != -1 && j != i) sb.append(s.substring(j+1,i+1) + " ");
            else if(j == -1 && j != i) sb.append(s.substring(j+1,i+1));
            i = j-1;
        }
        return sb.toString();
    }
}
