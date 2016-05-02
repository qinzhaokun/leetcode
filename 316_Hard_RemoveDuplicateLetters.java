/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/

public class Solution {
    public String removeDuplicateLetters(String s) {
        int [] count = new int [26];
        for(int i = 0;i < s.length();i++) count[s.charAt(i)-'a']++;
        boolean [] shown = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            int index = s.charAt(i)-'a';
            if(!shown[index]){
                while(!stack.isEmpty() && stack.peek() > s.charAt(i) && count[stack.peek()-'a']>0){
                    shown[stack.pop()-'a'] = false;
                }
                shown[index] = true;
                stack.push(s.charAt(i));
            }
            count[index]--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0,stack.pop());
        return sb.toString();
    }
}
