/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int [] map1 = new int [128];
        int [] map2 = new int [128];
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        int i = 0;
        while(i < n){
            int si = s.charAt(i) - ' ';
            int ti = t.charAt(i) - ' ';
            if(map1[si] != map2[ti]) return false;
            map1[si] = i+1;
            map2[ti] = i+1;
            i++;
        }
        return true;
    }
}
