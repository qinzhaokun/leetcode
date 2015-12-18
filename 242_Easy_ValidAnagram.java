/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        int [] bits = new int [26];
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0;i < s.length();i++){
            bits[s.charAt(i)-'a']++;
        }
        for(int i = 0;i < t.length();i++){
            bits[t.charAt(i)-'a']--;
            if(bits[t.charAt(i)-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
